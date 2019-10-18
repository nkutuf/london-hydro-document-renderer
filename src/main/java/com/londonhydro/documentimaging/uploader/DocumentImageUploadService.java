package com.londonhydro.documentimaging.uploader;

import com.londonhydro.documentimaging.eventing.DocumentImageProducer;
import com.londonhydro.documentimaging.transformation.TemplateFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

/**
 * BillImageUploaderService loads all documents to Kafka or Mongo Db
 * author: Faisal Nkutu
 * date: September 04 2019
 */
@Slf4j
@Component
public class DocumentImageUploadService {
    private final DocumentImageProducer documentImageProducer;
    public DocumentImageUploadService(DocumentImageProducer documentImageProducer) {
        this.documentImageProducer = documentImageProducer;
    }
    String letterDirectoryPath = "./src/main/resources/bills" + "billImageFile-";
    @Async
    @Scheduled(fixedRate = 9000000)
    private  void getBillDocumentData() {
        try {
            log.info("Iterate through directory...........");
            String billDirectoryPath = "/Users/faisal/Downloads/bills/";
            File dir = new File(billDirectoryPath);
            File[] directoryListing = dir.listFiles();
            if (directoryListing != null) {
                for (File xmlBillFile : directoryListing) {
                    log.info("Uploading........" + xmlBillFile.getName());
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    dbFactory.setNamespaceAware(true);
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(xmlBillFile);

                    doc.getDocumentElement().normalize();

                    log.info("Send bill file to Kafka topic..........." + xmlBillFile.getName());
                    documentImageProducer.produceBillImage(doc);

                    //Optional 1 Save without Kafka
                    TemplateFactory templateFactory = new TemplateFactory();
                    templateFactory.createBillTemplate(xmlBillFile.getName(),doc);

                    //xmlBillFile.delete();
                    log.info("Delete bill file from directory to avoid reuse ..........." + xmlBillFile.getName());

                }
            } else {
                // Handle the case where dir is not really a directory.
                // Checking dir.isDirectory() above would not be sufficient
                // to avoid race conditions with another process that deletes
                // directories.
            }


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
    //@Async
    //@Scheduled(fixedRate = 9000000)
    private  void getLetterDocumentData() {
        try {
            log.info("Iterate through directory...........");
            String billDirectoryPath = "/Users/faisal/Downloads/bills/";
            File dir = new File(billDirectoryPath);
            File[] directoryListing = dir.listFiles();
            if (directoryListing != null) {
                for (File xmlLetterFile : directoryListing) {
                    log.info("Uploading........" + xmlLetterFile.getName());
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    dbFactory.setNamespaceAware(true);
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(xmlLetterFile);

                    doc.getDocumentElement().normalize();
                    NodeList letterNode =doc.getElementsByTagName("Letter");

                    if (doc.hasChildNodes()) {
                        getReferencerID(doc.getChildNodes(),letterDirectoryPath,doc);
                    }

                    log.info("Send bill file to Kafka topic..........." + xmlLetterFile.getName());
                    //////nkutu documentImageProducer.produceBillImage(doc);

                }
            } else {
                // Handle the case where dir is not really a directory.
                // Checking dir.isDirectory() above would not be sufficient
                // to avoid race conditions with another process that deletes
                // directories.
            }


        } catch (ParserConfigurationException | SAXException | IOException /*| TransformerException*/ e) {
            e.printStackTrace();
        }
    }
    public  void printXmlDocument(Document document,  String billDirectoryPath, String fileName) {
        DOMImplementationLS domImplementationLS =
                (DOMImplementationLS) document.getImplementation();
        LSSerializer lsSerializer =
                domImplementationLS.createLSSerializer();
        String letterData = lsSerializer.writeToString(document);
        try {

            log.info("printing Xml Document: " + letterDirectoryPath + fileName + ".xml");
            File letterXMLFile = new File(letterDirectoryPath + fileName + ".xml");
            //Create the file
            if (letterXMLFile.createNewFile()){
                log.info("File is created!");
            }else{
                log.info("File already exists.");
            }
            //Write Content
            FileWriter writer = new FileWriter(letterXMLFile);

            writer.write(letterData.replace("UTF-16","UTF-8"));
            writer.close();

            //Optional 1 Save without Kafka
            TemplateFactory templateFactory = new TemplateFactory();
            log.info("Save without Kafka:  " + letterXMLFile.getName());
            templateFactory.createBillTemplate(letterXMLFile.getName(),null);

            letterXMLFile.delete();
            log.info("Delete bill file from directory to avoid reuse ..........." + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //log.info(document.toString());
    }
    private void  getReferencerID(NodeList letterNode, String billDirectoryPath, Document doc) {
        String letterValue = null;

        for (int count = 0; count < letterNode.getLength(); count++) {

            Node tempNode = letterNode.item(count);

            // make sure it's element node.
            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

                // get node name and value
                if(tempNode.getNodeName().equalsIgnoreCase("ReferenceId")) {
                    letterValue = tempNode.getTextContent();
                    passFileName(doc,letterDirectoryPath,letterValue);
                }

                if (tempNode.hasAttributes()) {

                    // get attributes names and values
                    NamedNodeMap nodeMap = tempNode.getAttributes();

                    for (int i = 0; i < nodeMap.getLength(); i++) {

                        Node node = nodeMap.item(i);
                        log.info("attr name : " + node.getNodeName());
                        log.info("attr value : " + node.getNodeValue());

                    }

                }

                if (tempNode.hasChildNodes()) {

                    // loop again if has child nodes
                    getReferencerID(tempNode.getChildNodes(),letterDirectoryPath,doc);

                }


            }

        }

    }

    private  void passFileName(Document doc, String billDirectoryPath, String letterName) {
        NodeList letterNodes =doc.getElementsByTagName("Letter");
        try{
            for (int i = 0; i < letterNodes.getLength(); i++) {

                Node nNode = letterNodes.item(i);
                Node elem = letterNodes.item(i);//Your Node
                StringWriter buf = new StringWriter();
                Transformer xform = TransformerFactory.newInstance().newTransformer();
                xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes"); // optional
                xform.setOutputProperty(OutputKeys.INDENT, "yes"); // optional
                xform.transform(new DOMSource(elem), new StreamResult(buf));
                if (buf.toString().contains(letterName)){

                    Document newXmlDocument = DocumentBuilderFactory.newInstance()
                            .newDocumentBuilder().newDocument();
                    Node copyNode = newXmlDocument.importNode(nNode, true);
                    newXmlDocument.appendChild(copyNode);
                    printXmlDocument( newXmlDocument,   letterDirectoryPath,  letterName);
                }

            }
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();

        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }
}

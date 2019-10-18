package com.londonhydro.documentimaging.transformation;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class TestXML {
    public  void load(File path) {
        //String exp = "/configs/markets/market/";
        String exp = "/BatchLetters/Letters";
        //String path = "src/a/testConfig.xml";
        try {
            Document xmlDocument = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().parse(path);

            XPath xPath = XPathFactory.newInstance().newXPath();
            XPathExpression xPathExpression = xPath.compile(exp);
            NodeList nodes = (NodeList) xPathExpression.
                    evaluate(xmlDocument, XPathConstants.NODESET);

            Document newXmlDocument = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder().newDocument();
            //Element root = newXmlDocument.createElement("root");
            //newXmlDocument.appendChild(root);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                Node copyNode = newXmlDocument.importNode(node, true);
                newXmlDocument.appendChild(copyNode);
                //root.appendChild(copyNode);
            }

            printXmlDocument(newXmlDocument);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void printXmlDocument(Document document) {
        DOMImplementationLS domImplementationLS =
                (DOMImplementationLS) document.getImplementation();
        LSSerializer lsSerializer =
                domImplementationLS.createLSSerializer();
        String string = lsSerializer.writeToString(document);
        System.out.println(string);
    }
}

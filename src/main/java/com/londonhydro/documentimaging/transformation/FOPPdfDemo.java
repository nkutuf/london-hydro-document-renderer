package com.londonhydro.documentimaging.transformation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.londonhydro.documentimaging.database.DocumentImageRepositoryManager;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

public class FOPPdfDemo {

    public static void main(String[] args) {
        FOPPdfDemo fOPPdfDemo = new FOPPdfDemo();
        try {
            fOPPdfDemo.convertToPDF();
            //fOPPdfDemo.convertToFO();
        } catch (FOPException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Method that will convert the given XML to PDF
     *
     * @throws IOException
     * @throws FOPException
     * @throws TransformerException
     */
    public void convertToPDF() throws IOException, FOPException, TransformerException {

        // the XSL FO file
        File xsltFile = new File("./src/main/resources/LetterOfReference5.xsl");
        // the XML file which provides the input
        StreamSource xmlSource = new StreamSource(new File("./src/main/resources/billImageFile-LTR000000064112.xml"));
        // create an instance of fop factory
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        // a user agent is needed for transformation
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        // Setup output
        OutputStream out = null;
        File pdfFile = null;

        try {
            out = new java.io.FileOutputStream("./src/main/resources/employees4.pdf");
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            // Resulting SAX events (the generated FO) must be piped through to FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start XSLT transformation and FOP processing
            // That's where the XML is first transformed to XSL-FO and then
            // PDF is created
            transformer.transform(xmlSource, res);
            /////String billImageFile = "billImageFile-" + fileName.replaceFirst(".XML",".pdf");
            //drawTemplate(chart, 900, 400, billImageFile,billImageModel);
            DocumentImageRepositoryManager documentImageRepositoryManager = new DocumentImageRepositoryManager();
            //documentImageRepositoryManager.saveFile(new File(billImageFile));
            pdfFile = new File(out.toString());
            documentImageRepositoryManager.saveFile(pdfFile);
            System.out.println("Test..................>");


        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (FOPException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                    pdfFile.delete();
                    System.out.println("deleted file....");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Method that will convert the given XML to PDF
     *
     * @throws IOException
     * @throws FOPException
     * @throws TransformerException
     */
    public void convertToPDFOld() throws IOException, FOPException, TransformerException {
        // the XSL FO file
        File xsltFile = new File("/Users/faisal/Downloads/template2.xsl");
        // the XML file which provides the input
        StreamSource xmlSource = new StreamSource(new File("/Users/faisal/Downloads/Employees2.xml"));
        // create an instance of fop factory
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        // a user agent is needed for transformation
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        // Setup output
        OutputStream out;
        out = new java.io.FileOutputStream("/Users/faisal/Downloads/employee.pdf");

        try {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            // Resulting SAX events (the generated FO) must be piped through to FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start XSLT transformation and FOP processing
            // That's where the XML is first transformed to XSL-FO and then
            // PDF is created
            transformer.transform(xmlSource, res);
        } finally {
            out.close();
        }
    }

    /**
     * This method will convert the given XML to XSL-FO
     *
     * @throws IOException
     * @throws FOPException
     * @throws TransformerException
     */
    public void convertToFO() throws IOException, FOPException, TransformerException {
        // the XSL FO file
        File xsltFile = new File("/Users/faisal/Downloads/template.xsl");

        /*TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource
          ("F:\\Temp\\template.xsl"));*/

        // the XML file which provides the input
        StreamSource xmlSource = new StreamSource(new File("/Users/faisal/Downloads/Employees.xml"));

        // a user agent is needed for transformation
        /*FOUserAgent foUserAgent = fopFactory.newFOUserAgent();*/
        // Setup output
        OutputStream out;

        out = new java.io.FileOutputStream("/Users/faisal/Downloads/temp.fo");

        try {
            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            // Resulting SAX events (the generated FO) must be piped through to FOP
            //Result res = new SAXResult(fop.getDefaultHandler());

            Result res = new StreamResult(out);

            //Start XSLT transformation and FOP processing
            transformer.transform(xmlSource, res);


            // Start XSLT transformation and FOP processing
            // That's where the XML is first transformed to XSL-FO and then
            // PDF is created
            transformer.transform(xmlSource, res);
        } finally {
            out.close();
        }
    }
}
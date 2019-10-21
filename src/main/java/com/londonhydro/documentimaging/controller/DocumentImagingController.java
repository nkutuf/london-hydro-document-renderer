package com.londonhydro.documentimaging.controller;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.londonhydro.documentimaging.database.DocumentImageRepositoryManager;
import com.londonhydro.documentimaging.eventing.DocumentImageProducer;
import com.londonhydro.documentimaging.transformation.DocumentImageModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.json.JSONObject;
/**
 * DocumentImagingController for REST API
 * author: Faisal Nkutu
 * date: September 04 2019
 */
@Slf4j
@RestController
@RequestMapping(value= "/api")
public class DocumentImagingController {
    //@Autowired
    DocumentImageRepositoryManager serv = new DocumentImageRepositoryManager();
    private final DocumentImageProducer documentImageProducer;
    public DocumentImagingController(DocumentImageProducer documentImageProducer) {
        this.documentImageProducer = documentImageProducer;
    }
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Method to save documents in the db.
     * @param id
     * @return
     */
    @PostMapping(value= "/create/{document-id}")
    public String create(@PathVariable(value= "document-id") int id) {
        logger.debug("Saving documents.");
        //serv.createBillDocument(emp);
        return "Bill Image records created.";
    }
    /**
     * Method to fetch document by fileName.
     * @return
     */
    @GetMapping(value= "/getAll")
    @Produces("text/plain")
    public String getAllDocuments() {
        return serv.getAllFiles();
    }

    /**
     * Method to fetch document by fileName.
     * @param fileName
     * @param type
     * @return
     */
    @GetMapping(value= "/getbyid/{fileName}/type/{type}")
    protected void getFile( @PathVariable("fileName") String fileName, @PathVariable(value= "type") String type,HttpServletResponse response)
            throws IOException {
        try {

            Document document = new Document();
            fileName = fileName + "." + type;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos = serv.retrieveFile(fileName);
            PdfWriter.getInstance(document, serv.retrieveFile(fileName));
            OutputStream out = response.getOutputStream();

            PdfWriter.getInstance(document, out);

            // setting some response headers
            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control",
                    "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            // setting the content type
            response.setContentType("application/pdf");
            // the contentlength
            response.setContentLength(baos.size());
            // write ByteArrayOutputStream to the ServletOutputStream
            OutputStream os = response.getOutputStream();
            baos.writeTo(out);
            out.flush();
            out.close();
        }
        catch(DocumentException | ServletException e) {
            throw new IOException(e.getMessage());
        }
    }
    /**
     * Method to get pdf document by fileName.
     * @param type
     * @return
     */
    @GetMapping(value= "/letter/{type}")
    protected void doGet(HttpServletRequest request, HttpServletResponse response, @PathVariable(value= "type") String type) throws ServletException, IOException {
        try{
            FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
            System.out.println("transforming................1......................>");
            //Setup a buffer to obtain the content length
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            String xlsTemplate = "./src/main/resources/template.xsl";
            if (type.equalsIgnoreCase("bill")){
                xlsTemplate = "./src/main/resources/bill.xsl";
            }else if (type.equalsIgnoreCase("reminder")){
                xlsTemplate = "./src/main/resources/reminder.xsl";
            }
            xlsTemplate = "./src/main/resources/LondonHydroBill.xsl";
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xlsTemplate));
            //Make sure the XSL transformation's result is piped through to FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            //Setup input

            String xmlFile = "./src/main/resources/Bill2.xml";
            Source src = new StreamSource(new File(xmlFile));

            //Start the transformation and rendering process
            transformer.transform(src, res);
            System.out.println("transforming.......................data...............>");

            //Prepare response
            response.setContentType("application/pdf");
            response.setContentLength(out.size());

            //Send content to Browser
            response.getOutputStream().write(out.toByteArray());
            response.getOutputStream().flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Method to update document by fileName.
     * @param fileName
     * @return
     */
    @PutMapping(value= "/update/{fileName}")
    public String update(@PathVariable(value= "fileName") String fileName) {
        logger.debug("Updating document with fileName= {}.", fileName);
        //serv.saveFile(fileName);
        return "Bill Image record for fileName= " + fileName + " updated.";
    }

    /**
     * Method to delete document by fileName.
     * @param fileName
     * @return
     */
    @DeleteMapping(value= "/delete/{fileName}")
    public String delete(@PathVariable(value= "fileName") String fileName) {
        logger.debug("Deleting document with fileName= {}.", fileName);
        serv.deleteFile(fileName);
        return "Bill Image record for fileName= " + fileName + " deleted.";
    }

    /**
     * Method to fetch html document by fileName.
     * @param fileName
     * @return
     */
    @GetMapping(value= "/html/getbyid/{fileName}")
    protected void convertPdfToHtml( @PathVariable("fileName") String fileName  ,HttpServletResponse response)
            throws IOException {
        try {

            String pdfFileUrl = "http://127.0.0.1:8080/api/getbyid/" + fileName + "/type/pdf";
            URL url=new URL(pdfFileUrl);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            InputStream is=connection.getInputStream();

            PDDocument documents =PDDocument.load(is);
            Writer output = new PrintWriter(fileName +  ".html", "utf-8");
            new PDFDomTree().writeText(documents, output);

            File file = new File(fileName +  ".html");
            PrintWriter printWriter = new PrintWriter(response.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String st;

            while ((st = bufferedReader.readLine()) != null){
                printWriter.println(st);
            }

            printWriter.flush();
            printWriter.close();
            //socket.close();
            //serverSocket.close();
        }
        catch(ParserConfigurationException e) {
            throw new IOException(e.getMessage());
        }
    }
    @PostMapping(value= "/letter/{letterOfReferenceData}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createLetterOfReferenceTemplate(InputStream letterOfReferenceData) {
        StringBuilder letterOfReferenceBuilder = new StringBuilder();
        logger.info("Starting to Parse: - createLetterOfReferenceTemplate===>" + letterOfReferenceData);
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(letterOfReferenceData));
            String line = null;
            while ((line = in.readLine()) != null) {
                letterOfReferenceBuilder.append(line);
                logger.info("Line Parsing: - createLetterOfReferenceTemplate===>" + line);
            }
        } catch (Exception e) {
            logger.info("Error Parsing: - createLetterOfReferenceTemplate");
        }

        JSONObject json = new JSONObject(letterOfReferenceBuilder.toString());
        DocumentImageModel dim = new DocumentImageModel();
        for (Iterator fieldKey = json.keys(); fieldKey.hasNext();) {
            String field = (String) fieldKey.next();
            JSONObject name = (JSONObject) json.get(field);
            Iterator<String> ltrOfReference = name.keys();
            //replace Default Values for Document Image Model
            while (ltrOfReference.hasNext()) {
                String fieldKeys = ltrOfReference.next();
                String fieldValue = name.getString(fieldKeys);
                dim.setFirstParagraph(fieldValue);
                dim.setSecondParagraph(fieldValue);
                dim.setThirdParagraph(fieldValue);
                dim.setFourthParagraph(fieldValue);
                dim.setServiceType(fieldValue);
                dim.setSubject(fieldValue);
            }

        }
        log.info("Send letter object to Kafka topic..........." + letterOfReferenceBuilder);
        documentImageProducer.produceLetterImage(letterOfReferenceBuilder.toString());
        // return HTTP response 200 in case of success
        return Response.status(200).entity(letterOfReferenceBuilder.toString()).build();
    }
    /**
     * Method to fetch document by fileName.
     * @param fileName
     * @param type
     * @return
     */
    @GetMapping(value= "/searchFile/{fileName}/type/{type}")
    @Consumes(MediaType.APPLICATION_JSON)
    protected void searchFile( @PathVariable("fileName") String fileName, @PathVariable(value= "type") String type,HttpServletResponse response, InputStream letterOfReferenceData)
            throws IOException {
        try {

            Document document = new Document();
            fileName = fileName + "." + type;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            baos = serv.retrieveFile(fileName);
            PdfWriter.getInstance(document, serv.retrieveFile(fileName));
            OutputStream out = response.getOutputStream();

            PdfWriter.getInstance(document, out);

            // setting some response headers
            response.setHeader("Expires", "0");
            response.setHeader("Cache-Control",
                    "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Pragma", "public");
            // setting the content type
            response.setContentType("application/pdf");
            // the contentlength
            response.setContentLength(baos.size());
            // write ByteArrayOutputStream to the ServletOutputStream
            OutputStream os = response.getOutputStream();
            baos.writeTo(out);
            out.flush();
            out.close();
        }
        catch(DocumentException | ServletException e) {
            throw new IOException(e.getMessage());
        }
    }
}

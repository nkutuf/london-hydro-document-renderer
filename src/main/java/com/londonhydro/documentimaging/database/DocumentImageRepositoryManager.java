package com.londonhydro.documentimaging.database;


import com.mongodb.*;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.io.*;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

/**
 * DocumentImageRepositoryManager for Mongo DB
 * author: Faisal Nkutu
 * date: September 04 2019
 */
@Slf4j
@Service
public class DocumentImageRepositoryManager {
    //Mongo mongo = new Mongo("127.0.0.1", 27017);
    Mongo mongo = new Mongo("10.129.5.11", 8085);
    DB db = mongo.getDB("LHbillimagedb");
    DBCollection collection = db.getCollection("dummyColl");
    // create a "billImage" namespace
    GridFS gfsBillImage = new GridFS(db, "photo");
    public  void saveFile(File billPdfFile) {

        try {

            System.out.println("Saving file...............>" +  billPdfFile.getName());
            String newFileName = billPdfFile.getName();
            log.info("Save document into MongoDB....................." + billPdfFile);
            // get image file from local drive
            GridFSInputFile gfsFile = gfsBillImage.createFile(billPdfFile);

            // set a new filename for identify purpose
            gfsFile.setFilename(newFileName);

            // save the image file into mongoDB
            gfsFile.save(); //http://127.0.0.1:8080/api/delete/billsbillImageFilem-LTR000000064120.pdf

        } catch (UnknownHostException e) {
            //log.info(e.printStackTrace());
        } catch (MongoException e) {
            //log.info(e.printStackTrace());
        } catch (IOException e) {
            //log.info(e.printStackTrace());
        }

    }
    public  String getAllFiles() {

        StringBuffer sb = new StringBuffer();
        sb.append("<HTML><TABLE><br>");
        sb.append("LONDON HYDRO DOCUMENT RENDER FOR BILL IMAGES");
        sb.append("<br>" );
        try {

            DBCursor cursor = gfsBillImage.getFileList();
            while (cursor.hasNext()) {
                StringTokenizer st = new StringTokenizer(cursor.next().toString(),":,\"");
                while (st.hasMoreTokens()) {
                    String billImageName = st.nextToken();
                    if(billImageName.contains(".pdf")) {
                        String billImageLink = "<tr><td style=\'text-align:center\'><a href='" + "http://127.0.0.1:8080/api/getbyid/" + billImageName.substring(0,billImageName.indexOf(".pdf")) + "/type/pdf" + "'>" + billImageName + "</a></td>";
                        billImageLink =  billImageLink + "<td style=\'text-align:right\'><a href='http://127.0.0.1:8080/api/delete/" + billImageName + "'>" +  "delete"+ "</a></td>";
                        billImageLink =  billImageLink + "<td style=\'text-align:right\'><a href='http://127.0.0.1:8080/api/html/getbyid/" + billImageName + "'>" +  "html"+ "</a></td>";
                        billImageLink =  billImageLink + "</tr>";
                        sb.append(billImageLink);
                    }
                }
            }
        }catch (MongoException e) {
            //log.info(e.printStackTrace());
        }
        sb.append("<br></TABLE></HTML>");
        System.out.println(sb.toString());
        return sb.toString();
    }
    public ByteArrayOutputStream retrieveFile(String fileName)
            throws ServletException, IOException {
        GridFSDBFile imageForOutput = null;
        imageForOutput = gfsBillImage.findOne(fileName);
        byte[] b = org.apache.commons.io.IOUtils.toByteArray(imageForOutput.getInputStream());
        ByteArrayOutputStream baos = new ByteArrayOutputStream(b.length);
        baos.write(b, 0, b.length);
        return baos;
    }
    public GridFSDBFile retrievePDFile(String fileName)
            throws ServletException, IOException {
        GridFSDBFile imageForOutput = null;
        imageForOutput = gfsBillImage.findOne(fileName);
        return imageForOutput;
    }
    public  void deleteFile(String fileName) {

        try {
            // remove the image file from mongoDB
            fileName = fileName.trim() + ".pdf";
            System.out.println(fileName);
            gfsBillImage.remove(gfsBillImage.findOne(fileName));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
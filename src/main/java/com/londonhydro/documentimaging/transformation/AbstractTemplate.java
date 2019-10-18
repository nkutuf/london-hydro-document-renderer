package com.londonhydro.documentimaging.transformation;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;
import java.net.MalformedURLException;
/**
 * AbstractTemplate  for all Document types
 * author: Faisal Nkutu
 * date: September 04 2019
 */
public abstract class AbstractTemplate {
    Font textFontForAdress = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);
    public  void drawAdress(PdfContentByte cb, float xCoord, float yCoord, BillImageModel billImageModel, boolean isCustomer) throws DocumentException {


        PdfPTable table = new PdfPTable(1);
        float[] rows = {200f};
        table.setTotalWidth(rows);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.getDefaultCell().setFixedHeight(14f);

        if(isCustomer){
            table.addCell(new Phrase(new Chunk("London Hydro", textFontForAdress)));
            table.addCell(new Phrase(new Chunk("110 Horton Street", textFontForAdress)));
            table.addCell(new Phrase(new Chunk("London, Ontario", textFontForAdress)));
            table.addCell(new Phrase(new Chunk("N6B 1L4", textFontForAdress)));
        }

        table.writeSelectedRows(0, 4, xCoord, yCoord, cb);

    }
    public void drawLogo(PdfContentByte cb, String imagePath, float xPos, float yPos) throws MalformedURLException, IOException, DocumentException {
        //URL imageUrl = getClass().getResource(imagePath + "/IPAT_logo_Relaunch2016_RZ_RGB.jpg");
        final Image logoImage = Image.getInstance("/Users/faisal/Downloads/test.jpg");
        logoImage.setAbsolutePosition(xPos, yPos);
        logoImage.scalePercent(30f, 30f);
        cb.addImage(logoImage);
    }
    public void drawTermsOfStatement(PdfWriter writer, float xPos, float yPos) throws MalformedURLException, IOException, DocumentException {
        PdfPTable table = new PdfPTable(1);
        float[] rows = {1200f};
        table.setTotalWidth(rows);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.getDefaultCell().setFixedHeight(84f);
        table.addCell(new Phrase(new Chunk("Electricity: This is the cost of the electricity supplied to you during this billing period and is the part of the bill that is subject to competition.\n" +
                "        Delivery: These are the costs of delivering electricity from generating\n" +
                "        stations across the province to London Hydro, then to your home or business. This includes the costs to build and maintain the transmission\n" +
                "        and distribution lines, towers and poles and operate provincial and local electricity systems.\n" +
                "        A portion of these charges are fixed and do not change from month to month. The rest are variable and increase or decrease depending on the\n" +
                "        amount of electricity that you use.\n" +
                "        The delivery charge also includes costs related to electricity lost through\n" +
                "        distributing electricity to your home or business.* London Hydro collects\n" +
                "        this money and pays this amount directly to our suppliers.", textFontForAdress)));


        table.writeSelectedRows(0, 4, xPos, yPos, writer.getDirectContent());
    }
}



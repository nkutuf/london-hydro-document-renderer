package com.londonhydro.documentimaging.transformation;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.Font;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.londonhydro.documentimaging.database.DocumentImageRepositoryManager;

import lombok.extern.slf4j.Slf4j;
import org.apache.fop.apps.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;

import javax.imageio.ImageIO;
import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * BillImage Template
 * author: Faisal Nkutu
 * date: September 04 2019
 */
@Slf4j
public class MakeBillTemplate extends AbstractTemplate{

    /*public static void main(String args[]) throws Exception {
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        //drawTemplate(chart, 900, 400, "/Users/faisal/Downloads/MyBillPdf3.pdf");
    }*/
    public  void createLetterOfReference(String fileName,  BillImageModel billImageModel){

        log.info("Creating Letter of Reference:" + fileName);
        // the XSL FO file
        File xsltFile = new File("./src/main/resources/LetterOfReference6.xsl");
        // the XML file which provides the input
        //Old StreamSource xmlSource = new StreamSource(new File("./src/main/resources/SAP_20190924000001_batchletters.xml"));
        StreamSource xmlSource = new StreamSource(new File( "./src/main/resources/" +  fileName));
        // create an instance of fop factory
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        // a user agent is needed for transformation
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        // Setup output
        OutputStream out = null;


        try {
            String pdfName = "./src/main/resources/" +  fileName.replaceFirst(".xml",".pdf");
            log.info("Creating Letter of Reference: " + pdfName);
            out = new java.io.FileOutputStream(pdfName);
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
            ////String billImageFile = "billImageFileOld-" + fileName.replaceFirst(".xml",".pdf");
            //drawTemplate(chart, 900, 400, billImageFile,billImageModel);
            DocumentImageRepositoryManager documentImageRepositoryManager = new DocumentImageRepositoryManager();
            /*try
            {
                Thread.sleep(180000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }*/
            ////documentImageRepositoryManager.saveFile(new File(billImageFile));
            File letterPDF = new File(pdfName);
            documentImageRepositoryManager.saveFile(new File(pdfName));
            log.info("Saving...."+ pdfName);
            letterPDF.delete();
            } catch (TransformerConfigurationException e) {
              log.info( e.toString());
            } catch (TransformerException e) {
                log.info( e.toString());
        } catch (FOPException e) {
            log.info( e.toString());
        } catch (FileNotFoundException e) {
            log.info( e.toString());
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    log.info( e.toString());
                }
            }
        }

    }

    public  void createBillTemplate(String fileName,  BillImageModel billImageModel){


        // the XSL FO file
        File xsltFile = new File("./src/main/resources/LondonHydroBillOld.xsl");
        // the XML file which provides the input
        StreamSource xmlSource = new StreamSource(new File("./src/main/resources/074001057395.xml"));
        // create an instance of fop factory
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        // a user agent is needed for transformation
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        // Setup output
        OutputStream out = null;


        try {
            String pdfName = "./src/main/resources/" + "billImageFile-" + fileName.replaceFirst(".xml",".pdf");;
            out = new java.io.FileOutputStream(pdfName);
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
            String billImageFile = "billImageFile-" + fileName.replaceFirst(".XML",".pdf");
            //drawTemplate(chart, 900, 400, billImageFile,billImageModel);
            DocumentImageRepositoryManager documentImageRepositoryManager = new DocumentImageRepositoryManager();
            try
            {
                Thread.sleep(180000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            documentImageRepositoryManager.saveFile(new File(billImageFile));
            documentImageRepositoryManager.saveFile(new File(pdfName));
            System.out.println("saving..letter.."+ billImageFile);
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Creates a  dataset.
     *
     * @return a  dataset.
     */
    private  CategoryDataset createDataset() {
        DefaultCategoryDataset billData = new DefaultCategoryDataset();

        billData.addValue(20.3, "Bill 1 (Horton)", "Jan 04");
        billData.addValue(27.2, "Bill 1 (Horton)", "Feb 04");
        billData.addValue(19.7, "Bill 1 (Horton)", "Mar 04");
        billData.addValue(19.4, "Bill 1 (Horton)", "Jan 04");
        billData.addValue(10.9, "Bill 1 (Horton)", "Feb 04");
        billData.addValue(18.4, "Bill 1 (Horton)", "Mar 04");
        billData.addValue(16.5, "Bill 1 (Wellington)", "Jan 04");
        billData.addValue(15.9, "Bill 1 (Wellington)", "Feb 04");
        billData.addValue(16.1, "Bill 1 (Wellington)", "Mar 04");
        billData.addValue(13.2, "Bill 1 (Dundas)", "Jan 04");
        billData.addValue(14.4, "Bill 1 (Dundas)", "Feb 04");
        billData.addValue(13.7, "Bill 1 (Dundas)", "Mar 04");

        billData.addValue(23.3, "Bill 2 (Horton)", "Jan 04");
        billData.addValue(16.2, "Bill 2 (Horton)", "Feb 04");
        billData.addValue(28.7, "Bill 2 (Horton)", "Mar 04");
        billData.addValue(12.7, "Bill 2 (Horton)", "Jan 04");
        billData.addValue(17.9, "Bill 2 (Horton)", "Feb 04");
        billData.addValue(12.6, "Bill 2 (Horton)", "Mar 04");
        billData.addValue(15.4, "Bill 2 (Wellington)", "Jan 04");
        billData.addValue(21.0, "Bill 2 (Wellington)", "Feb 04");
        billData.addValue(11.1, "Bill 2 (Wellington)", "Mar 04");
        billData.addValue(23.8, "Bill 2 (Dundas)", "Jan 04");
        billData.addValue(23.4, "Bill 2 (Dundas)", "Feb 04");
        billData.addValue(19.3, "Bill 2 (Dundas)", "Mar 04");

        billData.addValue(11.9, "Bill 3 (Horton)", "Jan 04");
        billData.addValue(31.0, "Bill 3 (Horton)", "Feb 04");
        billData.addValue(22.7, "Bill 3 (Horton)", "Mar 04");
        billData.addValue(15.3, "Bill 3 (Horton)", "Jan 04");
        billData.addValue(14.4, "Bill 3 (Horton)", "Feb 04");
        billData.addValue(25.3, "Bill 3 (Horton)", "Mar 04");
        billData.addValue(23.9, "Bill 3 (Wellington)", "Jan 04");
        billData.addValue(19.0, "Bill 3 (Wellington)", "Feb 04");
        billData.addValue(10.1, "Bill 3 (Wellington)", "Mar 04");
        billData.addValue(13.2, "Bill 3 (Dundas)", "Jan 04");
        billData.addValue(15.5, "Bill 3 (Dundas)", "Feb 04");
        billData.addValue(10.1, "Bill 3 (Dundas)", "Mar 04");

        return billData;
    }

    /**
     * Creates a  chart.
     *
     * @param dataset the dataset for the chart.
     * @return a  chart.
     */
    private  JFreeChart createChart(final CategoryDataset dataset) {

        final JFreeChart chart = ChartFactory.createStackedBarChart(
                "",  // chart title
                "Category",                  // domain axis label
                "Usage",                     // range axis label
                dataset,                     // data
                PlotOrientation.HORIZONTAL,    // the plot orientation
                true,                        // legend
                true,                        // tooltips
                false                        // urls
        );

        GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();
        KeyToGroupMap map = new KeyToGroupMap("G1");
        map.mapKeyToGroup("Bill 1 (Horton)", "G1");
        map.mapKeyToGroup("Bill 1 (Horton)", "G1");
        map.mapKeyToGroup("Bill 1 (Wellington)", "G1");
        map.mapKeyToGroup("Bill 1 (Dundas)", "G1");
        map.mapKeyToGroup("Bill 2 (Horton)", "G2");
        map.mapKeyToGroup("Bill 2 (Horton)", "G2");
        map.mapKeyToGroup("Bill 2 (Wellington)", "G2");
        map.mapKeyToGroup("Bill 2 (Dundas)", "G2");
        map.mapKeyToGroup("Bill 3 (Horton)", "G3");
        map.mapKeyToGroup("Bill 3 (Horton)", "G3");
        map.mapKeyToGroup("Bill 3 (Wellington)", "G3");
        map.mapKeyToGroup("Bill 3 (Dundas)", "G3");
        renderer.setSeriesToGroupMap(map);

        renderer.setItemMargin(0.0);
        Paint p1 = new GradientPaint(
                0.0f, 0.0f, new Color(0x22, 0x22, 0xFF), 0.0f, 0.0f, new Color(0x88, 0x88, 0xFF)
        );
        renderer.setSeriesPaint(0, p1);
        renderer.setSeriesPaint(4, p1);
        renderer.setSeriesPaint(8, p1);

        Paint p2 = new GradientPaint(
                0.0f, 0.0f, new Color(0x22, 0xFF, 0x22), 0.0f, 0.0f, new Color(0x88, 0xFF, 0x88)
        );
        renderer.setSeriesPaint(1, p2);
        renderer.setSeriesPaint(5, p2);
        renderer.setSeriesPaint(9, p2);

        Paint p3 = new GradientPaint(
                0.0f, 0.0f, new Color(0xFF, 0x22, 0x22), 0.0f, 0.0f, new Color(0xFF, 0x88, 0x88)
        );
        renderer.setSeriesPaint(2, p3);
        renderer.setSeriesPaint(6, p3);
        renderer.setSeriesPaint(10, p3);

        Paint p4 = new GradientPaint(
                0.0f, 0.0f, new Color(0xFF, 0xFF, 0x22), 0.0f, 0.0f, new Color(0xFF, 0xFF, 0x88)
        );
        renderer.setSeriesPaint(3, p4);
        renderer.setSeriesPaint(7, p4);
        renderer.setSeriesPaint(11, p4);
        renderer.setGradientPaintTransformer(
                new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL)
        );

        SubCategoryAxis domainAxis = new SubCategoryAxis("Bill / Month");
        domainAxis.setCategoryMargin(0.05);
        domainAxis.addSubCategory("Bill 1");
        domainAxis.addSubCategory("Bill 2");
        domainAxis.addSubCategory("Bill 3");

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainAxis(domainAxis);
        plot.setRenderer(renderer);
        plot.setFixedLegendItems(createLegendItems());
        return chart;

    }

    /**
     * Creates the legend items for the chart.  In this case, we set them manually because we
     * only want legend items for a subset of the data series.
     *
     * @return The legend items.
     */
    private  LegendItemCollection createLegendItems() {
        LegendItemCollection billData = new LegendItemCollection();
//        LegendItem item1 = new LegendItem("US", new Color(0x22, 0x22, 0xFF));
        //      LegendItem item2 = new LegendItem("Horton", new Color(0x22, 0xFF, 0x22));
        //    LegendItem item3 = new LegendItem("Wellington", new Color(0xFF, 0x22, 0x22));
        //  LegendItem item4 = new LegendItem("Dundas", new Color(0xFF, 0xFF, 0x22));
//        billData.add(item1);
        //      billData.add(item2);
        //    billData.add(item3);
        //  billData.add(item4);
        return billData;
    }

    public  void writeChartToPDF(JFreeChart chart, int width, int height, String fileName) {
        PdfWriter writer = null;

        Document document = new Document();

        try {
            writer = PdfWriter.getInstance(document, new FileOutputStream(
                    fileName));
            document.open();
            PdfContentByte contentByte = writer.getDirectContent();
            PdfTemplate template = contentByte.createTemplate(width, height);
            Graphics2D graphics2d = template.createGraphics(width, height,
                    new DefaultFontMapper());
            Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width,
                    height);

            chart.draw(graphics2d, rectangle2d);

            graphics2d.dispose();
            contentByte.addTemplate(template, 0, 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        document.close();
    }


    public  void drawTemplate(JFreeChart chart, int width, int height, String fileName, BillImageModel billImageModel) {

        Document document = new Document();

        try {
            //log.info("Convert document into PDF.....................");
            File file = new File(fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            PdfWriter writer = PdfWriter.getInstance(document, fileOutputStream);


            //open
            document.open();

            String cellFourText = "78.98";
            String cellFiveText = "$";

            String cellNineText = "45.89";


            drawOCRTable(100, 670, writer,billImageModel);
            drawTableHeader(20, 650, writer,billImageModel);

            drawBillSummaryTable(20, 630, writer, "Previous Balance","$" , "32.67", cellFourText, cellFiveText, cellNineText,"Bill Date", billImageModel.getEndDate(), billImageModel);
            drawBillSummaryTable(20, 610, writer, "Total Payment since last bill", "$", billImageModel.getTotalPaymentSinceLastBill(), cellFourText, cellFiveText, billImageModel.getTotalPaymentSinceLastBill(),"Customer Name", billImageModel.getLastName()+billImageModel.getFirstName(), billImageModel);
            drawBillSummaryTable(20, 580, writer, "Total Current Utility Charges", billImageModel.getTotalCurrentUtilityCharges(), billImageModel.getTotalCurrentUtilityCharges(), cellFourText, cellFiveText,  cellNineText,"Customer Number", billImageModel.getContractAccount(),billImageModel);
            drawBillSummaryTable(20, 560, writer, "Budget Billing Amount", billImageModel.getBudgetBillingAmount(), billImageModel.getBudgetBillingAmount(), cellFourText, cellFiveText,  cellNineText,"Mailing Postal Code", billImageModel.getAddressThree(), billImageModel);

            drawTable2(20, 520, writer,billImageModel);
            drawTable(380, 770, writer,billImageModel);
            drawTableValues(480, 770, writer,billImageModel);
            //drawStackedBarChart(writer,billImageModel);
            drawStackedBarChart(writer,chart,width,height,fileOutputStream);
            drawTermsOfStatement(writer,10, 350);

            int pageNumber = 2;
            int pageSize = 5;
            createHeaderBlock(writer.getDirectContent(), pageNumber, pageSize, billImageModel);

            //close
            document.close();


        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public  void drawStackedBarChart(PdfWriter writer,JFreeChart chart, int width, int height, FileOutputStream fileOutputStream ) {


        PdfContentByte contentByte = writer.getDirectContent();
        PdfTemplate template = contentByte.createTemplate(width, height);
        Graphics2D graphics2d = template.createGraphics(width, height,
                new DefaultFontMapper());
        Rectangle2D rectangle2d = new Rectangle2D.Double(260, 150, 400,
                200);

        chart.draw(graphics2d, rectangle2d);
        graphics2d.dispose();

        contentByte.addTemplate(template, 0, 310);

        BufferedImage chartImage = chart.createBufferedImage( width, height, null);
        System.out.println("Bill Image........................1");




        try {


            File outputfile = new File("/Users/faisal/Downloads/MyBillPdf3.png");

            ImageIO.write(chartImage, "png", outputfile);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Bill Image........................2");

    }

    public static void drawTable(int x, int y, PdfWriter writer, BillImageModel billImageModel) {


        PdfPTable table = new PdfPTable(1);

        table.getDefaultCell().setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);

        PdfPCell cellOne = new PdfPCell(new Phrase("Billing Date",FontFactory.getFont(FontFactory.HELVETICA, 8)));
        cellOne.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cellOne);
        PdfPCell cellTwo = new PdfPCell(new Phrase("Total Amount Due",FontFactory.getFont(FontFactory.HELVETICA, 8)));
        cellTwo.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cellTwo);
        PdfPCell cellThree = new PdfPCell(new Phrase("Due Date",FontFactory.getFont(FontFactory.HELVETICA, 8)));
        cellThree.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cellThree);

        table.setTotalWidth(100f);
        table.writeSelectedRows(0, -1, x, y, writer.getDirectContent());


    }
    public static void drawTableValues(int x, int y, PdfWriter writer, BillImageModel billImageModel) {


        PdfPTable table = new PdfPTable(1);

        table.getDefaultCell().setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);


        PdfPCell cellOne = new PdfPCell(new Phrase(billImageModel.getDate(),FontFactory.getFont(FontFactory.HELVETICA, 8)));
        cellOne.setBorder(Rectangle.BOX);
        table.addCell(cellOne);
        PdfPCell cellTwo = new PdfPCell(new Phrase(billImageModel.getTotalAmountDue(),FontFactory.getFont(FontFactory.HELVETICA, 8)));
        cellTwo.setBorder(Rectangle.BOX);
        table.addCell(cellTwo);
        PdfPCell cellThree = new PdfPCell(new Phrase(/*billImageModel.getEndDate()*/"2006-12-31",FontFactory.getFont(FontFactory.HELVETICA, 8)));
        cellThree.setBorder(Rectangle.BOX);
        table.addCell(cellThree);


        table.setTotalWidth(50f);
        table.writeSelectedRows(0, -1, x, y, writer.getDirectContent());


    }
    public static void drawTable2(int x, int y, PdfWriter writer, BillImageModel billImageModel) {

        PdfPTable table = new PdfPTable(3);

        table.getDefaultCell().setBorder(0);

        table.addCell("Your Electrical Charges");
        table.addCell("Electricity supplied by London Hydro");
        table.addCell("Due Date");

        PdfPCell[] cellTable = table.getRow(0).getCells();
        for (int j = 0; j < cellTable.length; j++) {
            cellTable[j].setBackgroundColor(BaseColor.GRAY);
            cellTable[j].setHorizontalAlignment(Element.ALIGN_RIGHT);
        }
        table.addCell(billImageModel.getDate());
        table.addCell(billImageModel.getTotalAmountDue());
        table.addCell(billImageModel.getEndDate());
        table.setTotalWidth(250f);
        table.writeSelectedRows(0, -1, x, y, writer.getDirectContent());

    }

    public static void drawOCRTable(int x, int y, PdfWriter writer, BillImageModel billImageModel) {
        PdfPTable table = new PdfPTable(1);


        //table.getDefaultCell().setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);
        table.getDefaultCell().setBorder(0);


        table.addCell(billImageModel.getOcr());

        PdfPCell[] cellTable = table.getRow(0).getCells();
        for (int j = 0; j < cellTable.length; j++) {
            cellTable[j].setBackgroundColor(BaseColor.WHITE);
        }
        table.setTotalWidth(440f);
        table.writeSelectedRows(0, -1, x, y, writer.getDirectContent());
    }
    public  void drawTableHeader(int x, int y, PdfWriter writer, BillImageModel billImageModel) {
        PdfPTable table = new PdfPTable(1);

        table.addCell("Billing Summary - Billing Number           " + billImageModel.getContractAccount());
        PdfPCell[] cellTable = table.getRow(0).getCells();
        for (int j = 0; j < cellTable.length; j++) {
            cellTable[j].setBackgroundColor(BaseColor.GRAY);
        }

        table.setTotalWidth(570f);
        table.writeSelectedRows(0, -1, x, y, writer.getDirectContent());
    }

    public  void drawBillSummaryTable(int x, int y, PdfWriter writer,
                                            String cellOneText,
                                            String cellTwoText,
                                            String cellThreeText,
                                            String cellFourText,
                                            String cellFiveText,
                                            String cellSevenText,
                                            String cellEightText,
                                            String cellNineText,BillImageModel billImageModel
    ) {

        PdfPTable table = new PdfPTable(8);

        table.getDefaultCell().setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.BOTTOM);

        PdfPCell cellOne = new PdfPCell(new Phrase(cellOneText,FontFactory.getFont(FontFactory.HELVETICA, 8)));
        cellOne.setBorder(Rectangle.NO_BORDER);
        table.addCell(cellOne);

        PdfPCell cellTwo = new PdfPCell(new Phrase(cellTwoText,FontFactory.getFont(FontFactory.HELVETICA, 8)));
        cellTwo.setBorder(Rectangle.NO_BORDER);
        table.addCell(cellTwo);

        PdfPCell cellThree = new PdfPCell(new Phrase(cellThreeText,FontFactory.getFont(FontFactory.HELVETICA, 8)));
        cellThree.setBorder(Rectangle.NO_BORDER);
        table.addCell(cellThree);

        PdfPCell cellFour = new PdfPCell(new Phrase(cellFourText,FontFactory.getFont(FontFactory.HELVETICA, 8)));
        cellFour.setBorder(Rectangle.NO_BORDER);
        table.addCell(cellFour);

        PdfPCell cellFive = new PdfPCell(new Phrase(cellFiveText,FontFactory.getFont(FontFactory.HELVETICA, 8)));
        cellFive.setBorder(Rectangle.NO_BORDER);
        table.addCell(cellFive);



        PdfPCell cellSeven = new PdfPCell(new Phrase(cellSevenText,FontFactory.getFont(FontFactory.HELVETICA, 8)));
        cellSeven.setBorder(Rectangle.NO_BORDER);
        table.addCell(cellSeven);

        PdfPCell cellEight = new PdfPCell(new Phrase(cellEightText,FontFactory.getFont(FontFactory.HELVETICA, 8)));
        cellEight.setBorder(Rectangle.NO_BORDER);
        table.addCell(cellEight);

        PdfPCell cellNine = new PdfPCell(new Phrase(cellNineText,FontFactory.getFont(FontFactory.HELVETICA, 8)));
        cellNine.setBorder(Rectangle.NO_BORDER);
        table.addCell(cellNine);

        table.setTotalWidth(600f);
        table.writeSelectedRows(0, -1, x, y, writer.getDirectContent());
    }

    public  void createHeaderBlock(PdfContentByte cb, int pageNumber, int pageSize, BillImageModel billImageModel) throws DocumentException, IOException {

        drawLogo(cb, "/Users/faisal/Downloads/test.jpg", 20, 750);
        drawAdress(cb, 60, 730,billImageModel);
        drawAdress(cb, 75, 820,billImageModel,true);
        drawBillingNumberHeader(cb, 375, 820,billImageModel);
        drawBillingNumberFooter(cb, 375, 720,billImageModel);
    }


    public  void drawAdress(PdfContentByte cb, float xCoord, float yCoord, BillImageModel billImageModel) throws DocumentException {
        Font textFontForAdress = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);

        PdfPTable table = new PdfPTable(1);
        float[] rows = {200f};
        table.setTotalWidth(rows);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.getDefaultCell().setFixedHeight(14f);
        table.addCell(new Phrase(new Chunk("     "  +billImageModel.getInvoiceNumber(), textFontForAdress)));
        String customerName = billImageModel.getLastName()  + billImageModel.getFirstName();
        table.addCell(new Phrase(new Chunk(customerName, textFontForAdress)));
        table.addCell(new Phrase(new Chunk(billImageModel.getAddressOne(), textFontForAdress)));
        table.addCell(new Phrase(new Chunk(billImageModel.getAddressTwo(), textFontForAdress)));
        table.addCell(new Phrase(new Chunk(billImageModel.getAddressThree(), textFontForAdress)));


        table.writeSelectedRows(0, 4, xCoord, yCoord, cb);
    }
    public  void drawBillingNumberHeader(PdfContentByte cb, float xCoord, float yCoord, BillImageModel billImageModel) throws DocumentException {
        Font textFontForAdress = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);

        PdfPTable table = new PdfPTable(1);
        float[] rows = {200f};
        table.setTotalWidth(rows);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.getDefaultCell().setFixedHeight(14f);
        table.addCell(new Phrase(new Chunk("Billing Number :     " + billImageModel.getContractAccount(), textFontForAdress)));
        table.addCell(new Phrase(new Chunk("Please use the billing number above when paying online.", textFontForAdress)));
        table.addCell(new Phrase(new Chunk("This bill may be paid at monst financial institutions.", textFontForAdress)));
        table.writeSelectedRows(0, 4, xCoord, yCoord, cb);
    }

    public  void drawBillingNumberFooter(PdfContentByte cb, float xCoord, float yCoord, BillImageModel billImageModel) throws DocumentException {
        Font textFontForAdress = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.BLACK);

        PdfPTable table = new PdfPTable(1);
        float[] rows = {200f};
        table.setTotalWidth(rows);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.getDefaultCell().setFixedHeight(14f);
        table.addCell(new Phrase(new Chunk("Interest charges of 1.5% per month (19.56% per year)", textFontForAdress)));
        table.addCell(new Phrase(new Chunk("will be applied to all overdue charges.", textFontForAdress)));
        table.addCell(new Phrase(new Chunk("Please retain this portion for your records - DO NOT PAY.", textFontForAdress)));
        table.writeSelectedRows(0, 4, xCoord, yCoord, cb);
    }


}
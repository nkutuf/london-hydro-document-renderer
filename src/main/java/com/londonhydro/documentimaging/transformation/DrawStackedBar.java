package com.londonhydro.documentimaging.transformation;

import com.itextpdf.awt.DefaultFontMapper;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import org.apache.pdfbox.pdmodel.PDDocument;
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
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;


public class DrawStackedBar {
    public static void main(String args[]) throws Exception {
;
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        //good drawTemplate(chart, 400, 400, "/Users/faisal/Downloads/MyBillPdf3.pdf");
        test();

    }
public static void test(){
    PDDocument document = null;
    Writer output = null;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();


    String fileName = "074001057395";
    //fileName="billImageFile-074001057395";
    try {
        //GridFSDBFile pdfFile = serv.retrievePDFile("fileName" + ".pdf");

        String billImageFileName = fileName + "." + "pdf";
        System.out.println("billImageFileName.............." + billImageFileName);
        Mongo mongo = new Mongo("localhost", 27017);
        DB db = mongo.getDB("imagedb");
        GridFSDBFile imageForOutput = null;
        GridFS gfsBillImage = new GridFS(db, "photo");
        String f = fileName + "." + "pdf";


        imageForOutput = gfsBillImage.findOne(billImageFileName);
        byte[] b = org.apache.commons.io.IOUtils.toByteArray(imageForOutput.getInputStream());
        ByteArrayOutputStream baos = new ByteArrayOutputStream(b.length);
        baos.write(b, 0, b.length);
        InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());


        OutputStream f2 = new FileOutputStream("test.html");
        baos.writeTo(f2);
        f2.close();
        baos.reset();
    } catch (IOException e) {
        e.printStackTrace();
    }

}
    /**
     * Creates a  dataset.
     *
     * @return a  dataset.
     */
    private static CategoryDataset createDataset() {
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
    private static JFreeChart createChart(final CategoryDataset dataset) {

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
    private static LegendItemCollection createLegendItems() {
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


    public static void drawTemplate(JFreeChart chart, int width, int height, String fileName) {

        Document document = new Document();

        try {
            //log.info("Convert document into PDF.....................");
            File file = new File(fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            PdfWriter writer = PdfWriter.getInstance(document, fileOutputStream);


            //open
            document.open();


            drawStackedBarChart(writer,chart,width,height,fileOutputStream);

            //close
            document.close();

            // Create a Form XObject for a Pie chart

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void drawStackedBarChart(PdfWriter writer,JFreeChart chart, int width, int height, FileOutputStream fileOutputStream ) {


        PdfContentByte contentByte = writer.getDirectContent();
        PdfTemplate template = contentByte.createTemplate(width, height);
        Graphics2D graphics2d = template.createGraphics(width, height,
                new DefaultFontMapper());
        Rectangle2D rectangle2d = new Rectangle2D.Double(0, 0, width,
                height);

        chart.draw(graphics2d, rectangle2d);
        graphics2d.dispose();
        //contentByte.addTemplate(template, 400, 410);
        contentByte.addTemplate(template, 400, 410);

        BufferedImage chartImage = chart.createBufferedImage( width, height, null);
        System.out.println("Bill Image........................1");
        //ImageIO.write( chartImage, "png", fileOutputStream );
        //BufferedImage objBufferedImage=chart.createBufferedImage(600,800);
        /*ByteArrayOutputStream bas = new ByteArrayOutputStream();
        byte[] byteArray=bas.toByteArray();
        InputStream in = new ByteArrayInputStream(byteArray);
        BufferedImage image = null;*/



        try {

            File outputfile = new File("/Users/faisal/Downloads/MyBillPdf3.png");

            ImageIO.write(chartImage, "png", outputfile);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Bill Image........................2");

    }



  }
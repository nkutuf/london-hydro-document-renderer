package com.londonhydro.documentimaging.transformation;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidation {

    public static void main(String[] args) {

        System.out.println("EmployeeRequest.xml validates against Employee.xsd? "+validateXMLSchema("file:/Users/faisal/Downloads/london-hydro-document-renderer/com/londonhydro/documentimaging/transformation/Employees.xsd", "EmployeeRequest.xml"));
        System.out.println("EmployeeResponse.xml validates against Employee.xsd? "+validateXMLSchema("file:/Users/faisal/Downloads/london-hydro-document-renderer/com/londonhydro/documentimaging/transformation/Employees.xsd", "EmployeeResponse.xml"));
        System.out.println("employee.xml validates against Employee.xsd? "+validateXMLSchema("com/londonhydro/documentimaging/transformation/Employees.xsd", "com/londonhydro/documentimaging/transformation/Employees.xml"));

    }

    public static boolean validateXMLSchema(String xsdPath, String xmlPath){

        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("/Users/faisal/Downloads/london-hydro-document-renderer/src/main/java/com/londonhydro/documentimaging/transformation/DT_BillPrint2.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File("/Users/faisal/Downloads/london-hydro-document-renderer/src/main/java/com/londonhydro/documentimaging/transformation/074001057395.XML")));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }
}

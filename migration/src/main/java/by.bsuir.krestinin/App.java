package by.bsuir.krestinin;

import by.bsuir.krestinin.entity.Author;
import by.bsuir.krestinin.entity.*;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;


public class App{
    public static void main(String[] args){
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        System.out.println(validateXMLSchema("D:\\! 5 semester\\ВТ\\regular-publications\\DB\\author.xsd","D:\\! 5 semester\\ВТ\\regular-publications\\DB\\author.xml"));

    }

    private static boolean validateXMLSchema(String xsdPath, String xmlPath){

        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (IOException | org.xml.sax.SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }
}
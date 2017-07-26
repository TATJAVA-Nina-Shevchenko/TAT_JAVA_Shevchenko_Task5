package com.epam.shevchenko.marshalling;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class JAXBExample {
	public static void main(String[] args) {

		Customer customer = new Customer();
		customer.setId(100);
		customer.setName("mkyong");
		customer.setAge(29);

		// marshal
//		try {
//
//			File file = new File("C:/Users/Nina_Shevchenko/DATA/file.xml");
//			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
//			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//			// output pretty printed
//			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//			jaxbMarshaller.marshal(customer, file);
//			jaxbMarshaller.marshal(customer, System.out);
//
//		} catch (JAXBException e) {
//			e.printStackTrace();
//		}
//
//		// unmarshal
//		try {
//
//			File file = new File("C:/Users/Nina_Shevchenko/DATA/file.xml");
//			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
//
//			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//			Customer customerUnmarshalled = (Customer) jaxbUnmarshaller.unmarshal(file);
//			System.out.println(customerUnmarshalled);
//
//		} catch (JAXBException e) {
//			e.printStackTrace();
//		}

		// schema validation
		try {

			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			File schemaFile = new File("C:/Users/Nina_Shevchenko/DATA/file.xsd");
			Schema schema = schemaFactory.newSchema(schemaFile);

			File file = new File("C:/Users/Nina_Shevchenko/DATA/file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);

			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setSchema(schema);
			
			marshaller.marshal(customer, file);
			marshaller.marshal(customer, System.out);
			
		} catch (JAXBException | SAXException e) {
			e.printStackTrace();
		}
	}
}
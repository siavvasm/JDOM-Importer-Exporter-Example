package miltos.diploma.parsers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class JDOMTemplate {

	private final static String XMLFILE = "C:/Users/Miltos/Desktop/input.xml";
	private final static String OUTPUTFILE = "C:/Users/Miltos/Desktop/output.xml";
	
	public static void main(String[] args) {
		
		try{	
			
			/* Define the xml parser and import the xml file */
			File file = new File(XMLFILE);
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(file);
			
			/* Get the root element of the Document */
			Element root = doc.getRootElement();

			/* Do something with the xml file */
			// e.g. Print the names of the root's children.
			List children = root.getChildren();
			Iterator iterator = children.iterator();
			while(iterator.hasNext()){
				Element child = (Element) iterator.next();
				System.out.println(child.getName());
			}
			
			/* Define an xml outputter */
			XMLOutputter outputter = new XMLOutputter();
			
			/* Set the output format */
			Format format = Format.getPrettyFormat();
			outputter.setFormat(format);
			
			/* Output the xml file to standard output and to the desired file */
			FileWriter filew = new FileWriter(OUTPUTFILE);
			outputter.output(doc, System.out);
			outputter.output(doc, filew);
			
		}catch(IOException io){
			System.out.println(io.getMessage());
		}catch(JDOMException je){
			System.out.println(je.getMessage());
		}
	}
}

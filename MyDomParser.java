package Java_Dom_Parser;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MyDomParser {

    public static void main(String[] args) {
        Db_Connect d1 = new Db_Connect();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            //Establish connection to MySQL database
            try {
				d1.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Books", "root", "arun23");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("Book.xml");
            
            NodeList nodeList = doc.getElementsByTagName("book");
            
            for (int x = 0; x < nodeList.getLength(); x++) {
                Node node = nodeList.item(x);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                            String id = element.getAttribute("id");
                            String name = element.getElementsByTagName("name").item(0).getTextContent();
                            String author = element.getElementsByTagName("author").item(0).getTextContent();
                            String publisher = element.getElementsByTagName("publisher").item(0).getTextContent();
                            System.out.println("Book ID: " + id);
                            System.out.println("Name: " + name);
                            System.out.println("Author: " + author);
                            System.out.println("Publisher: " + publisher);
                            
                        
                            try 
                            {
                                d1.ps = d1.con.prepareStatement("insert into Book(ID, Name, Author, Publisher) values (?, ?, ?, ?)");
                                d1.ps.setString(1, id);
                                d1.ps.setString(2, name);
                                d1.ps.setString(3, author);
                                d1.ps.setString(4, publisher);
                                d1.ps.executeUpdate();
                            } 
                            catch (SQLException e) 
                            {
                                e.printStackTrace();
                            }
                        }
            
            }
     



        } catch (ParserConfigurationException e) 
         {
            e.printStackTrace();
        } 
        catch (SAXException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } finally {
            try {
                if (d1.ps != null) d1.ps.close();
                if (d1.con != null) d1.con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
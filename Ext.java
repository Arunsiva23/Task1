/*package Java_Dom_Parser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class MyDomParser 
{
	
	
	
	public static void main(String[] args) 
	{
		Db_Connect d1=new Db_Connect();
		DocumentBuilderFactory factory=DocumentBuilderFactory.newNSInstance();
		try 
		{
			DocumentBuilder builder=factory.newDocumentBuilder();
			Document doc=builder.parse("Book.xml");
			NodeList booklist=doc.getElementsByTagName("book");
			for(int i=0; i<booklist.getLength(); i++)
			{
				Node b=booklist.item(i);
				if(b.getNodeType()==Node.ELEMENT_NODE)
				{
					Element book=(Element) b;
					String id= book.getAttribute("id");
					
					NodeList nameList=book.getChildNodes();
					//System.out.println(id);
					//System.out.println(nam);
					for(int j=0; j<nameList.getLength(); j++)
					{
						Node n=nameList.item(j);
						if(n.getNodeType()==Node.ELEMENT_NODE)
						{
							Element name=(Element) n;
							//System.out.println(name);
							System.out.println("Book "+ id + ":"+name.getTagName()+"="+name.getTextContent());
							try
							{
								d1.ps=d1.con.prepareStatement("insert into Book(ID, Name, Author, Publisher)values(id, name.getTagName, name.getTextContent)");
								d1.ps.setString(1, id);
								d1.ps.setString(2, name);
								d1.ps.setString(3, author);
								d1.ps.setString(4, publisher);
								d1.ps.executeUpdate();
								
							}
							catch(SQLException e)
							{
								e.printStackTrace();
							}
							
						}
						
					}
				}
				
			}
		} 
	catch (ParserConfigurationException e) 
	{
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		catch(SAXException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

	private static void getAttribute(String string) 
	{
		// TODO Auto-generated method stub
		
	}

	private static void getElementsByTagName(String string)
	{
		// TODO Auto-generated method stub
		
	}

}


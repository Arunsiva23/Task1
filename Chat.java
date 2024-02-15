/*import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXML {
    public static void main(String[] args) {
        try {
            File inputFile = new File("books.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("book");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
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
                    System.out.println("-------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

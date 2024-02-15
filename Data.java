package Java_Dom_Parser;

public class Data 
{
	try
	{
		d1.ps=d1.con.prepareStatement("insert into Books(ID, Name, Author, Publisher)values(11, as, bim, publisher)");
		d1.ps.setString(1, id);
		d1.ps.setString(2, name);
		//d1.ps.setString(3, author);
		//d1.ps.setString(4, publisher);
		d1.ps.executeUpdate();
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}

}



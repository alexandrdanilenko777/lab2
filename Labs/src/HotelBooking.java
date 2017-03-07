
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HotelBooking {
	Connection c = null;
    Statement stmt = null;
    
     HotelBooking(){	 
    	 try {
    	       Class.forName("org.postgresql.Driver");
    	       c = DriverManager
    	          .getConnection("jdbc:postgresql://localhost:5432/HotelBooking",
    	          "Alexandr", "123");
    	       System.out.println("HotelBooking database opened successfully");
    	       stmt = c.createStatement();  
    	     } catch ( Exception e ) {
    	       System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    	       System.exit(0);
    	     }    
     };
     public void Create_table () throws SQLException {      
	       String sql = "CREATE TABLE HotelBooking " +
	               "(BookingID      integer NOT NULL," +
	               " ClientName     varchar(20) NOT NULL, " +
	               " HotelName      varchar(8) NOT NULL, " +
	               " Arrival        date NOT NULL, " +
	               " Depature       date NOT NULL)";               
		   stmt.executeUpdate(sql);
	       System.out.println("Table HotelBooking created successfully");
     };
     
     public void Insert_hotel(String hotel) throws SQLException{
    	 int id = (int)(Math.random()*100);
    	 String sql = "INSERT INTO HotelBooking VALUES" +
	               "("+id+", 'Alexandr', '"+hotel+"', '2017-07-13', '2017-07-20');";               
		   stmt.executeUpdate(sql);
	       System.out.println("Data to HotelBooking inserted successfully"); 
     };
     
     public void Update_HotelName(int id, String HotelName) throws SQLException{
    	 String sql = "UPDATE HotelBooking SET HotelName = '"+HotelName+"' WHERE BookingID = "+id+";";             
		   stmt.executeUpdate(sql);
	       System.out.println("Data to HotelBooking updated successfully"); 
     };
     
     public void Exit_db() throws SQLException{
    	 stmt.close();
	     c.close();
     };
}

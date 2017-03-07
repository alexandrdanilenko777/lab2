import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FlyBooking {
	Connection c = null;
    Statement stmt = null;
    
     FlyBooking(){	 
    	 try {
    	       Class.forName("org.postgresql.Driver");
    	       c = DriverManager
    	          .getConnection("jdbc:postgresql://localhost:5432/FlyBooking",
    	          "Alexandr", "123");
    	       System.out.println("FlyBooking database opened successfully");
    	       stmt = c.createStatement();  
    	     } catch ( Exception e ) {
    	       System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    	       System.exit(0);
    	     }    
     };
     public void Create_table () throws SQLException {      
	       String sql = "CREATE TABLE FlyBooking " +
	               "(BookingID      integer      NOT NULL," +
	               " ClientName     varchar(20)  NOT NULL, " +
	               " FlyNumber      varchar(8)   NOT NULL, " +
	               " From_          varchar(4)   NOT NULL, " +
	               " To_            varchar(4) NOT NULL, " +
	               " Date_          date NOT NULL)";               
		   stmt.executeUpdate(sql);
	       System.out.println("Table FlyBooking created successfully");
     };
     
     public void Insert_fly(String name) throws SQLException{
    	 int id = (int)(Math.random()*100);
    	 String sql = "INSERT INTO FlyBooking VALUES" +
	               "("+id+", '"+name+"', 'UA502', 'KIEV', 'MNTN', '2017-07-13')";               
		   stmt.executeUpdate(sql);
	       System.out.println("Data to FlyBooking inserted successfully"); 
     };
     
     public void Update_ClientName(int id, String name) throws SQLException{
    	 String sql = "UPDATE FlyBooking SET ClientName = '"+name+"' WHERE BookingID = "+id+"";             
		   stmt.executeUpdate(sql);
	       System.out.println("Data to FlylBooking updated successfully"); 
     };
     
     public void Exit_db() throws SQLException{
    	 stmt.close();
	     c.close();
     };
}

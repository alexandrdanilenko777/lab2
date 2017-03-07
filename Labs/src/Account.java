

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Account {
	Connection c = null;
    Statement stmt = null;
    
     Account(){	 
    	 try {
    	       Class.forName("org.postgresql.Driver");
    	       c = DriverManager
    	          .getConnection("jdbc:postgresql://localhost:5432/account",
    	          "Alexandr", "123");
    	       System.out.println("FlyBooking database opened successfully");
    	       stmt = c.createStatement();  
    	     } catch ( Exception e ) {
    	       System.err.println( e.getClass().getName()+": "+ e.getMessage() );
    	       System.exit(0);
    	     }    
     };
     public void Create_table () throws SQLException {      
	       String sql = "CREATE TABLE Accounts " +
	               "(AccountID      integer      NOT NULL," +
	               " TotalSum       integer  NOT NULL CHECK (TotalSum > 0) );";               
		   stmt.executeUpdate(sql);
	       System.out.println("Table FlyBooking created successfully");
     };
     
     public void Insert_account(int price) throws SQLException{
    	 int id = (int)(Math.random()*100);
    	 String sql = "INSERT INTO Accounts VALUES" +
	               "("+id+", "+price+");";               
		   stmt.executeUpdate(sql);
	       System.out.println("Data to accaunts inserted successfully"); 
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

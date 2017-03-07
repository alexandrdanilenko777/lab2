import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Connect {
	
	Connection c = null;
    Statement stmt = null;
    //c.setAutoCommit(false);
	
	public Connect(String db_name){
		
		 try {
  	       Class.forName("org.postgresql.Driver");
  	       c = DriverManager
  	          .getConnection("jdbc:postgresql://localhost:5432/"+db_name,
  	          "Alexandr", "123");
  	       System.out.println("FlyBooking database opened successfully");
  	       stmt = c.createStatement();  
  	     } catch ( Exception e ) {
  	       System.err.println( e.getClass().getName()+": "+ e.getMessage() );
  	       System.exit(0);
  	     }		
	};
	
	public void tpc_begin() throws SQLException{
		 String sql = "BEGIN;";               
		  
			stmt.executeUpdate(sql);
		
	};
	public void Insert_fly(String name) throws SQLException{
   	 int id = (int)(Math.random()*1000);
   	 String sql = "INSERT INTO FlyBooking VALUES" +
	               "("+id+", '"+name+"', 'UA502', 'KIEV', 'MNTN', '2017-07-13')";               
		   stmt.executeUpdate(sql);
	       System.out.println("Data to FlyBooking inserted successfully"); 
    };
	
    public void Insert_hotel(String hotel) throws SQLException{
   	 int id = (int)(Math.random()*100);
   	 String sql = "INSERT INTO HotelBooking VALUES" +
	               "("+id+", 'Alexandr', '"+hotel+"', '2017-07-13', '2017-07-20');";               
		   stmt.executeUpdate(sql);
	       System.out.println("Data to HotelBooking inserted successfully"); 
    };
    
    public void Update_account() throws SQLException{
   	// int id = (int)(Math.random()*100);
   	 String sql = "UPDATE Accounts SET TotalSUM = TotalSum-200 WHERE AccountID=63;";              
		   stmt.executeUpdate(sql);
	       System.out.println("Data to accaunts inserted successfully"); 
    };
    
	 public void Update_HotelName(int id, String HotelName) throws SQLException {
    	 String sql = "UPDATE HotelBooking SET HotelName = '"+HotelName+"' WHERE BookingID = "+id+";";             
		
			stmt.executeUpdate(sql);
			System.out.println("Data to HotelBooking updated successfully");
		
	        
     };
     
     public void Update_FlyClientName(int id, String name) throws SQLException {
    	 String sql = "UPDATE FlyBooking SET ClientName = '"+name+"' WHERE BookingID = "+id+"";             
		   
			stmt.executeUpdate(sql);
		    System.out.println("Data to FlylBooking updated successfully"); 
			      
     };

     public void tpc_prepare(String transact_id) throws SQLException{
		 String sql = "PREPARE TRANSACTION '"+transact_id+"';";               
		 
			stmt.executeUpdate(sql);
		
	}
     
     public void tpc_commit(String transact_id) throws SQLException{
		 String sql = "COMMIT PREPARED  '"+transact_id+"';";               
			stmt.executeUpdate(sql);
		
	}
     
     public void tpc_rollback(String transact_id) throws SQLException{
		 String sql = "ROLLBACK PREPARED  '"+transact_id+"';";               
		 
			stmt.executeUpdate(sql);
		
	}
     
     public void close_db() throws SQLException{
    	 stmt.close();
	     c.close();
     };
	
}

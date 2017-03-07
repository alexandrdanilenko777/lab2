import java.sql.SQLException;

public class LabMain {

	public static void main(String[] args) throws SQLException  {
		
		
		//HotelBooking hotel = new HotelBooking();
		//hotel.Create_table();
		//hotel.Insert_hotel("Redisson");
		//FlyBooking fly = new FlyBooking();
		//fly.Create_table();
		//fly.Insert_fly("Alexandr Danilenko");
		//fly.Update_ClientName(1, "Testing");
		//hotel.Update_HotelName(1, "Pers");*/
		
		//HotelBooking hotel = new HotelBooking();
		//FlyBooking fly = new FlyBooking();
		
		
		Connect c1 = new Connect("FlyBooking");
		Connect c2 = new Connect("HotelBooking");
		Connect c3 = new Connect("account");
		boolean t_repared1 = false;
		boolean t_prepared2 = false;
		c1.tpc_begin();
		c2.tpc_begin();
		c3.tpc_begin();
		c1.Insert_fly("Alexandr");
		c2.Insert_hotel("Rwss11");
		c3.Update_account();
		//c3.Insert_account(232);
		System.out.println("there");
		try {
		c1.tpc_prepare("trnsct1");
		c2.tpc_prepare("trnsct2");
		c3.tpc_prepare("trnsct3");
		//if (true) throw new SQLException();
		c1.tpc_commit("trnsct1");
		c2.tpc_commit("trnsct2");
		c3.tpc_commit("trnsct3");
		System.out.println("Transaction commited");
		}
		catch (SQLException e ){
			c1.tpc_rollback("trnsct1");
			c2.tpc_rollback("trnsct2");
			c3.tpc_rollback("trnsct3");
			System.out.println("Transactin rollbacked");
		}
		
		
		//Account a1=new Account();
		//a1.Create_table();
		//a1.Insert_account(200);
	}

}

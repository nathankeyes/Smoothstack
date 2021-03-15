package AssessmentOne;

/**
 * @author      Nathan Keyes
 * @DateCreated 3/15/21
 * @LastEdited  3/15/21
 * @Description Assessment 1 singleton method fix
 * @Documentation 
 * 		BigDecimal: https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html
 * 		DriverManager: https://docs.oracle.com/javase/8/docs/api/java/sql/DriverManager.html
 */

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SampleSingleton {
		private static Connection conn = null;
		
		public BigDecimal destroyable;
		
		private static SampleSingleton instance = null;
				
		public static SampleSingleton getInstance() {
			if (instance == null)
				instance = new SampleSingleton();
			
			return instance;
		}
		
		public static void databaseQuery(BigDecimal input) throws SQLException {
			//use singleton to save input so you have the correct value even if it gets changed during conversion
			SampleSingleton SS = SampleSingleton.getInstance();
			SS.destroyable = input;
			
			conn = DriverManager.getConnection("url of database");
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("select id from table");
			
			int x = 0;
			while( rs.next() ) {
				try {
					x = rs.getInt(1) * (SS.destroyable).intValueExact();
				}
				catch (ArithmeticException e) {
					System.out.println("Some loss of data");
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}

	}

}

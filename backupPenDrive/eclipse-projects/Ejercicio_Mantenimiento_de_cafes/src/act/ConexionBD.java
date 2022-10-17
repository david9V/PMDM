package act;

public class ConexionBD {
	
	ConexionBD(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
}

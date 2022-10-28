package act;

public class ExcepcionEmpleado  extends Exception{
	
	public ExcepcionEmpleado (String msg) {
		super(msg);
	}
	
	public ExcepcionEmpleado() {
		
	}
	
	public void setMsg(String msg) {
		this.setMsg(msg);
	}
}

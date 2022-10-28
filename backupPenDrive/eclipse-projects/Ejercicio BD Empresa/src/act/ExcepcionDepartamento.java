package act;

public class ExcepcionDepartamento  extends Exception{
	
	public ExcepcionDepartamento (String msg) {
		super(msg);
	}
	
	public ExcepcionDepartamento() {
		
	}
	
	public void setMsg(String msg) {
		this.setMsg(msg);
	}
}

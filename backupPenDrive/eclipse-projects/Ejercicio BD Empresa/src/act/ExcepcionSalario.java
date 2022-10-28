package act;

public class ExcepcionSalario  extends Exception{
	
	public ExcepcionSalario (String msg) {
		super(msg);
	}
	
	public ExcepcionSalario() {
		
	}
	
	public void setMsg(String msg) {
		this.setMsg(msg);
	}
}

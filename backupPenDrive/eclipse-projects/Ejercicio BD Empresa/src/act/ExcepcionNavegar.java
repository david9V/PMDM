package act;

public class ExcepcionNavegar  extends Exception{
	
	public ExcepcionNavegar (String msg) {
		super(msg);
	}
	
	public ExcepcionNavegar() {
		
	}
	
	public void setMsg(String msg) {
		this.setMsg(msg);
	}
}

package act;

public class ExcepcionDirector  extends Exception{
	
	public ExcepcionDirector (String msg) {
		super(msg);
	}
	
	public ExcepcionDirector() {
		
	}
	
	public void setMsg(String msg) {
		this.setMsg(msg);
	}
}

package act;

public class Departamento {
	
	int dept_no;
	String dNombre;
	String loc;
	
	public Departamento(int dept_no, String dNombre, String loc) {
		this.dept_no = dept_no;
		this.dNombre = dNombre;
		this.loc = loc;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	public String getdNombre() {
		return dNombre;
	}

	public void setdNombre(String dNombre) {
		this.dNombre = dNombre;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "[dept_no=" + dept_no + ", dNombre=" + dNombre + ", loc=" + loc + "]";
	}
	
	
}

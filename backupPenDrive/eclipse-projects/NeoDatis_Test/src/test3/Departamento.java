package test3;

public class Departamento {

	private int deptNo;
	private String dnombre;
	private String loc;
	
	public Departamento() {
		super();
	}

	public Departamento(int deptNo, String dnombre, String loc) {
		this.deptNo = deptNo;
		this.dnombre = dnombre;
		this.loc = loc;
	}

	
	
	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDnombre() {
		return dnombre;
	}

	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Departamento [deptNo=" + deptNo + ", dnombre=" + dnombre + ", loc=" + loc + "]";
	}
	
	
	
}

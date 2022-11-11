/*
 * He creado esta clase para aprovechar la consulta de la tabla prestamos y guardar las fechas de préstamo
 * y devolución de los libros, para así no tener que consultar la base de datos de nuevo al querer mostrar
 * los datos tanto de la tabla libros como la de prestamos
 */
public class Bundle { 
	int id;
	String fechaInicio;
	String fechaFin;
	
	public Bundle(int id, String fechaInicio, String fechaFin) {
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}

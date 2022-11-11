
public class Libro {
	private int id_libro;
	private String titulo;
	private int num_ejemplares;
	private String editorial;
	private int num_paginas;
	private String date;
	
	public Libro(int id_libro, String titulo, int num_ejemplares, String editorial, int num_paginas, String date) {
		this.id_libro = id_libro;
		this.titulo = titulo;
		this.num_ejemplares = num_ejemplares;
		this.editorial = editorial;
		this.num_paginas = num_paginas;
		this.date = date;
	}
	
	public Libro() {
		
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNum_ejemplares() {
		return num_ejemplares;
	}

	public void setNum_ejemplares(int num_ejemplares) {
		this.num_ejemplares = num_ejemplares;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getNum_paginas() {
		return num_paginas;
	}

	public void setNum_paginas(int num_paginas) {
		this.num_paginas = num_paginas;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Libro [id_libro=" + id_libro + ", titulo=" + titulo + ", num_ejemplares=" + num_ejemplares
				+ ", editorial=" + editorial + ", num_paginas=" + num_paginas + ", date=" + date + "]";
	}
	
	

}

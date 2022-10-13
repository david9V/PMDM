package p2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		String nombre = null, direccion = null;
		long telefono = 0;
		
		try {
			File fichero = new File("datos.dat");
			FileOutputStream fos = new FileOutputStream(fichero);
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeUTF("David");
			dos.writeUTF("Sevilla");
			dos.writeLong(349853489);
			dos.close();
			fos.close();
			
			FileInputStream fis = new FileInputStream(fichero);
			DataInputStream dis = new DataInputStream(fis);
			
			nombre = dis.readUTF();
			direccion = dis.readUTF();
			telefono = dis.readLong();
			System.out.println(nombre);
			System.out.println(direccion);
			System.out.println(telefono);
			dis.close();
			fis.close();
		}
		
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}

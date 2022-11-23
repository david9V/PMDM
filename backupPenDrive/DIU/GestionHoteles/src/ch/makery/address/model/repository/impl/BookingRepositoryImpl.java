package ch.makery.address.model.repository.impl;

import ch.makery.address.model.BookingVO;
import ch.makery.address.model.ClientVO;
import ch.makery.address.model.ExcepcionBooking;
import ch.makery.address.model.ExcepcionClient;
import ch.makery.address.model.repository.BookingRepository;
import ch.makery.address.util.Regimen;
import ch.makery.address.util.TipoHabitacion;

import java.sql.*;
import java.util.ArrayList;

public class BookingRepositoryImpl implements BookingRepository {
    private final ConexionJDBC conexion = new ConexionJDBC();
    private Statement stmt;
    private String sentencia;
    private ArrayList<BookingVO> lista;
    private BookingVO b;

    public BookingRepositoryImpl(){
    }

    @Override
    public void guardar(BookingVO booking) throws ExcepcionBooking {
        try {
            Connection conn = this.conexion.conectarBD();
            int fuma = booking.isFumador() ? 1 : 0;
            this.stmt = conn.createStatement();
            this.sentencia = "INSERT INTO reservas (fech_llegada, fech_salida, n_hab, tipo_hab, fumador, regimen, id_cliente) VALUES ('" + booking.getFechEntrada() + "','" + booking.getFechSalida() + "', " + booking.getnHab() + ", '" + booking.getTipoHab().toString().toUpperCase().replaceAll(" ", "_").replaceFirst("Ó", "O") + "', '" + fuma + "', '" + booking.getRegimen().toString().toUpperCase().replaceAll(" ", "_").replaceFirst("Ó", "O") + "', " + booking.getIdCliente() + ")";
            this.stmt.executeUpdate(this.sentencia);
            this.stmt.close();
            this.conexion.desconectarBD(conn);
        } catch (SQLException var3) {
            System.out.println(var3);
            throw new ExcepcionBooking("No se ha podido realizar la operación");
        }
    }

    @Override
    public void eliminar(int cod) throws ExcepcionBooking {
        try {
            Connection conn = this.conexion.conectarBD();
            this.stmt = conn.createStatement();
            Statement comando = conn.createStatement();
            String sql = String.format("DELETE FROM reservas WHERE cod = %d", cod);
            comando.executeUpdate(sql);
            this.conexion.desconectarBD(conn);
        } catch (SQLException var5) {
            throw new ExcepcionBooking("No se ha podido realizar la eliminación");
        }
    }

    @Override
    public void actualizar(BookingVO booking) throws ExcepcionBooking {
        try {
            Connection conn = this.conexion.conectarBD();
            this.stmt = conn.createStatement();
            int fuma = booking.isFumador() ? 1 : 0;
            String sql = String.format("UPDATE reservas SET cod = " + booking.getCod() + ", fech_llegada = '" + booking.getFechEntrada() + "', fech_salida = '" + booking.getFechSalida() + "', n_hab = " + booking.getnHab() + ", tipo_hab = '" + booking.getTipoHab().toString().toUpperCase().replaceAll(" ", "_").replaceFirst("Ó", "O") + "', fumador = " + fuma + ", regimen = '" + booking.getRegimen().toString().toUpperCase().replaceAll(" ", "_").replaceFirst("Ó", "O") + "' WHERE cod = " + booking.getCod());
            this.stmt.executeUpdate(sql);
        } catch (Exception var4) {
            throw new ExcepcionBooking("No se ha podido realizar la edición");
        }
    }

    @Override
    public ArrayList<BookingVO> cargar(int idCliente) throws ExcepcionBooking {
        try {
            Connection conn = this.conexion.conectarBD();
            this.lista = new ArrayList();
            this.stmt = conn.createStatement();
            this.sentencia = "SELECT * FROM reservas WHERE id_cliente = " + idCliente;
            ResultSet rs = this.stmt.executeQuery(this.sentencia);

            while(rs.next()) {
                Integer cod = rs.getInt("cod");
                Date fEntr = rs.getDate("fech_llegada");
                Date fSal = rs.getDate("fech_salida");
                Integer nHab = rs.getInt("n_hab");
                TipoHabitacion tipoHab = TipoHabitacion.valueOf(rs.getString("tipo_hab"));
                boolean fumador = rs.getBoolean("fumador");
                Regimen regimen = Regimen.valueOf(rs.getString("regimen"));

                this.b = new BookingVO(cod, fEntr, fSal, nHab, tipoHab, fumador, regimen, idCliente);
                this.lista.add(this.b);
            }

            this.conexion.desconectarBD(conn);
            return this.lista;
        } catch (SQLException var6) {
            throw new ExcepcionBooking("No se ha podido realizar la operación");
        }
    }

    @Override
    public ArrayList<BookingVO> cargarTodo() throws ExcepcionBooking {
        try {
            Connection conn = this.conexion.conectarBD();
            this.lista = new ArrayList();
            this.stmt = conn.createStatement();
            this.sentencia = "SELECT * FROM reservas";
            ResultSet rs = this.stmt.executeQuery(this.sentencia);

            while(rs.next()) {
                Integer cod = rs.getInt("cod");
                Date fEntr = rs.getDate("fech_llegada");
                Date fSal = rs.getDate("fech_salida");
                Integer nHab = rs.getInt("n_hab");
                TipoHabitacion tipoHab = TipoHabitacion.valueOf(rs.getString("tipo_hab"));
                boolean fumador = rs.getBoolean("fumador");
                Regimen regimen = Regimen.valueOf(rs.getString("regimen"));
                Integer idClie = rs.getInt("id_cliente");

                this.b = new BookingVO(cod, fEntr, fSal, nHab, tipoHab, fumador, regimen, idClie);
                this.lista.add(this.b);
            }
            this.conexion.desconectarBD(conn);
            return this.lista;
        } catch (SQLException var6) {
            throw new ExcepcionBooking("No se ha podido realizar la operación");
        }
    }

    @Override
    public int lastCod() throws ExcepcionBooking {
        int cod = 0;

        try {
            Connection conn = this.conexion.conectarBD();
            Statement comando = conn.createStatement();

            for(ResultSet registro = comando.executeQuery("SELECT cod FROM reservas ORDER BY cod DESC LIMIT 1"); registro.next(); cod = registro.getInt("cod")) {
            }

            return cod;
        } catch (SQLException var5) {
            throw new ExcepcionBooking( "No se ha podido realizar la busqueda del código");
        }
    }

}

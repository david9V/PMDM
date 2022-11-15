package ch.makery.address.model.repository.impl;

import ch.makery.address.model.ClientVO;
import ch.makery.address.model.ExcepcionClient;
import ch.makery.address.model.repository.ClientRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClientRepositoryImpl implements ClientRepository {
    private final ConexionJDBC conexion = new ConexionJDBC();
    private Statement stmt;
    private String sentencia;
    private ArrayList<ClientVO> lista;
    private ClientVO c;

    public ClientRepositoryImpl(){
    }

    @Override
    public void guardar(ClientVO client) throws ExcepcionClient {
        try {
            Connection conn = this.conexion.conectarBD();
            this.stmt = conn.createStatement();
            this.sentencia = "INSERT INTO clientes (first_name, last_name, dni, address, city, province) VALUES ('" + client.getFirstName() + "','" + client.getLastName() + "', '" + client.getDni() + "', '" + client.getAddress() + "', '" + client.getCity() + "', '" + client.getProvince() + "');";
            this.stmt.executeUpdate(this.sentencia);
            this.stmt.close();
            this.conexion.desconectarBD(conn);
        } catch (SQLException var3) {
            System.out.println(var3);
            throw new ExcepcionClient("No se ha podido realizar la operación");
        }
    }

    @Override
    public void eliminar(int id) throws ExcepcionClient {
        try {
            Connection conn = this.conexion.conectarBD();
            this.stmt = conn.createStatement();
            Statement comando = conn.createStatement();
            String sql = String.format("DELETE FROM clientes WHERE id = %d", id);
            comando.executeUpdate(sql);
            this.conexion.desconectarBD(conn);
        } catch (SQLException var5) {
            throw new ExcepcionClient("No se ha podido realizar la eliminación");
        }
    }

    @Override
    public void actualizar(ClientVO client) throws ExcepcionClient {
        try {
            Connection conn = this.conexion.conectarBD();
            this.stmt = conn.createStatement();
            String sql = String.format("UPDATE clientes SET id= '%d', first_name = '%s', last_name = '%s', dni = '%s', address = '%s', city = '%s', province = '%s' WHERE id = %d", client.getId(), client.getFirstName(), client.getLastName(), client.getDni(), client.getAddress(), client.getCity(), client.getProvince(), client.getId());
            this.stmt.executeUpdate(sql);
        } catch (Exception var4) {
            throw new ExcepcionClient("No se ha podido realizar la edición");
        }
    }

    @Override
    public ArrayList<ClientVO> cargar() throws ExcepcionClient {
        try {
            Connection conn = this.conexion.conectarBD();
            this.lista = new ArrayList();
            this.stmt = conn.createStatement();
            this.sentencia = "SELECT * FROM clientes";
            ResultSet rs = this.stmt.executeQuery(this.sentencia);

            while(rs.next()) {
                Integer id = rs.getInt("id");
                String fn = rs.getString("first_name");
                String ln = rs.getString("last_name");
                String dni = rs.getString("dni");
                String address = rs.getString("address");
                String city = rs.getString("city");
                String province = rs.getString("province");

                this.c = new ClientVO(id, fn, ln, dni, address, city, province);
                this.lista.add(this.c);
            }

            this.conexion.desconectarBD(conn);
            return this.lista;
        } catch (SQLException var6) {
            throw new ExcepcionClient("No se ha podido realizar la operación");
        }
    }

    @Override
    public int lastId() throws ExcepcionClient {
        int id = 0;

        try {
            Connection conn = this.conexion.conectarBD();
            Statement comando = conn.createStatement();

            for(ResultSet registro = comando.executeQuery("SELECT id FROM clientes ORDER BY id DESC LIMIT 1"); registro.next(); id = registro.getInt("id")) {
            }

            return id;
        } catch (SQLException var5) {
            throw new ExcepcionClient( "No se ha podido realizar la busqueda del ID");
        }
    }
}

package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Manga;

public class MangaDAO {

    //CLASE QUE REALIZA LAS CONSULTAS
    private static final String SQL_SELECT = "SELECT * FROM mangas";
    private static final String SQL_SELECT_BY_ID = "SELECT idmangas , nombre, autor, cantPaginas, precio, genero FROM mangas WHERE idmangas = ?";
    private static final String SQL_INSERT = "INSERT INTO mangas(nombre, autor, cantPaginas, precio, genero) VALUES( ?, ? , ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE mangas SET nombre = ?, autor = ?, cantPaginas = ?, precio = ?, genero = ? WHERE idmangas = ?";
    private static final String SQL_DELETE = "DELETE FROM mangas WHERE idmangas = ?";

    public List<Manga> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Manga manga = null;
        List<Manga> mangas = new ArrayList();

        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idmanga = rs.getInt("idmangas");
                String nombre = rs.getString("nombre");
                String autor = rs.getString("autor");
                int cantPaginas = rs.getInt("cantPaginas");
                double precio = rs.getDouble("precio");
                String genero = rs.getString("genero");

                manga = new Manga(idmanga, nombre, autor, cantPaginas, precio, genero);

                mangas.add(manga);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return mangas;
    }

    public int insertar(Manga manga) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, manga.getNombre());
            stmt.setString(2, manga.getAutor());
            stmt.setInt(3, manga.getCantPaginas());
            stmt.setDouble(4, manga.getPrecio());
            stmt.setString(4, manga.getGenero());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    public int actualizar(Manga manga) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, manga.getNombre());
            stmt.setString(2, manga.getAutor());
            stmt.setInt(3, manga.getCantPaginas());
            stmt.setDouble(4, manga.getPrecio());
            stmt.setString(5, manga.getGenero());
            stmt.setInt(6, manga.getIdmangas());

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    public int eliminar(int idmanga) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, idmanga);

            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public Manga seleccionarPorId(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Manga manga = null;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idmangas = rs.getInt("idmangas");

                String nombre = rs.getString("nombre");
                String autor = rs.getString("autor");

                int cantPaginas = rs.getInt("cantPaginas");
                double precio = rs.getDouble("precio");
                String genero = rs.getString("genero");

                manga = new Manga(idmangas, nombre, autor, cantPaginas, precio, genero);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return manga;
    }
}

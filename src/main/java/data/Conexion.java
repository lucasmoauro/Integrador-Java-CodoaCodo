package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mangas?useSSL=false&useTimeZone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USR = "root";
    private static final String JDBC_PASS = "admin";

    public static DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            ds.setUrl(JDBC_URL);

            ds.setUsername(JDBC_USR);

            ds.setPassword(JDBC_PASS);

            //DEFINE POOL DE CONEXIONES
            ds.setInitialSize(50);

            return ds;
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return ds;
    }

    public static Connection getConexion() throws SQLException {

        return getDataSource().getConnection();
    }

    //METODOS DE CERRADO DE CONEXION A DB
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement st) throws SQLException {
        st.close();
    }

    public static void close(Connection cn) throws SQLException {
        cn.close();
    }

}

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConexion {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3307/reservafacil";
        String user = "root";
        String pass = "";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            if (con != null) {
                System.out.println("CONECTADO CORRECTAMENTE");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
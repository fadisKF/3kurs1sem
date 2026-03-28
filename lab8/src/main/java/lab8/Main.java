import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/kafedra_db";
        String user = "Aboba";
        String password = "4466";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);

            if (conn == null) {
                System.out.println("Нет соединения с БД!");
                return;
            }

            System.out.println("Соединение установлено!");

            Statement stmt = conn.createStatement();

            String query = """
                SELECT t.firstname, t.lastname, d.name
                FROM teacher t
                JOIN discipline d ON t.id_teacher = d.id_teacher
            """;

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                        rs.getString("firstname") + " " +
                                rs.getString("lastname") + " — " +
                                rs.getString("name")
                );
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
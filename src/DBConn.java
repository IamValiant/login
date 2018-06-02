import java.sql.*;

/**
 * Created by Xueyong on 2018/6/1.
 */
public class DBConn {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/login";  //login:dbname
    static final String USER = "root";
    static final String PASSWORD = "mysqladmin";

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //打开连接
    public Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭连接
    public void closeConn(ResultSet rs,PreparedStatement ps,Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Database is closed.");
    }

    //查询语句
    public int query(String sql,String []param) {
        int count = 0;
        try {
            this.getConn();
            ps = conn.prepareStatement(sql);
            if(param != null){
                for (int i = 0; i < param.length; i++) {
                    ps.setString(i + 1, param[i]);
                }
            }
            rs = ps.executeQuery();
             while(rs.next()){
                 count = rs.getInt(1);
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeConn(rs,ps,conn);
        }
        return count;
    }
}

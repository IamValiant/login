import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Xueyong on 2018/6/1.
 */

public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html;charset = GBK");
        PrintWriter out = response.getWriter();
        // 获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        DBConn dbConn = new DBConn();
        String sql = "SELECT COUNT(1) FROM user WHERE username = ? AND password = ?";
        int count = dbConn.query(sql,new String[]{username,password});
        System.out.println(count);
        if(count == 0){
            out.print("用户名或密码错误");
            out.print("<br><a href = 'index.jsp'>请重新登陆</a>");
        }else{
            out.println("登录成功");
            //获取session，并将用户名和密码保存在session中
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}

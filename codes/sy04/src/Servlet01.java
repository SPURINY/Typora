import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( value = "/s1")
public class Servlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String n=request.getParameter("username");
        String p=request.getParameter("password");
        if(("shiying").equals(n)&&("root").equals(p)){
            response.sendRedirect("/sy04/wel.html");
        }else{
            response.sendRedirect("/sy04/log.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

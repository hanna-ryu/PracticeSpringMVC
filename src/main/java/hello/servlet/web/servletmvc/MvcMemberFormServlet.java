package hello.servlet.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String viewPath ="/WEB-INF/views/new-form.jsp";
        //컨트롤러에서 뷰로 이동할때 사용
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        //서블릿에서 jsp 호출
        dispatcher.forward(request,response);
    }
}

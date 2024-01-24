package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    /**
     * 1. 파라미터 전송 기능
     * http://localhost:8080/request-param?username=hello&age=20
     * 2. 동일한 파라미터 전송 가능
     * http://localhost:8080/request-param?username=hello&username=kim&age=20
     */
        @Override
        protected void service(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            System.out.println("[전체 파라미터 조회] - start");

            request.getParameterNames().asIterator()
                    .forEachRemaining(paramname -> System.out.println(paramname + "=" + request.getParameter(paramname)));
            System.out.println("[전체 파라미터 조회] - end");
            System.out.println();

            System.out.println("[단일 파라미터 조회]");
            String username = request.getParameter("username");
            System.out.println("request.getParameter(username) = " + username);

            String age = request.getParameter("age");
            System.out.println("reqeust.getParameter(age) = " + age);
            System.out.println();

            System.out.println("[이름이 같은 복수 파라미터 조회]");
            System.out.println("request.getParameterValues(username)");
            String[] usernames = request.getParameterValues("username");
            for (String name : usernames) {
                System.out.println("username=" + name);
            }
            response.getWriter().write("ok");
        }
    }


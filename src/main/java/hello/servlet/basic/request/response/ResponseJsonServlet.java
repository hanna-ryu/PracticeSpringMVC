package hello.servlet.basic.request.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "response-json", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    /**
    * http://localhost:8080/response-json
    * */

    private ObjectMapper objectMapper  = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("content-type", "application/json");
        response.setCharacterEncoding("utf-8");
        HelloData data = new HelloData();
        data.setUsername("hanna");
        data.setAge(26);
        String result = objectMapper.writeValueAsString(data);

        response.getWriter().write(result);
    }
}

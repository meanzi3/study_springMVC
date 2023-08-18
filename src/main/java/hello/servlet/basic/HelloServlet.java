package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 서블릿 어노테이션 (name = 서블릿 이름, urlPatterns = URL 매핑)
@WebServlet(name ="helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
// HTTP 요청을 통해 매핑된 URL이 호출되면 서블릿 컨테이너는 다음 메서드를 실행한다.
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    System.out.println("HelloServlet.service");
    System.out.println("request = " + request);
    System.out.println("response = " + response);

    String username = request.getParameter("username");
    System.out.println("username = " + username);

    response.setContentType("text/plain");
    response.setCharacterEncoding("utf-8");
    response.getWriter().write("hello "+username);
  }
}

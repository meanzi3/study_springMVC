package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;

public interface MyHandlerAdapter {

  /**
   * 어댑터가 해당 컨드롤러를 처리할 수 있는지 판단하는 메소드
   * @param handler (컨트롤러)
   * @return
   */
  boolean supports(Object handler);

  /**
   * 실제 컨트롤러를 호출하고, 그 결과로 ModelView 반환
   * @param request
   * @param response
   * @param handler
   * @return
   * @throws SerialException
   * @throws IOException
   */
  ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}

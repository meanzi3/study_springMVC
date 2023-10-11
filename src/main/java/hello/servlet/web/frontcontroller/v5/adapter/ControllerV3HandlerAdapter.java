package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

  /**
   * @param handler (컨트롤러)
   * @return ControllerV3을 처리할 수 있는 어댑터를 뜻함.
   */
  @Override
  public boolean supports(Object handler) {
    return (handler instanceof ControllerV3);
  }

  /**
   * handler를 V3로 변환하고 V3 형식에 맞도록 호출
   * @param request
   * @param response
   * @param handler
   * @return ControllerV3는 ModelView를 반환하기 떄문에, 그대로 ModelView를 반환
   * @throws SerialException
   * @throws IOException
   */
  @Override
  public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
    ControllerV3 controller = (ControllerV3) handler;

    Map<String, String> paramMap = createParamMap(request);
    ModelView mv = controller.process(paramMap);

    return mv;
  }

  private Map<String, String> createParamMap(HttpServletRequest request) {
    Map<String, String> paramMap = new HashMap<>();

    request.getParameterNames().asIterator()
            .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

    return paramMap;
  }
}

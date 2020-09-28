package izolotov;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Runner {

    static class RequestHandler extends AbstractHandler {
        public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
            httpServletResponse.setContentType("text/plain;charset=utf-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.getWriter().print("Hello world");
            request.setHandled(true);
        }
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(Integer.parseInt(args[0]));
        server.setHandler(new RequestHandler());
        server.start();
        Thread.sleep(Long.parseLong(args[1]));
        server.stop();
    }
}

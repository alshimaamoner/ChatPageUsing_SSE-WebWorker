import com.google.gson.Gson;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
public class ChatServlet extends HttpServlet {
    static List<Message> messages = new ArrayList<>();
    static int idCount;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(builGsonFromObject());

    }

    private String builGsonFromObject(){
        Gson gsonMessage = new Gson();
        return "data:"+gsonMessage.toJson(messages)+"\n\n";
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Message message = new Message();
        message.setSender(request.getParameter("sender"));
        message.setText(request.getParameter("text"));
        messages.add(message);

    }
}
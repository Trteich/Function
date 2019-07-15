package server;

import dto.Result;
import logic.Function;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FunctionServlet", urlPatterns = {"*.html"})
public class FunctionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double intervalStart = Double.parseDouble(request.getParameter("interval_start"));
        double intervalEnd = Double.parseDouble(request.getParameter("interval_end"));
        double delta = Double.parseDouble(request.getParameter("delta"));
        Function function = new Function();
        Result result = new Result();
        result.setNumberOfY(function.numberOfY(intervalStart, intervalEnd, delta));
        double[] x = function.fillX(intervalStart, intervalEnd, delta);
        result.setX(x);
        double[] y = function.fillY(x);
        result.setY(y);
        int min = function.getMin(y);
        result.setMin(min);
        int max = function.getMax(y);
        result.setMax(max);
        double sum = function.getSum(y);
        result.setSum(sum);
        double avg = function.getAverage(y);
        result.setAvg(avg);
        request.setAttribute("result", result);
        request.getRequestDispatcher("/result.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}

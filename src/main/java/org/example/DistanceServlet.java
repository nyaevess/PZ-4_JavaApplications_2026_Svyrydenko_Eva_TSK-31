package com.example.distance;

// Імпорти Servlet API (javax для Tomcat 9)
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Для роботи з IOException
import java.io.IOException;

/**
 * Servlet, який обчислює відстань між двома точками
 * за формулою Гаверсина (Haversine formula)
 */
@WebServlet("/distance") // URL, по якому викликається цей сервлет
public class DistanceServlet extends HttpServlet {

    /**
     * Обробка POST запиту (коли відправляється форма)
     */
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // ===== 1. Отримуємо дані з HTML форми =====

        double lat1 = Double.parseDouble(request.getParameter("lat1")); // широта 1
        double lon1 = Double.parseDouble(request.getParameter("lon1")); // довгота 1
        double lat2 = Double.parseDouble(request.getParameter("lat2")); // широта 2
        double lon2 = Double.parseDouble(request.getParameter("lon2")); // довгота 2

        // ===== 2. Переводимо градуси в радіани =====

        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // ===== 3. Різниця координат =====

        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        // ===== 4. Формула Гаверсина =====

        double a = Math.pow(Math.sin(dLat / 2), 2)
                + Math.cos(lat1Rad)
                * Math.cos(lat2Rad)
                * Math.pow(Math.sin(dLon / 2), 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // ===== 5. Радіус Землі =====
        double R = 6371; // км

        // ===== 6. Остаточна відстань =====
        double distance = R * c;

        // ===== 7. Передаємо результат в JSP =====
        request.setAttribute("distance", distance);

        // ===== 8. Перенаправлення на сторінку результату =====
        request.getRequestDispatcher("result.jsp")
                .forward(request, response);
    }
}
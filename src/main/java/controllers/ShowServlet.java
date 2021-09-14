package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.DTO;
import utils.DAO;

@WebServlet("/show")
public class ShowServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

    public ShowServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DAO.createEntityManager();

        // 該当のIDのタスク1件のみをデータベースから取得
        DTO m = em.find(DTO.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        // タスクデータをリクエストスコープにセットしてshow.jspを呼び出す
        request.setAttribute("DTO", m);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/show.jsp");
        rd.forward(request, response);
    }
}
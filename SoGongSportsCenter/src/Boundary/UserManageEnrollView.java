package Boundary;

import Service.UserEnroll;
import Persistence.DAO.*;
import Persistence.DTO.UserDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static Service.Message.*;

public class UserManageEnrollView extends HttpServlet {
    private DBConfig dbConfig;
    private UserDAO userDAO;
    private AdminDAO adminDAO;
    private InstructorDAO instructorDAO;
    private MemberDAO memberDAO;
    private UserEnroll userEnroll;

    public void init(){
        dbConfig = new DBConfig();
        userDAO = new UserDAO(dbConfig.getConnection());
        adminDAO = new AdminDAO(dbConfig.getConnection());
        instructorDAO = new InstructorDAO(dbConfig.getConnection());
        memberDAO = new MemberDAO(dbConfig.getConnection());
        userEnroll = new UserEnroll(userDAO, adminDAO, instructorDAO, memberDAO);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        action(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            String result = userEnroll.userEnroll(new UserDTO(id, password, name, type));
            request.setAttribute("resultMessage", result);
        }catch (NumberFormatException e){
            request.setAttribute("resultMessage", ENROLL_INVALID_ACCOUNT_VALUE);
        }catch (Exception e){

        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/userManage/enrollAlert.jsp");
        dispatcher.forward(request, response);
    }

    public void action(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("/userManage/userManageEnrollView.jsp");
        dispatcher.forward(request, response);
    }
}

package com.linkup.UserManagerProject.controller;

import com.linkup.UserManagerProject.model.dao.UserDAO;
import com.linkup.UserManagerProject.model.dto.UserDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static com.linkup.UserManagerProject.common.JDBCTemplate.getConnection;

@WebServlet("/read")
public class ServletRead extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.setCharacterEncoding("UTF-8");
        System.out.println("read 실행");

        String userId=req.getParameter("userId");
        String password=req.getParameter("password");
        System.out.println(userId);
        System.out.println(password);
        Connection con = getConnection();

        List<UserDTO> userDTOList=new ArrayList<>();
        UserDAO userDAO=new UserDAO();
        userDAO.selectAllCode(con);


    }
}

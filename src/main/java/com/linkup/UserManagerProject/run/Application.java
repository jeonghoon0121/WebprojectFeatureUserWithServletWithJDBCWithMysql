package com.linkup.UserManagerProject.run;

import com.linkup.UserManagerProject.model.dao.UserDeleteDAO;
import com.linkup.UserManagerProject.model.dao.UserInsertDAO;
import com.linkup.UserManagerProject.model.dao.UserSearchDAO;
import com.linkup.UserManagerProject.model.dto.UserDTO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import static com.linkup.UserManagerProject.common.JDBCTemplate.getConnection;

/*
Main Project : LinkupWebPage
Sub Project : UserManagerProject
Author : 2025-08-27 JeongHoon
내용 : JDBC TEST mysql 파일 과 연동하기
    ver 1.0  usertest1db 조회->성공 2025-08-27
    ver 1.1 DTO 통합 ->성공 2025-08-27
    ver 1.2 DAO 통합 ->>성공 2025-08-27
    ver 1.3 mapper ->userDAO -> Application 구조 조회성공
    ver 1.4 Search 기능 1. all 2. last 2025-09-03
    ver 1.5 userDAO 분리
* com.linkup.
├── common         // JDBCTemplate
├── config         // 설정 기능
├── controller     // 요청 처리
├── service        // 비즈니스 로직
├── model dto,dao     // DB 접근 로직 , 데이터 전송 객체
├── mapper         // MyBatis 등 매퍼 인터페이스
└── Application    // 메인
CREATE TABLE `USERTEST1`
(
    `USER_CD`    int NOT NULL ,
    `USER_ID`    VARCHAR(20) NOT NULL ,
    `USER_PW`    VARCHAR(20) NOT NULL ,
 PRIMARY KEY ( `USER_CD` )
)





* */
public class Application {

    public static void main(String[] args) {
        /*
        CRUD 추가 방법
        user-query 작성
        UserDAO 작성
        Application Test
        */
//        UserDAO userDAO=new UserDAO();

        UserSearchDAO userSearchDAO=new UserSearchDAO();
        UserInsertDAO userInsertDAO=new UserInsertDAO();
        UserDeleteDAO userDeleteDAO=new UserDeleteDAO();
        Connection con = getConnection();

        List<UserDTO> userDTOList=new ArrayList<>();
//        userDAO.selectLastCode(con);
//        userDAO.selectAllCode(con);

        userSearchDAO.selectAllCode(con);
        userSearchDAO.selectLastCode(con);

        UserDTO userDTO1= new UserDTO();
        userDTO1.setUserID("testabcd");
        userDTO1.setUserPassword("1234");
        userInsertDAO.insertNewUser(con,userDTO1);

        UserDTO userDTO2= new UserDTO();
        userDTO2.setUserCode(8);
        userDeleteDAO.deleteUser(con,userDTO2);
    }
}

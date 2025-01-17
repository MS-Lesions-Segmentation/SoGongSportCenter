package Persistence.DAO;

import Persistence.DTO.Lesson;
import Persistence.DTO.LessonRegistrationInfo;
import Persistence.DTO.SaleDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LessonDAO {

    private static final String insertLessonQuery = "INSERT INTO LESSON (id,name,classroom,price,instructor_id) VALUES (?,?,?,?,?)";
    private static final String lessonRegistrationQuery = "INSERT INTO LESSON_REGISTRATION_INFO (id,user_id,lesson_id,registration_date) VALUES (?,?,?,?)";
    private static final String  selectLessonWithUserIdAndLessonIdQuery = "SELECT * FROM LESSON_REGISTRATION_INFO WHERE user_id = ? AND lesson_id = ?";


    private DataSource ds;

    public LessonDAO(){
        try
        {
            Context context = new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/OOSE");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean createLesson(HashMap<String,Object> map)
    {

        try (Connection conn = ds.getConnection();
             PreparedStatement psmt = conn.prepareStatement(insertLessonQuery)) {

            psmt.setInt(1, (int)map.get("lessonId"));
            psmt.setString(2, (String)map.get("lessonName"));
            psmt.setString(3, (String)map.get("classroom"));
            psmt.setInt(4, (int)map.get("price"));
            psmt.setInt(5, (int)map.get("instructorId"));

            int rowNumber = psmt.executeUpdate();
            System.out.println(rowNumber + "has changed");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean lectureRegistration(int id,int userId,int lessonId)
    {

        LessonRegistrationInfo info = selectLessonWithUserIdAndLessonId(userId,lessonId);

        if(info != null) return false;

        Date date = new Date(System.currentTimeMillis());

        try (Connection conn = ds.getConnection();
             PreparedStatement psmt = conn.prepareStatement(lessonRegistrationQuery)) {



            psmt.setInt(1, id);
            psmt.setInt(2, userId);
            psmt.setInt(3, lessonId);
            psmt.setDate(4, date);

            int rowNumber = psmt.executeUpdate();
            System.out.println(rowNumber + "has changed");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }

        return true;

    }

    public LessonRegistrationInfo selectLessonWithUserIdAndLessonId(int userId, int lessonId)
    {
        LessonRegistrationInfo info = new LessonRegistrationInfo();

        try (Connection conn = ds.getConnection();
             PreparedStatement psmt = conn.prepareStatement(selectLessonWithUserIdAndLessonIdQuery)) {

            psmt.setInt(1, userId);
            psmt.setInt(2,lessonId);

            try (ResultSet rs = psmt.executeQuery())
            {
                rs.next();
                info.setId(rs.getInt("id"));
                info.setUserId(rs.getInt("user_id"));
                info.setLessonId(rs.getInt("lesson_id"));
                info.setRegistrationDate(rs.getDate("registration_date"));

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        return info;

    }




}

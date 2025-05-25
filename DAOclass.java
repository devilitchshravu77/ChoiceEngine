package dao;

import model.Question;
import java.sql.*;
import java.util.ArrayList;

public class QuestionDAO {
    public static ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questions = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM questions");

            while (rs.next()) {
                questions.add(new Question(
                        rs.getInt("id"),
                        rs.getString("question"),
                        rs.getString("optionA"),
                        rs.getString("optionB"),
                        rs.getString("optionC"),
                        rs.getString("optionD"),
                        rs.getString("correctOption").charAt(0)
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }
}
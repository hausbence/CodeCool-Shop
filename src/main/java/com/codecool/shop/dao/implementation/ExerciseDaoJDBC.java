package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ExerciseDao;
import com.codecool.shop.model.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDaoJDBC implements ExerciseDao {
    DataSource dataSource;

    public ExerciseDaoJDBC(DataSource dataSource) {
        this.dataSource = dataSource;
    }






    @Override
    public List<Exercise> getAll() throws SQLException {
        Connection conn = dataSource.getConnection();
        Statement stm;
        stm = conn.createStatement();
        String sql = "Select * From exercise";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        List<Exercise> exercises = new ArrayList<>();
        while (rst.next()) {
            Exercise e = new Exercise(rst.getString("title"),rst.getString("question"));
            System.out.println(e.getText());
            e.setId(exercises.size() + 1);
            exercises.add(e);
        }
        return exercises;
    }

    public Exercise getRandomExercise() throws SQLException {
       List<Exercise> all  = getAll();
       System.out.println(all);
       int randomIndex = (int) (Math.random() * (all.size()));
        return all.get(randomIndex);

    }
}

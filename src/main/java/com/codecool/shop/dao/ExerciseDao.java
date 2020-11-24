package com.codecool.shop.dao;

import com.codecool.shop.model.Exercise;

import java.sql.SQLException;
import java.util.List;

public interface ExerciseDao {

    List<Exercise> getAll() throws SQLException;
}

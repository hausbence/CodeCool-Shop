package com.codecool.shop.dao;

import com.codecool.shop.dao.implementation.ExerciseDaoJDBC;
import com.codecool.shop.model.Exercise;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class practiceDatabaseManager {

     ExerciseDaoJDBC orderDao;

    private DataSource connect() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        String dbName =  System.getenv("DB_NAME");
        String user = System.getenv("DB_USERNAME");
        String password = System.getenv("DB_PASSWORD");

        dataSource.setDatabaseName(dbName);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        dataSource.getConnection().close();

        return dataSource;
    }

    public void setup() throws SQLException {
        DataSource dataSource = connect();
        orderDao = new ExerciseDaoJDBC(dataSource);

    }
   public Exercise getRandomExercise() throws SQLException {
        return orderDao.getRandomExercise();
   }
}

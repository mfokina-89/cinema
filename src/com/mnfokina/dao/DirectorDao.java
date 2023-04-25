package com.mnfokina.dao;

import com.mnfokina.entity.Director;
import com.mnfokina.exception.DaoException;
import com.mnfokina.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DirectorDao implements Dao<Integer, Director> {

    private static final DirectorDao INSTANCE = new DirectorDao();
    private static final String DELETE_SQL =
            "DELETE FROM director " +
                    "WHERE id = ? ";

    private static final String SAVE_SQL =
            "INSERT INTO director (full_name, birth_date) " +
                    "VALUES (?, ?) ";

    private static final String UPDATE_SQL =
            "UPDATE director " +
                    "SET full_name = ?, birth_date = ? " +
                    "WHERE id = ? ";

    private static final String FIND_ALL_SQL =
            "SELECT id," +
                    " full_name, " +
                    "birth_date " +
                    "FROM director ";

    private static final String FIND_BY_ID_SQL =
            FIND_ALL_SQL +
                    "WHERE director.id = ? ";

    @Override
    public List<Director> findAll() {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_ALL_SQL)) {
            var resultSet = preparedStatement.executeQuery();
            List<Director> directors = new ArrayList<>();
            while (resultSet.next()) {
                directors.add(buildDirector(resultSet));
            }
            return directors;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    @Override
    public Optional<Director> findById(Integer id) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {
            preparedStatement.setInt(1, id);

            var resultSet = preparedStatement.executeQuery();
            Director director = null;
            if (resultSet.next()) {
                director = buildDirector(resultSet);
            }
            return Optional.ofNullable(director);
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    @Override
    public void update(Director director) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
            preparedStatement.setString(1, director.getFullName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(director.getBirthDate()));

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    @Override
    public Director save(Director director) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, director.getFullName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(director.getBirthDate()));

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                director.setId(generatedKeys.getInt("id"));
            }
            return director;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    @Override
    public boolean delete(Integer id) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    public static DirectorDao getInstance() {
        return INSTANCE;
    }

    private Director buildDirector(ResultSet resultSet) throws SQLException {
        return new Director(
                resultSet.getInt("id"),
                resultSet.getString("full_name"),
                resultSet.getTimestamp("birth_date").toLocalDateTime()
        );
    }
}

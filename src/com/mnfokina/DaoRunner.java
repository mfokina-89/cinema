package com.mnfokina;

import com.mnfokina.dao.DirectorDao;
import com.mnfokina.entity.Director;

import java.time.LocalDateTime;

public class DaoRunner {
    public static void main(String[] args) {
        var director = DirectorDao.getInstance().findById(1);
        System.out.println(director);
    }

    private static void filterTest() {
        var directors = DirectorDao.getInstance().findAll();
        System.out.println(directors);
    }

    private static void updateTest() {
        var directorDao = DirectorDao.getInstance();
        var maybeDirector = directorDao.findById(2);
        System.out.println(maybeDirector);

        maybeDirector.ifPresent(director -> {
            director.setFullName("Элиа Казан");
            directorDao.update(director);
        });
    }

    private static void deleteTest(Integer id) {
        var directorDao = DirectorDao.getInstance();
        var deleteResult = directorDao.delete(id);
        System.out.println(deleteResult);
    }

    private static void saveTest() {
        var directorDao = DirectorDao.getInstance();
        var director = new Director();
        director.setId(7);
        director.setFullName("Оливер Стоун");
        director.setBirthDate(LocalDateTime.of(1946, 9, 15, 0, 0, 0));


        var savedDirector = directorDao.save(director);
        System.out.println(savedDirector);
    }
}

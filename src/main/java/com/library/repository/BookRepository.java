package com.library.repository;

import com.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByTitle(String title);

    List<Book> findByYear(Integer year);

    List<Book> findByPublishing(String publishing);

    List<Book> findByTitleOrYearOrPublishingOrAuthors_NameOrAuthors_SurnameOrAuthors_Gender
            (String title, Integer year, String publishing, String name, String surname, String gender);

    List<Book> findByAuthors_Name(String name);

    List<Book> findByAuthors_Surname(String surname);

    List<Book> findByAuthors_Birthday(Date birthday);

    List<Book> findByAuthors_Gender(String gender);

}

package com.library.repository;

import com.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findAuthorByName(String name);

    List<Author> findAuthorBySurname(String surname);

    List<Author> findAuthorByBirthday(Date date);

    List<Author> findAuthorByGender(String gender);


    // добавить контроль отсутствия авторов у книги

    @Transactional
    @Modifying
    @Query("delete from Author where id=:id")
    void deleteById(@Param("id")Integer id);
}

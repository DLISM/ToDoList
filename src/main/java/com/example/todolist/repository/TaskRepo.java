package com.example.todolist.repository;

import com.example.todolist.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.author.id=?1")
    List<Task> findAllByUserId(Long userId);

}

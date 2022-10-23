package com.example.eTaskify_ver1.dao.repository;

import com.example.eTaskify_ver1.dao.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
//    TaskEntity findByTitle(String title);
    Optional<TaskEntity> findByTitle(String title);
    void deleteById(long id);
}

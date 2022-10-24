package com.example.eTaskify_ver1.dao.entity;

import com.example.eTaskify_ver1.model.enums.TaskStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "abb_schema", name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private TaskStatusEnum statusEnum;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(schema = "abb_schema", name = "users_task",
    joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"))
    private List<UserEntity> usersList;
}

package com.example.Library_managementsystem.Entity;

import com.example.Library_managementsystem.Enum.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;
    private String  mobNo;

    @Enumerated(EnumType.STRING)
     private Department department;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    Card card;
}

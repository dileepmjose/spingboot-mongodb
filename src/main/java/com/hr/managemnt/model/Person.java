package com.hr.managemnt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    private String id;

    private int index;
    private String name;
    private boolean isActive;
    private String registered;
    private int age;
    private String gender;
    private String eyeColor;
    private String favoriteFruit;
    private Company company;
    private List<String> tags;
}

package com.codeclan.example.employee_relationship_lab.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int days;

    @JsonIgnoreProperties(value = "projects")
    @ManyToMany
    @JoinTable(
        name = "employee_projects",
        joinColumns = {@JoinColumn(
                name = "project_id",
                nullable = false,
                updatable = false)
        },
        inverseJoinColumns = {@JoinColumn(
                name = "employee_id",
                nullable = false,
                updatable = false)
        })
    private List<Employee> employees;

    public Project(String name, int days) {
        this.name = name;
        this.days = days;
        this.employees = new ArrayList<>();
    }

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    public void addEmployee(Employee employee){
        this.employees.add(employee);
    }
}

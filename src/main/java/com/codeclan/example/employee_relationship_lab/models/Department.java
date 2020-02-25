package com.codeclan.example.employee_relationship_lab.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "depts")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String deptName;

    @JsonIgnoreProperties("dept")
    @OneToMany(mappedBy = "dept")
    private List<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Department() {
    }

    public String getDeptName() {
        return deptName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

package com.codeclan.example.employee_relationship_lab.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private int employeeNo;

    @JsonIgnoreProperties("employees")
    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Department dept;

    @JsonIgnoreProperties(value = "employees")
    @ManyToMany
    @JoinTable(
            name = "employee_projects",
            joinColumns = {@JoinColumn(
                    name = "employee_id",
                    nullable = false,
                    updatable = false)
            },
            inverseJoinColumns = {@JoinColumn(
                    name = "project_id",
                    nullable = false,
                    updatable = false)
            })
    private List<Project> projects;

    public Employee(String firstName, String lastName, int employeeNo, Department dept) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNo = employeeNo;
        this.dept = dept;
        this.projects = new ArrayList<>();
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Employee() {
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }
    public void addProject(Project project){
        this.projects.add(project);
    }
}

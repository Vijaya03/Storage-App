package com.example.hp.storageaap.Beans;

/**
 * Created by HP on 17-02-2018.
 */

public class Company {
    String name;
    int id;
    int salary;
    public String toString()
    {

        return name+" "+id+" "+salary;
    }

    public Company(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    int salary;
}

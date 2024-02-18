package com.springboot.learnspringboot;

public class Course {
    private long id;
    private String name;
    private String authour;
    public Course(long id, String name, String authour) {
        this.id = id;
        this.name = name;
        this.authour = authour;
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthour() {
        return authour;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authour='" + authour + '\'' +
                '}';
    }
}

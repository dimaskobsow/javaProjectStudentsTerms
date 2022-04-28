package entity;

import java.sql.Date;
import java.util.Objects;

public class Student {
    private int id;
    private String lastName;
    private String name;
    private Group group;
    private Date date;
    private int status;

    public Student() {
    }

    public Student(int id, String lastName, String name, Group group, Date date) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.group = group;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getId() == student.getId() && getStatus() == student.getStatus() && Objects.equals(getLastName(), student.getLastName()) && Objects.equals(getName(), student.getName()) && Objects.equals(getGroup(), student.getGroup()) && Objects.equals(getDate(), student.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLastName(), getName(), getGroup(), getDate(), getStatus());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", group=" + group +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}

package database;

//import com.mysql.cj.Constants;

import com.mysql.cj.Constants;
import entity.Discipline;
import entity.Student;
import entity.Term;
import entity.Group;
import java.sql.*;
import java.util.ArrayList;

import static constants.Config.DB_CONNECTION_URL;

public class DBManager {


    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection
                    (DB_CONNECTION_URL);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select  * from  `discipline`");
            while (rs.next()) {
                System.out.print(rs.getInt("id"));
                System.out.println(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Discipline> getAllActiveDisciplines() {
        ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery
                    ("select  * from `discipline` where `status` = '1'");
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setDiscipline(rs.getString("name"));
                discipline.setId(rs.getInt("id"));
                disciplines.add(discipline);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }

    public static void createNewDiscipline(String disc) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection
                    (DB_CONNECTION_URL);
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO `discipline` (`name`) VALUES ('" + disc + "');");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Discipline gerDisciplineById(String id) {
        Discipline discipline = new Discipline();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection
                    (DB_CONNECTION_URL);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery
                    ("SELECT * FROM students_progress.discipline where id = '" + id + "';");
            while (rs.next()) {

                discipline.setDiscipline(rs.getString("name"));
                discipline.setId(rs.getInt("id"));

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return discipline;
    }

    public static void deleteDiscipline(String id) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection
                    (DB_CONNECTION_URL);
            Statement statement = conn.createStatement();
            statement.execute("UPDATE `discipline` SET `status` = '0' WHERE (`id` = '" + id + "');");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void modifyDiscipline(String id, String disc) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
            Statement statement = conn.createStatement();
            statement.execute("UPDATE `discipline` SET `name` = '" + disc + "' WHERE (`id` = '" + id + "')");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Student> getAllActiveStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT student.last_name,student.name,student.id,group.name,student.date FROM student LEFT JOIN `group` on `group`.id = student.id_group where `status` = '1';");
            while (rs.next()) {
                Student student = new Student();
                Group group = new Group();
                student.setId(rs.getInt("id"));
                student.setLastName(rs.getString("last_name"));
                student.setName(rs.getString("name"));
                group.setName(rs.getString("group.name"));
                student.setGroup(group);
                student.setDate(rs.getDate("date"));
                students.add(student);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void createNewStudents(String studName, String studFirstName, String DateOfEnrollment,String sdudGroup) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection
                    (DB_CONNECTION_URL);
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO `students_progress`.`student` (`last_name`, `name`, `id_group`, `date`, `status`) VALUES ('" + studFirstName + "', '" + studName + "', '1', '" + DateOfEnrollment + "', '1');");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Student getStudentById(String id) {
        Student student = new Student();
        Group group = new Group();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection
                    (DB_CONNECTION_URL);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery
                    ("SELECT * FROM students_progress.student  LEFT JOIN `group` on `group`.id = student.id_group where student.id ='"+id+"';");
            // SELECT * FROM students_progress.student where id ='"+id+"';
            // SELECT student.last_name,student.name,student.id,group.name,student.date FROM student LEFT JOIN `group` on `group`.id = student.id_group
            while (rs.next()) {

                student.setName(rs.getString("name"));
                student.setLastName(rs.getString("last_name"));
                student.setDate(rs.getDate("date"));
                group.setName(rs.getString("group.name"));
                student.setGroup(group);
                student.setId(rs.getInt("id"));

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(student);
        return student;
    }
    public static void modifyStudent(String id, String lastName,String name,String date,String group) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_CONNECTION_URL);
            Statement statement = conn.createStatement();
            statement.execute("UPDATE `students_progress`.`student` SET `last_name` = '"+lastName+"',  `name` = '"+name+"', `date` = '"+date+"' WHERE (`id` = '"+id+"');");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void deleteStudents(String id) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection
                    (DB_CONNECTION_URL);
            Statement statement = conn.createStatement();
            statement.execute("UPDATE `student` SET `status` = '0' WHERE (`id` = '" + id + "');");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static ArrayList<Term> getAllActiveTerms() {
        ArrayList<Term> terms = new ArrayList<Term>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection
                    (DB_CONNECTION_URL);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery
                    ("select  * from `term` where `status` = '1'");
            int count = 1;
            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setName("Семестр" + count);
                count++;
                term.setDuration(rs.getString("duration"));
                terms.add(term);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return terms;
    }
    public static ArrayList<Discipline> getAllActiveDisciplinesByTerm(int idTerm) {
        ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection
                    (DB_CONNECTION_URL);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery
                    ("SELECT d.id, d.name FROM term_discipline as td" +
                            "left join discipline as d on td.id_discipline = d.id" +
                            "where td.id_term = '"+idTerm+"' " +
                            "and d.status = '1' ");
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setDiscipline(rs.getString("name"));
                discipline.setId(rs.getInt("id"));
                disciplines.add(discipline);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplines;
    }
}
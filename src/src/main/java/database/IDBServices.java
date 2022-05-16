package database;
import entity.Discipline;
import entity.Student;
import entity.Term;

import java.util.LinkedList;
import java.util.List;


public interface IDBServices {


    int getAllActiveDisciplines();

    void createDisciplina(String name);

    void modifyDisciplina(String id,String newName);

    void deleteDisciplina(String id);

    List<Term>getAllActiveTerms();

    Term getTermById(String id );

    List<Discipline>getDisciplinesByTerm(String idTerm);

    void createTerm(String duration,String idDisc);

    void modifyTerm(String idTerm,String newDuration,String newIdDisc);

    LinkedList<Student> getAllActiveStudents();

}

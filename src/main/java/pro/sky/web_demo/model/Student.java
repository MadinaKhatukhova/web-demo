package pro.sky.web_demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
//@Table(name = "tbe_student", schema = "public")
public class Student {

    @Id
    @GeneratedValue
   // @Column(name = "id_student")
    private long id;

    //@Column(name = "nm_name")
    private String name;

    //@Column(name = "nn_age")
    private int age;

    @ManyToOne
   // @JoinColumn(name = "id_faculty")
    @JsonIgnore
    private Faculty faculty;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public Student(Long id, String name, Integer age) {
        super();
        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {

        this.age = age;
    }
    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object object) {
        return (this == object ||
                object != null &&
                        getClass() == object.getClass() &&
                        Objects.equals(age, ((Student) object).age) &&
                        Objects.equals(name, ((Student) object).name));
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
    @Override
    public String toString() {
        return String.format("Student: {id=%s, name='%s', age=%s}", id, name, age);
    }
}


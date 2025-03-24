package pro.sky.web_demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.List;
import java.util.Objects;


@Entity
//@Table(name = "tbl_faculty", schema = "public")
public class Faculty {

    @Id
    @GeneratedValue
  //  @Column(name = "id_faculty")
    private long id;

   // @Column(name = "nm_name")
    private String name;

    //@Column(name = "nm_color")
    private String color;

    @OneToMany(mappedBy = "faculty", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Student> students;

    public Faculty(){

    }

    public Faculty(String name, String color){
        this.name = name;
        this.color = color;
    }

    public Faculty(Long id, String name) {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public boolean equals(Object object) {
        return (this ==object
        || object != null && getClass() == object.getClass()) &&
                Objects.equals(name, ((Faculty) object).name) &&
                Objects.equals(color, ((Faculty) object).color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color);
    }
    @Override
    public String toString() {
        return String.format("faculty: {id=%s, name='%s', color='%s'}", id, name, color);
    }


}
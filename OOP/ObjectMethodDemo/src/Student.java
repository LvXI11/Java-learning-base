import java.util.Objects;

public class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
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

    @Override
    public boolean equals(Object obj) {
        if( this == obj) return true;

        if( obj instanceof Student s){
            return this.name.equals(s.name) && this.id == s.id;
        }
        return false;
    }

//    @Override
//    public int hashCode() {
//        int result = Objects.hashCode(name);
//        result = 31 * result + id;
//        return result;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

import api.IAdmin;
import api.IInstructor;
import api.IStudent;
import api.core.impl.Admin;
import api.core.impl.Instructor;
import api.core.impl.Student;
import org.junit.Test;

/**
 * Created by MANO on 3/7/2017.
 */
import static org.junit.Assert.*;
public class IStudentTest {
    private IStudent students = new Student();
    public IAdmin admin = new Admin();
    public IInstructor instructor = new Instructor();

    //* provided this class exists and has met its enrolment capacity.
    //there's enough space to enrol
    @Test
    public void validEnrolement() {
        this.admin.classExists("ECS189E", 2017);
        this.admin.createClass("ECS189E",2017 , "Instructor", 2);
        this.students.registerForClass("Student", "ECS189E", 2017);
        assertTrue(this.students.isRegisteredFor("Student", "ECS189E", 2017));
    }

    //* provided this class exists and has not met its enrolment capacity.
    //can't have more than the capacity
    @Test
    public void invalidEnrolement1() {
        this.admin.createClass("ECS189E",2017 , "Instructor", 2);
        this.students.registerForClass("Student", "ECS189E", 2017);
        this.students.registerForClass("Student1", "ECS189E", 2017);
        this.students.registerForClass("Student2", "ECS189E", 2017);
        assertFalse(this.students.isRegisteredFor("Student3", "ECS189E", 2017));

    }
    //* provided homework exists, student is registered and the class is taught in the current year
    @Test
    public void hw(){
       this.admin.classExists("ECS189E", 2017);
       this.students.registerForClass("Student", "ECS189E", 2017);
       this.instructor.addHomework("Instructor", "ECS189E", 2017, "ecshw", "hw3");
       System.out.println(this.instructor.homeworkExists("ECS189E", 2017, "ecshw"));
       assertTrue(this.instructor.homeworkExists("ECS189E", 2017, "ecshw"));
    }
    //provided the student is registered and the class has not ended.
    @Test
    public void dropping(){
        this.students.registerForClass("Student", "ECS189E", 2017);
        this.admin.classExists("ECS189E", 2017);
        assertTrue(this.students.isRegisteredFor("Student", "ECS189E", 2017));

    }

}
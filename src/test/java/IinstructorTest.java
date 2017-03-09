import api.IAdmin;
import api.IInstructor;
import api.IStudent;
import api.core.impl.Admin;
import api.core.impl.Instructor;
import api.core.impl.Student;
import org.junit.Test;

/**
 * Created by MANO on 3/8/2017.
 */
import static org.junit.Assert.*;
public class IinstructorTest {

    private IStudent students = new Student();
    public IAdmin admin = new Admin();
    public IInstructor instructor = new Instructor();

    //Add homework to class {@code className}, taught in year {@code year}, with title {@code homeworkName},
    //* provided this instructor has been assigned to this class.
    @Test
    public void addHW(){
        this.admin.createClass("ECS189E", 2017, "Instructor", 15);
        this.instructor.addHomework("Instructor", "ECS189E", 2017, "ecshw", "hw3");
        this.admin.getClassInstructor("ECS 189E", 2017);
        assertTrue(this.instructor.homeworkExists("ECS189E", 2017, "ecshw"));


    }
    //Add homework to class {@code className}, taught in year {@code year}, with title {@code homeworkName},
    //* provided this instructor has been assigned to this class.
    @Test
    public void dontaddHW(){
        this.admin.createClass("ECS189E", 2017, "Instructor", 15);
        this.admin.getClassInstructor("ECS50", 2017);
        this.instructor.addHomework("Instructor", "ECS189E", 2017, "ecshw", "hw3");
        assertFalse(this.instructor.homeworkExists("ECS189E", 2017, "ecshw"));


    }


    //* provided this instructor has been assigned to this class, the homework has been assigned and the student has submitted this homework.
    @Test
    public void gradeTest0(){
        this.instructor.assignGrade("Instructor", "ECS189E", 2017, "ecshw", "Student", 0);
        this.students.submitHomework("Student", "ecshw", "answers", "ECS189E",2017);
        this.admin.getClassInstructor("ECS 189E", 2017);
        this.instructor.addHomework("Instructor", "ECS189E", 2017, "ecshw", "hw3");
        assertTrue(this.students.hasSubmitted("Student", "ecshw", "ECS189E", 2017));

    }
    //* provided this instructor has been assigned to this class, the homework has been assigned and the student has submitted this homework.
    @Test
    public void gradeTest(){
        this.instructor.assignGrade("Instructor", "ECS189E", 2017, "ecshw", "Student", 101);
        this.students.submitHomework("Student", "ecshw", "answers", "ECS 189E",2017);
        this.admin.getClassInstructor("ECS 189E", 2017);
        this.instructor.addHomework("Instructor", "ECS189E", 2017, "ecshw", "hw3");
        assertTrue(this.students.hasSubmitted("Student", "ecshw", "ECS189E", 2017));

    }

    //* provided this instructor has been assigned to this class, the homework has NOT been assigned and the student has submitted this homework.
    @Test
    public void gradeTest1(){
        this.students.submitHomework("Student", "ecshw", "answers", "ECS189E",2017);
        this.instructor.homeworkExists("ECS189E", 2017, "ecshw");
        assertFalse(this.students.hasSubmitted("Student", "ecshw", "ECS189E", 2017));

    }
    //* provided this instructor has NOT been assigned to this class, the homework has been assigned and the student has submitted this homework.
    @Test
    public void gradeTest2(){
        this.students.submitHomework("Student", "ecshw", "answers", "ECS189E",2017);
        this.admin.getClassInstructor("ECS189E", 2017);
        assertFalse(this.students.hasSubmitted("Student", "ecshw", "ECS189E", 2017));

    }
    //* provided this instructor has been assigned to this class, the homework has been assigned and the student has NOT submitted this homework.
    @Test
    public void gradeTest3(){
        this.admin.getClassInstructor("ECS189E", 2017);
        this.instructor.homeworkExists("ECS189E", 2017, "ecshw");
        assertFalse(this.students.hasSubmitted("Student", "ecshw", "ECS189E", 2017));

    }
    //* provided this instructor has Not been assigned to this class, the homework has NOT been assigned and the student has NOT submitted this homework.
    @Test
    public void gradeTest4(){
        this.instructor.homeworkExists("ECS189E", 2017, "ecshw");
        assertFalse(this.students.hasSubmitted("Student", "ecshw", "ECS189E", 2017));

    }
    //* provided this instructor has NOT been assigned to this class, the homework has NOT been assigned and the student has submitted this homework.
    @Test
    public void gradeTest5(){
        this.students.submitHomework("Student", "ecshw", "answers", "ECS189E",2017);
        assertFalse(this.students.hasSubmitted("Student", "ecshw", "ECS189E", 2017));

    }
    //* provided this instructor has been assigned to this class, the homework has NOT been assigned and the student has NOT submitted this homework.
    @Test
    public void gradeTest6(){
        this.admin.getClassInstructor("ECS189E", 2017);
        assertFalse(this.students.hasSubmitted("Student", "ecshw", "ECS189E", 2017));

    }


}

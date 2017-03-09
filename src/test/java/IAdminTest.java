/**
 * Created by MANO on 2/28/2017.
 */

import api.IAdmin;
import api.core.impl.Admin;
import org.junit.Test;
import static org.junit.Assert.*;

public class IAdminTest {

    private IAdmin admin = new Admin();

    @Test
    public void validClass() {
        this.admin.createClass("ECS189E", 2017, "Instructor", 15);
        assertTrue(this.admin.classExists("ECS189E", 2017));
    }

    @Test
    public void twoClasses() {
        this.admin.createClass("ECS189E", 2017, "Instructor", 15);
        this.admin.createClass("ECS40", 2017, "Instructor", 15);
        assertTrue(this.admin.classExists("ECS189E", 2017));
    }
    @Test
    public void threeClasses() {
        this.admin.createClass("ECS189E", 2017, "Instructor", 15);
        this.admin.createClass("ECS40", 2017, "Instructor", 15);
        this.admin.createClass("ECS30", 2017, "Instructor", 15);
        assertFalse(this.admin.classExists("ECS189E", 2017));
    }
    @Test
    public void classDuplicates() {
        this.admin.createClass("ECS189E", 2017, "Instructor", 15);
        this.admin.createClass("ECS189E", 2017, "Instructor", 15);
        assertFalse(this.admin.classExists("ECS189E", 2017));
    }

    @Test
    public void classDuplicates1() {
        this.admin.getClassInstructor("ECS189E", 2017);
        this.admin.getClassInstructor("ECS189E", 2017);
        assertFalse(this.admin.classExists("ECS189E", 2017));
    }
    @Test
    public void classDuplicates2() {
        this.admin.getClassInstructor("ECS189E", 2018);
        this.admin.getClassInstructor("ECS189E", 2017);
        assertTrue(this.admin.classExists("ECS189E", 2017));
    }
    @Test
    public void classDuplicates3() {
        this.admin.getClassInstructor("ECS30", 2017);
        this.admin.getClassInstructor("ECS189E", 2017);
        assertTrue(this.admin.classExists("ECS189E", 2017));
    }



    @Test
    public void validYear1() {
        this.admin.createClass("ECS189E", 2017, "Instructor", 15);
        assertTrue(this.admin.classExists("ECS189E", 2017));
    }

    @Test
    public void validYear2() {
        this.admin.createClass("ECS189E", 2018, "Instructor", 15);
        assertTrue(this.admin.classExists("ECS189E", 2018));
    }

    @Test
    public void pastYear() {
        this.admin.createClass("ECS189E", 2016, "Instructor", 15);
        assertFalse(this.admin.classExists("ECS189E", 2017));
    }

    @Test
    public void validCapacity() {
        this.admin.createClass("ECS189E", 2017, "Instructor", 79);
        assertTrue(this.admin.classExists("ECS189E", 2017));

    }

    @Test
    public void negCapacity() {
        this.admin.createClass("ECS189E", 2017, "Instructor", -1);
        assertFalse(this.admin.classExists("ECS189E", 2017));
    }

    @Test
    public void moreCapacity() {
        this.admin.createClass("ECS189E", 2017, "Instructor", 79);
        this.admin.createClass("ECS189E", 2017, "Instructor", 78);
        assertFalse(this.admin.classExists("ECS189E", 2017));
    }

    @Test
    public void lessCapacity() {
        this.admin.createClass("ECS189E", 2017, "Instructor", 79);
        this.admin.createClass("ECS189E", 2017, "Instructor", 80);
        assertFalse(this.admin.classExists("ECS189E", 2017));
    }

    @Test
    public void zeroCapacity() {
        this.admin.createClass("ECS189Et", 2017, "Instructor", 15);
        this.admin.getClassCapacity("ECS189E", 2017);
        assertFalse(this.admin.classExists("ECS189E", 2017));
    }
    //* Adjust the capacity (maximum number of students) of class {@code className} to new capacity {@code capacity}

    @Test
    public void adjCapacity() {
        this.admin.createClass("ECS189E", 2017, "Instructor", 79);
        this.admin.changeCapacity("ECS189E", 2017, 79);
        assertTrue(this.admin.classExists("ECS189E", 2017));
    }



}


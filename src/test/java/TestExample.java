import api.IAdmin;
import api.IInstructor;
import api.core.impl.Admin;
import api.core.impl.Instructor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vincent on 23/2/2017.
 */
public class TestExample {

    private IAdmin admin;

    @Before
    public void setup() {
        this.admin = new Admin();
    }

    private IInstructor instructor;

    @Before
    public void setup2() {
        this.instructor = new Instructor();
    }

    @Test
    public void testMakeClass() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        assertTrue(this.admin.classExists("Test", 2017));
    }

    @Test
    public void testMakeClass2() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        assertFalse(this.admin.classExists("Test", 2016));
    }
}

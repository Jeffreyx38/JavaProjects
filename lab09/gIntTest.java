
import junit.framework.*;

public class gIntTest extends TestCase {

    private gInt test1, test2;

    private gInt normTest;

    protected void setUp(){
        test1 = new gInt(2, 3);
        test2 = new gInt(3, 2);

        normTest = new gInt(3, 4);
    }

    public void testAdd(){
	//pre-con
        gInt expected= new gInt(5, 5);
	//pos-con
        gInt sum = test1.add(test2);
        assertNotNull(sum);
        assertEquals(sum.real(), expected.real());
        assertEquals(sum.imag(), expected.imag());
    }

    public void testMultiply(){
	//pre-con
        gInt expected = new gInt (0, 13);
	//post-con
        gInt multi = test1.multiply(test2);
        assertNotNull(multi);
        assertEquals(multi.real(), expected.real());
        assertEquals(multi.imag(), expected.imag());

    }

    public void testNorm() {
	//pre-con
        float expected = (float)5.0; 
	//post-con
        float test = normTest.norm();
        assertNotNull(test);

        assertEquals(test, expected);
    }


    public static Test suite() {
        return new TestSuite(gIntTest.class);
    }

    public static void main() {
        String[] caseName = { gIntTest.class.getName() };
        junit.textui.TestRunner.main(caseName);
    }

}

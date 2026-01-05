import org.example.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    public void setUp(){
        validator = new Validator();
    }

    @Test
    public void testInvalidNumbers(){
        assertFalse(validator.validateNumber("0123456789"));
        assertFalse(validator.validateNumber("4024 0071 0902 2143"));
        assertFalse(validator.validateNumber("Hi Hello"));
        assertFalse(validator.validateNumber("2345TO3465"));
    }

    @Test
    public void testValidNumber(){
        assertTrue(validator.validateNumber("4556 7375 8689 9855"));
    }
}

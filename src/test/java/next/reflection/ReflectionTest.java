package next.reflection;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReflectionTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    public void showClass() {
        Class<Question> clazz = Question.class;
        logger.debug(clazz.getName());
    }

    @Test
    @SuppressWarnings("rawtypes")
    public void constructor() throws Exception {
        Class<Question> clazz = Question.class;
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] parameterTypes = constructor.getParameterTypes();
            logger.debug("paramer length : {}", parameterTypes.length);
            for (Class paramType : parameterTypes) {
                logger.debug("param type : {}", paramType);
            }
        }
    }
    
    @Test
    public void privateFieldAccess() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    	Class<Student> clazz = Student.class;
    	
    	Field name = clazz.getDeclaredField("name");
    	Field age = clazz.getDeclaredField("age");
    	
    	name.setAccessible(true);
    	age.setAccessible(true);
    	
    	Student student = new Student();
    	name.set(student, "재민");
    	age.set(student, 30);

    	assertEquals("재민", student.getName());
    	assertEquals(30, student.getAge());
    }
}

import lombok.*;

import java.io.InputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLStreamHandler;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;


public class test {
//    Constructor[] getDeclaredConstructors()
//    Field[] getDeclaredFields()
//    Method[] getDeclaredMethods()

    //    URL getResource(String name)
//    InputStream getResourceAsStream(String name)
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.CONSTRUCTOR
            , ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE})
    public @interface TestAnnotation {
    }
//    isAnnotationPresent(어노테이션이름.클래스)

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(arr[-1]);
    }

}

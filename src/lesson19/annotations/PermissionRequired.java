package lesson19.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Target() указывает на сферу ответственности аннотации. Например:
//METHOD
//CONSTRUCTOR
//FIELD
//@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
// Указывает, в каком случае будет работать кусок кода под данной мета-аннотацией. Другой пример:
//@Retention(RetentionPolicy.CLASS)

// Для создания аннотации вместо class пишется @interface
public @interface PermissionRequired {

    User.Permission value();
//    Методы в аннотациях не могут принимать параметры, а возвращают только примитивы, строки, enum и аннотации



}

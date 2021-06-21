package it.luca.data.generator.pojo;

import it.luca.data.annotation.*;
import it.luca.data.exception.MissingDataAnnotationException;
import it.luca.data.exception.MissingNoArgConstructorException;
import it.luca.data.generator.function.RandomDateTimeSupplier;
import it.luca.data.generator.function.RandomNumberSupplier;
import it.luca.data.generator.function.RandomValueSupplier;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static it.luca.utils.functional.Optional.isPresent;
import static it.luca.utils.functional.Stream.anyMatch;
import static it.luca.utils.functional.Stream.filter;

public class PojoGenerator {

    public static <T> T generate(Class<T> tClass) throws Exception {

        // Find a no-arg constructor
        Optional<Constructor<?>> optionalConstructor = Arrays
                .stream(tClass.getDeclaredConstructors())
                .filter(x -> x.getParameterCount() == 0)
                .findFirst();

        if (optionalConstructor.isPresent()) {

            // Create empty instance of T
            @SuppressWarnings("unchecked")
            T instance = (T) optionalConstructor.get().newInstance();
            List<Method> classMethods = Arrays.asList(tClass.getDeclaredMethods());
            List<Field> fieldsWithSetter = filter(tClass.getDeclaredFields(), field ->
                    anyMatch(classMethods, method -> method.getName().equals(String.format("set%s", StringUtils.capitalize(field.getName())))));

            // For each field with declared setter, invoke such setter
            for (Field field : fieldsWithSetter) {

                Method fieldSetter = tClass.getDeclaredMethod(String.format("set%s", StringUtils.capitalize(field.getName())), field.getType());
                fieldSetter.invoke(instance, generateSetterParameter(field));
            }

            // return non-empty instance of T
            return instance;
        } else {
            throw new MissingNoArgConstructorException(tClass);
        }
    }

    private static Object generateSetterParameter(Field field) throws Exception {

        Object setterObject;
        Predicate<Class<? extends Annotation>> isAnnotatedWith = aClass -> isPresent(field.getAnnotation(aClass));
        if (isAnnotatedWith.test(RandomDateTime.class)) {
            setterObject = new RandomDateTimeSupplier(field.getAnnotation(RandomDateTime.class)).apply();
        } else if (isAnnotatedWith.test(RandomNumber.class)) {
            setterObject = new RandomNumberSupplier(field.getAnnotation(RandomNumber.class)).apply();
        } else if (isAnnotatedWith.test(RandomValue.class)) {
            setterObject = new RandomValueSupplier(field.getAnnotation(RandomValue.class)).apply();
        } else if (isAnnotatedWith.test(RandomPojo.class)) {
            setterObject = generate(field.getAnnotation(RandomPojo.class).pojoClass());
        } else if (isAnnotatedWith.test(RandomSequence.class)) {
            List<Object> sequence = new ArrayList<>();
            RandomSequence randomSequence = field.getAnnotation(RandomSequence.class);
            for (int i = 0; i < randomSequence.size(); i ++) {
                sequence.add(generate(randomSequence.of()));
            }

            setterObject = sequence;
        } else {
            throw new MissingDataAnnotationException(field);
        }

        return setterObject;
    }
}

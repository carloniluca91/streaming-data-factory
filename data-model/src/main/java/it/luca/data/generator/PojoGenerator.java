package it.luca.data.generator;

import it.luca.data.annotation.RandomDateTime;
import it.luca.data.annotation.RandomNumber;
import it.luca.data.annotation.RandomValue;
import it.luca.data.exception.MissingNoArgConstructorException;
import it.luca.data.generator.function.RandomNumberSupplier;
import it.luca.data.generator.function.RandomValueSupplier;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
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

        Function<Field, String> setterName = field -> String.format("set%s", StringUtils.capitalize(field.getName()));
        if (optionalConstructor.isPresent()) {

            // Create empty instance of T
            @SuppressWarnings("unchecked")
            T instance = (T) optionalConstructor.get().newInstance();
            List<Method> classMethods = Arrays.asList(tClass.getDeclaredMethods());
            List<Field> fieldsWithSetter = filter(tClass.getDeclaredFields(), field ->
                    anyMatch(classMethods, method -> method.getName().equals(setterName.apply(field))));

            // For each field with declared setter, invoke such setter
            for (Field field : fieldsWithSetter) {

                Method fieldSetter = tClass.getDeclaredMethod(String.format("set%s", StringUtils.capitalize(field.getName())), field.getType());
                Object fieldSetterParameter = createSetterParameter(field);
                fieldSetter.invoke(instance, fieldSetterParameter);
            }

            // return non-empty instance of T
            return instance;
        } else {
            throw new MissingNoArgConstructorException(tClass);
        }
    }

    private static Object createSetterParameter(Field field) throws IllegalAccessException, InstantiationException {

        Predicate<Class<? extends Annotation>> isAnnotatedWith = aClass -> isPresent(field.getAnnotation(aClass));
        if (isAnnotatedWith.test(RandomDateTime.class)) {
            RandomDateTime randomDateTime = field.getAnnotation(RandomDateTime.class);
            return randomDateTime.generator().newInstance().apply();
        } else if (isAnnotatedWith.test(RandomNumber.class)) {
            return new RandomNumberSupplier(field.getAnnotation(RandomNumber.class)).apply();
        } else if (isAnnotatedWith.test(RandomValue.class)) {
            return new RandomValueSupplier(field.getAnnotation(RandomValue.class)).apply();
        } else throw new IllegalArgumentException();
    }
}

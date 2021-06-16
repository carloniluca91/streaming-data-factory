package it.luca.data.generator;

import it.luca.data.annotation.RandomDateTime;
import it.luca.data.exception.MissingNoArgConstructorException;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PojoGenerator {

    public static <T> T generate(Class<T> tClass) throws Exception {

        Optional<Constructor<?>> optionalConstructor = Arrays.stream(tClass.getDeclaredConstructors())
                .filter(x -> x.getParameterCount() == 0).findFirst();

        if (optionalConstructor.isPresent()) {

            @SuppressWarnings("unchecked")
            T instance = (T) optionalConstructor.get().newInstance();
            List<Field> fieldsWithSetter = Arrays.stream(tClass.getDeclaredFields()).filter(x ->
                    Arrays.stream(tClass.getDeclaredMethods())
                            .anyMatch(m -> m.getName().equals(String.format("set%s", StringUtils.capitalize(x.getName())))))
                    .collect(Collectors.toList());

            for (Field field : fieldsWithSetter) {

                Method fieldSetter = tClass.getDeclaredMethod(String.format("set%s", StringUtils.capitalize(field.getName())), field.getType());
                Object fieldSetterParameter = createSetterParameter(field);
                fieldSetter.invoke(instance, fieldSetterParameter);
            }

            return instance;
        } else {
            throw new MissingNoArgConstructorException(tClass);
        }
    }

    private static Object createSetterParameter(Field field) throws IllegalAccessException, InstantiationException {

        Predicate<Class<? extends Annotation>> isAnnotatedWith = aClass -> Optional.ofNullable(field.getAnnotation(aClass)).isPresent();
        if (isAnnotatedWith.test(RandomDateTime.class)) {
            RandomDateTime randomDateTime = field.getAnnotation(RandomDateTime.class);
            return randomDateTime.generator().newInstance().apply();
        } else return null;
    }
}

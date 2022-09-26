package com.nixsolutions.alextuleninov.thirteen.task1.mapping;

import com.nixsolutions.alextuleninov.thirteen.task1.parsing.CSVTable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class CSVMapper implements Mapper {

    @Override
    public <T> List<T> map(CSVTable table, Class<T> resultType) {

        List<T> result = new ArrayList<>();

        for (int i = 1; i < table.getCsvTable().size(); i++) {

            try {
                Constructor<T> constructor = resultType.getConstructor();

                T target = constructor.newInstance();

                for (Field field : resultType.getFields()) {
                    PropertyKey key = field.getAnnotation(PropertyKey.class);
                    if (key == null) continue;
                    String prop = table.getCsvTable().get(i).get(key.value() + (i - 1)/*элемент с индексом 0*/);
                    if (prop == null) continue;

                    Class<?> type = field.getType();
                    if (type == String.class) {
                        field.set(target, prop);
                    } else if (type.isEnum()) {
                        field.set(target, Enum.valueOf((Class<Enum>) type, prop));
                    } else if (type == int.class || type == Integer.class) {
                        field.setInt(target, Integer.parseInt(prop));
                    } else if (type == long.class || type == Long.class) {
                        field.setLong(target, Long.parseLong(prop));
                    } else if (type == double.class || type == Double.class) {
                        field.setDouble(target, Double.parseDouble(prop));
                    } else if (type == boolean.class || type == Boolean.class) {
                        field.setBoolean(target, Boolean.parseBoolean(prop));
                    } else {
                        throw new UnsupportedOperationException("Unsupported field type (" +
                                type.getName() + ") is required for field " +
                                field.getName());
                    }

                }

                result.add(target);
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }
        return result;
    }

}

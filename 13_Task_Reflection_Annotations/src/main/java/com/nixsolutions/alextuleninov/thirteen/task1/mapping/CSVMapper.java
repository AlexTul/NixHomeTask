/*
 * Copyright (c) 2022
 * For Nix
 */

package com.nixsolutions.alextuleninov.thirteen.task1.mapping;

import com.nixsolutions.alextuleninov.thirteen.task1.parsing.CSVTable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * The CSVMapper class is a class fo to create a list
 * of objects of a given type from the table CSV data.
 * */
public class CSVMapper implements Mapper {

    /**
     * The method to create a list
     * of objects of a given type from the table CSV data.
     *
     * @param table             resources
     * @param resultType        class - template
     * */
    @Override
    public <T> List<T> map(CSVTable table, Class<T> resultType) {

        List<T> result = new ArrayList<>();

            try {
                    // берем конструктор по умолчанию
                    Constructor<T> constructor = resultType.getConstructor();
                    // достанем поля, одни на все классы
                    //Field[] fields = resultType.getFields(); // если только паблик поля потомка и родителя
                    Field[] fields = resultType.getDeclaredFields(); // в том числе и приватные

                for (int i = 1; i < table.getCsvTable().size(); i++) {
                    // создаем новый инстанс
                    T target = constructor.newInstance();

                    // походим по всем public полям этого инстанса
                    for (Field field : fields) {

                        // берем аннотацию проперти кей
                        PropertyKey key = field.getAnnotation(PropertyKey.class);
                        // если она не существует, то продолжаем
                        if (key == null) continue;
                        // берем значение prop из нашей таблицы
                        String prop = table.getCsvTable().get(i).get(key.value()/*индекс элемента в i строке*/);
                        if (prop == null) continue;

                        // берем тип поля и в зависимости от этого инициализируем значение с нашего prop
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
                            field.setAccessible(true);
                            field.setBoolean(target, Boolean.parseBoolean(prop));
                        } else {
                            throw new UnsupportedOperationException("Unsupported field type (" +
                                    type.getName() + ") is required for field " +
                                    field.getName());
                        }
                    }
                    result.add(target);
                }
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        return result;
    }

}

package com.aci.uimanagement.model.types;

import java.lang.reflect.InvocationTargetException;

import com.google.common.base.CaseFormat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum PropertyType {

    ELEMENT_ORDER(Long.class, long.class), LAYOUT_TYPE(LayoutType.class), ANGULAR_COMPONENT_NAME(String.class), FIELD_TYPE(FieldType.class), WIDTH(String.class);

    private Class<?> convertClass;

    private Class<?> methodClass;

    PropertyType(Class<?> convertClass, Class<?> methodClass) {
        this.methodClass = methodClass;
        this.convertClass = convertClass;

    }

    PropertyType(Class<?> convertAndMethodClass) {
        this.methodClass = convertAndMethodClass;
        this.convertClass = convertAndMethodClass;

    }

    public void setProperty(Object object, String value) {
        try {
            object.getClass().getMethod(convertToMethodName("set", this.name()), this.methodClass).invoke(object, convert(this.convertClass, value));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Failed to set property: {} -> {} to object {}", this, value, object);
        }
    }


    private Object convert(Class<?> clazz, String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (value == null) {
            return null;
        }
        if (clazz == String.class) {
            return value;
        }
        return clazz.cast(clazz.getDeclaredMethod("valueOf", String.class).invoke(null, value));
    }

    private String convertToMethodName(String prefix, String value) {
        return prefix + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, value);
    }


}

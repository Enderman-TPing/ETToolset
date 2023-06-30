package com.et.toolset.tools.preloader;

import java.lang.reflect.Method;

import static com.et.toolset.tools.preloader.Preload.preload;

public class PreloaderFinder {
    protected static Class<?> _class = findMainClass();

    static {
        if (_class != null && _class.isAnnotationPresent(UsePreloader.class)) {
            preload(_class.getAnnotation(UsePreloader.class).loggerLevel(), _class.getAnnotation(UsePreloader.class).loggerFileOutput(), _class.getAnnotation(UsePreloader.class).deamonRunMethod());
        }
    }

    private static Class<?> findMainClass() {
        String mainClassName = System.getProperty("sun.java.command");
        String[] parts = mainClassName.split("\\s+");

        try {
            return Class.forName(parts[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        //TODO
    }
}
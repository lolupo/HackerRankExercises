package org.exercises;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;

@Slf4j
public class ToolsClass {
    private static final ClassLoader CLASSLOADER = ToolsClass.class.getClassLoader();

    private ToolsClass() {
    }

    public static InputStream getFile(Class<?> aClass) {
        String fileName = aClass.getPackage().getName().replace(".", "/") + "/" + aClass.getSimpleName() + ".txt";
        InputStream stream = CLASSLOADER.getResourceAsStream(fileName);
        if (stream != null) {
            log.debug("Successfully load file : {}", fileName);
            return stream;
        } else {
            log.error("Fail loading file : {}", fileName);
            throw new RuntimeException();
        }
    }
}

package com.walle.jvm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
/**
 * 简单的自定义类加载器的示例，它继承自java.lang.ClassLoader并实现了findClass()方法
 */
public class CustomClassLoader extends ClassLoader {

    private URL classPathLocation;

    public CustomClassLoader(ClassLoader parent, URL classPathLocation) {
        super(parent);
        this.classPathLocation = classPathLocation;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        // 将类名转换为路径形式
        String path = className.replace('.', '/') + ".class";
        String classResource = classPathLocation.toExternalForm() + "/" + path;

        try (InputStream is = new URL(classResource).openStream()) {
            if (is != null) {
                // 读取类文件的字节
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int b;
                while ((b = is.read()) != -1) {
                    baos.write(b);
                }

                // 将字节数组转换为Class对象
                byte[] classBytes = baos.toByteArray();
                return defineClass(className, classBytes, 0, classBytes.length);
            } else {
                throw new ClassNotFoundException("Could not find the class file for " + className);
            }
        } catch (IOException e) {
            throw new ClassNotFoundException("Failed to load class due to IOException", e);
        }
    }
}


package com.huawei.classroom.student.h18;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Properties;

public class MyClassFactory {

    private Properties properties = new Properties();

    public MyClassFactory() {
        // TODO Auto-generated constructor stub
    }

    public MyClassFactory(String path) {
        File file = new File(path);
        try(InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file),"UTF-8")){
            properties.load(inputStreamReader);
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public <T>T createInstance(Class c) {
        Object object = null;
        try{
            Class clazz = Class.forName(c.getName());
            object  = clazz.newInstance();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        for(Field field : c.getDeclaredFields()) {
            String field_name = field.getName();
            String name = c.getName() + "." + field_name;
            String value = properties.getProperty(name);
            field.setAccessible(true);
            if(value == null) {
                continue;
            }else if (value.charAt(0) == '\"') {
                try{
                    value = value.replace("\"", "");
                    field.set(object, value);
                }catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }else{
                try {
                    field.set(object, Integer.parseInt(value));
                }catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }
        return (T)object;

    }
}

package com.huawei.classroom.student.h19.q05;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class StudentUtil {
    public StudentUtil() {
        // TODO Auto-generated constructor stub
    }
    public List<String> sort(String filename){
        File file = new File(filename);
        List<String> result = new ArrayList();
        try(InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "UTF-8");){
            char[] buf = new char[1024];
            String info = "";
            int readed = 0;
            while((readed =inputStreamReader.read(buf))!= -1) {
                info += new String(buf,0,readed);
            }
            info = info.replace("\r\n","");
            String[] contents = info.split(";");

            TreeSet<Student> sorted_students = new TreeSet<>();
            HashMap<String, Student> students = new HashMap<>();
            for(int i = 0; i < contents.length; i ++) {
                String str= contents[i];
                String[] tmp = str.split(",");
                if(students.containsKey(tmp[0])) {
                    students.get(tmp[0]).set_score(tmp[1], tmp[2]);
                }
                else {
                    Student new_student = new Student();
                    new_student.set_name(tmp[0]);
                    new_student.set_score(tmp[1], tmp[2]);
                    students.put(tmp[0], new_student);
                }
            }
            for(String key : students.keySet()) {
                students.get(key).set_total();
                sorted_students.add(students.get(key));
            }
            for(Student student:sorted_students) {
                result.add(student.name);
            }
            return result;
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }
}

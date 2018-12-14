package javaSerializable.clone;

import java.io.IOException;

public class CloneDemo  {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Teacher teacher=new Teacher();
        teacher.setName("zhangsan");

        Student student=new Student();
        student.setName("lisi");
        student.setAge(89);
        student.setTeacher(teacher);

        Student student2=(Student) student.deepClone(); //克隆一个对象
        System.out.println(student);

        student2.getTeacher().setName("james");
        System.out.println(student2);


    }

}

package javaSerializable.parent;

import java.io.Serializable;

public class SuperUser  {



    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "age=" + age +
                '}';
    }

}

package javaSerializable;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = -2572627257192440740L;

    private int age;

    private String name;

    public static  String address = "init";

    public transient   String address1 = "init";

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' + address1 +
                '}';
    }
}

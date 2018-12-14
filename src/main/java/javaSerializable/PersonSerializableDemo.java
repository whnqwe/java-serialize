package javaSerializable;

import java.io.*;

public class PersonSerializableDemo {


    public static void main(String[] args) {
        SerializePerson();

        Person.address  = "modify";

        Person person = UnSerializePerson();

        System.out.println(person);

    }

    private  static  void  SerializePerson(){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("person")));
            Person person = new Person();
            person.setAge(34);
            person.setName("test");
            objectOutputStream.writeObject(person);
            objectOutputStream.flush();
            objectOutputStream.writeObject(person);
            objectOutputStream.flush();

            System.out.println("序列化成功"+new File("person").length());
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static  Person UnSerializePerson(){
        ObjectInputStream ois= null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("person")));
            Person person=(Person)ois.readObject();
            return person;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;


    }

}

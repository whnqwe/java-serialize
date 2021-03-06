# serialize

> 恰当的序列化协议不仅可以提高系统的通用性、强壮型、安全性、优化性能。同时还能让系统更加易于调试和扩展恰当的序列化协议不仅可以提高系统的通用性、强壮型、安全性、优化性能。同时还能让系统更加易于调试和扩展

## java-serialize

### 步骤

1.	实现Serializable接口
   2.ObjectInputStream:表示读取指定的字节数据转换成对象
   3.ObjectOutputStream:表示将对象转为了字节数据

### serialVersionUID的作用

> 文件流中的class和classpath中的class，也就是修改过后的class，不兼容了，处于安全机制考虑，程序抛出了错误，并且拒绝载入。从错误结果来看，如果没有为指定的class配置serialVersionUID，那么java编译器会自动给这个class进行一个摘要算法，类似于指纹算法，只要这个文件有任何改动，得到的UID就会截然不同的，可以保证在这么多类中，这个编号是唯一的。所以，由于没有显指定 serialVersionUID，编译器又为我们生成了一个UID，当然和前面保存在文件中的那个不会一样了，于是就出现了2个序列化版本号不一致的错误。


> 只要我们自己指定了serialVersionUID，就可以在序列化后，去添加一个字段，或者方法，而不会影响到后期的还原，还原后的对象照样可以使用，而且还多了方法或者属性可以用。


### 静态变量的序列化

> transient关键字表示指定属性不参与序列化

```java
public class Person implements Serializable {
    public static  String address = "init";
}

Person.address  = "modify";

Person person = UnSerializePerson();

System.out.println(person); //address='modify'

```

###  Transient关键字

> transient关键字表示指定属性不参与序列化

### 父子类问题

> 如果父类没有实现序列化，而子类实现列序列化。那么父类中的成员没办法做序列化操作


> 子类实现Serializable  父类不实现Serializable   父类没办法序列化


>  父类实现Serializable  子类不实现Serializable   子类没办法序列化


>  父类不实现Serializable  子类不实现Serializable   程序报异常

### 序列化的存储规则

> 对同一个对象进行多次写入，打印出的第一次存储结果和第二次存储结果，只多了5个字节的引用关系。并不会导致文件累加


## 序列化实现深度克隆

### 浅拷贝

> 被复制对象的所有变量都含有与原来的对象相同的值，而所有的对其他对象的引用仍然指向原来的对象。
>   　　换言之，浅拷贝仅仅复制所拷贝的对象，而不复制它所引用的对象。

### 深拷贝

> 被复制对象的所有变量都含有与原来的对象相同的值，除去那些引用其他对象的变量。
>   　　那些引用其他对象的变量将指向被复制过的新对象，而不再是原有的那些被引用的对象。
>   　　换言之，深拷贝把要复制的对象所引用的对象都复制了一遍

### 实现

```java
//序列化
ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
objectOutputStream.writeObject(this);

//反序列化
ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
```
## 常见序列化方式对比

### 序列化方式性能对比总览
![](image/xuliehua.jpg)



### JackJson/fastJson/protoBuf/hession对比

> 在i7处理器，内存8G  操作系统为win10  环境下的测试结果

```java
public class Person{
  private int age = 89;
  private String name = "zhangsan";
}
```



```html
jackson序列化：126ms : 总大小->28

fastjson序列化：128ms : 总大小->28

protobuf序列化：27ms : 总大小->12

Hessian序列化：7ms : 总大小->62

```



> jackson 与 fastjson  序列化所用时间相近，字节数组大小相同



> protobuf  生成的字节数组最小，所用时间比jackson与fastjson少



> Hession所有时间最小，但生成的字节数组的做大
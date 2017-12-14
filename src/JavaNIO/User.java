package JavaNIO;

import java.io.Serializable;

public class User implements Serializable {
      
    private static final long serialVersionUID = 588789688009378496L;  
  
    private int age;  
      
    private String name;  
      
    /* Ignore this attribution */  
    private transient String school;  
  
    public User(String name, int age, String school){  
        this.name = name;  
        this.age = age;  
        this.school = school;  
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
  
    public String getSchool() {  
        return school;  
    }  
  
    public void setSchool(String school) {  
        this.school = school;  
    }  
  
    @Override  
    public String toString() {  
        return "User [age=" + age + ", name=" + name + ", school=" + school  
                + "]";  
    }  
}  
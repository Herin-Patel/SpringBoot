package org.example;

public class Dev {

    private Computer compObj;
    private int age;

    public Dev() {
        System.out.println("This is a Dev constructor");
    }

    public Dev(Computer compObj, int age) {
        this.compObj = compObj;
        this.age = age;
        System.out.println("Constructor value initialized in XML file");
    }

    public Computer getCompObj() {
        return compObj;
    }

    public void setCompObj(Computer compObj) {
        this.compObj = compObj;
    }

    public void build() {
        System.out.println("Creating a simple Spring project without SpringBoot");
        compObj.compile();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

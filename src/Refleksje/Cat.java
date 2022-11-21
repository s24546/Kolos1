package Refleksje;

public class Cat {
    private final String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void meow(){
        System.out.println("Meow");
    }

    private void heyThisIsPrivate(){
        System.out.println("How did you call this?");
    }

    public static void thisIsPublicStaticMethod(){
        System.out.println("Im public and static");
    }

    private static void thisIsPrivateStaticMethod(){
        System.out.println("Im private and static");
    }

    //getters etc
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
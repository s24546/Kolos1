package Generyczność;

import java.util.Random;

public class Printer <T> { //własny typ generyczny
    public T number; //typ pola w klasie,

    public Printer(T number) {
        this.number = number;
    }

    public void drukuj() {
        System.out.println("Liczba:" + number);
    }

    public T zwroc(){   //typ wyniku metody
        return number;
    }

    public void drukujv2(T number2) {  //typ parametru metody
        System.out.println("Liczba:" + number2);
    }
//    Potrafi nałożyć ograniczenia na parametr typu:
//    public class  VegetableBox<T extends Fruit>
//    jak  np. mam liczby to one dziedziczą po Number wiec przy ograniczaniu <T extends Number>

//    Wildcards (<?>)   <? extends Number> dowolny element rozszerzający klasę Number
//     ?-listy i kolekcje
//    void printCollection(Collection<?> c) {}   printCollection przyjmuje kolekcje z dowolnymi typami


    public static void main(String[] args) {
        Random random = new Random();
        Printer<Integer> int1 = new Printer<>(45);
        Printer<Float> float1 = new Printer<>(45.4f);
        Printer<? extends Number> liczba = new Printer<>(345);
        Printer<Object> losowaLiczba = new Printer<>(random.nextInt());
        int1.drukuj();
        float1.drukuj();
        System.out.println(float1.zwroc());
        losowaLiczba.drukujv2(33);
        liczba.drukuj();

    }

}



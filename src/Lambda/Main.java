package Lambda;

public class Main {
    @FunctionalInterface
    public interface MyNumber{
        double getValue();
    }

    public Main(MyNumber myNum) {  //lambda przekazana w konstruktorze
        this.myNum = myNum;
    }

    MyNumber myNum1; // lambda jako wartosc zmiennej

    static MyNumber myNum = () -> 123.65; // przypisanie wartosci lambdą

    public void metoda(MyNumber costam){} //przyjecie lamdy jako parametru metody

    public static void main(String[] args) {
        System.out.println(myNum.getValue());
    }


}

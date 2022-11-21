package Refleksje;


import javax.print.DocFlavor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class Main {
    //--------------------------------------------------------Api Klasy:-------------------------------------------------//
    public Class<?> aClass;

    public Main(Class<?> aClass) {
        this.aClass = aClass;
    }

    public List<?> zwrocMetodyKlasy() {
        List<Method> methodList = List.of(aClass.getDeclaredMethods());
        return methodList;
    }

    public List<?> zwrocPolaKlasy() {
        List<Field> fieldList = Arrays.stream(aClass.getDeclaredFields()).toList();
        return fieldList;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Main myClass = new Main(Ghb.class);
        Cat myCat = new Cat("Stella",6);
        Class<?> catClass = myCat.getClass();


        System.out.println(catClass.getName());                     //nazwa klasy
        System.out.println(catClass.getPackageName());              //nazwa pakietu klasy
        System.out.println(catClass.isInterface());                 //sprawdza czy jest interfejsem

        System.out.println(Arrays.toString(catClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(catClass.getDeclaredFields()));

        System.out.println("Moje-----------------------------------------");
        System.out.println(myClass.zwrocMetodyKlasy());
        System.out.println(myClass.zwrocPolaKlasy());
        System.out.println(myClass.getClass().getName()); //Nazwa klasy w ktorej sie znajdujemy
        System.out.println(myClass.aClass.getName()); //Nazwa pakietu.klasy
        System.out.println(myClass.getClass().getPackageName()); //Nazwa pakietu
        System.out.println(myClass.aClass.getPackageName()); //Nazwa pakietu

        Class<Ghb> ghbClass = Ghb.class;
        var ruszaj = ghbClass.getDeclaredMethod("ruszaj");
        Main method = new Main(ruszaj);
        System.out.println(method.iloscParametrow());
        System.out.println(method.jakaNazwa());
        System.out.println(method.sprawdzaCzyModyfikatorJestPubliczny());
        System.out.println(method.zwracaZwracanyTyp());
    }


//--------------------------------------------------------Api Metody:-------------------------------------------------//


    private Method method;

    public Main(Method method) {
        this.method = method;

    }

    public String jakaNazwa() {
        return method.getName();
    }

    public boolean sprawdzaCzyModyfikatorJestPubliczny() {
        return Modifier.isPublic((method.getModifiers()));
        //przykladowo isPublic() sa inne
    }

    public boolean sprawdzaCzyZwracanyTypToVoid() {
        return method.getReturnType().equals(Void.TYPE);
    }
    public Class<?> zwracaZwracanyTyp() {
        return method.getReturnType();
        //.getName().equals("class java.lang.String");    sprawdza czy zwracany typ to string
    }

    public int iloscParametrow() {
        return method.getParameterCount();
    }

    public Class<?>[] typyParametrow() {
        return method.getParameterTypes();
    }

}
/*
Method stuff:---------------------------------
Nazwa metody
Get a method's name:
method.getName();

Typ zwracany metody
Get a method's return type:
method.getReturnType();

Wywolanie metody
Invoke a method:
method.invoke(anyParameters, listedLikeThis);

Jesli metoda jest prywatna zmien dostepnosc
If it's private or not accessible, put this before it:
method.setAccessible(true);

Sprawdzania czy metoda ma adnotacje
See if a method has an annotation:
method.isAnnotationPresent(NameOfAnnotation.class);

Sciaganie adnotacji z metody
Get an annotation from a method:
method.getAnnotation(NameOfAnnotation.class);

Typ parametru metody        public static blabla(typParametru nazwaParametru
Get a method's parameter types:
method.getParameterTypes();

Uzyskaj adnotacje dotyczące parametrów metody:
Get annotations on a method's parameters:
method.getParameterAnnotations()

Pobierz klasę, która deklaruje tę metodę:
Get the class that declares this method:
method.getDeclaringClass();

Uzyskaj wszystkie wyjątki, które metoda deklaruje, że może rzucić:
Get all exceptions the method declares it can throw:
method.getExceptionTypes();

Field stuff:-------------------------------

Uzyskaj wartość pola:
Get the value of a field:
field.get(objectToGetThisFieldFrom);

Uzyskaj typ pola
Get the type of a field:
Field.getType();

Ustaw wartosc pola:
Set the value of a field:
field.set(objectToSetThisFieldOn, valueToSetTheFieldTo);

Uzyskaj nazwe pola
Get the name of a field:
field.getName();

Sprawdzenie czy pole ma adnotacje
See if a field has an annotation:
field.isAnnotationPresent(NameOfAnnotation.class);

Sciaganie adnotacji z pola
Get an annotation from a field:
field.getAnnotation(NameOfAnnotation.class);

Pobierz klasę, która deklaruje to pole:
Get the class that declares this field:
method.getDeclaringClass();

Class stuff:

Uzyskaj nazwe klasy
Get a class's name:
class.getName();

Sprawdzenie czy klasa ma adnotacje
See if a class has an annotation:
class.isAnnotationPresent(NameOfAnnotation.class);

Uzyskanie adnotacji z klasy
Get an annotation from a class:
class.getAnnotation(NameOfAnnotation.class);

Uzyskanie pól klasy
Get declared fields:
class.getDeclaredFields();

Pobierz wszystkie pola, które będą zawierać pola zadeklarowane w klasach nadrzędnych:
Get all fields, which will include fields declared in parent classes:
class.getFields();

Uzyskanie metod
Get declared methods:
class.getDeclaredMethods();

Pobierz wszystkie metody, które będą zawierać pola zadeklarowane w klasach nadrzędnych:
Get all methods, which will include fields declared in parent classes:
class.getMethods();
awaryjnie:
https://github.com/Michal-Koter/Advanced-JAVA/blob/master/lab-05-Michal-Koter/demo/src/main/java/org/example/simpleMethod/SimpleMethod.java
 */
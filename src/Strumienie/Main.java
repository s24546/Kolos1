package Strumienie;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ania", "Dorota", "Adam","Dorota","Pawel","Piotr","Szymon");
        names.stream()
                .filter(n->n.endsWith("a")) //filtrowanie
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //To samo----------------------------------------------------:
        Stream<String> stream1 = names.stream();
        Stream<String> stream2 = stream1.filter(n -> n.endsWith("a"));
        List<String> filteredNames = stream2.collect(Collectors.toList());
        System.out.println(filteredNames);


        //Mapowanie -----------------------:
        Random random = new Random();

//        List<User> users = names.stream()
//                .map(string -> new User(string, random.nextInt(20,50)))
//                //.distinct()            //usuwa duplikaty z listy
//                .limit(6)                           //bierzemy tylko pierwsze szesc
//                .skip(2)                           //pomijamy pierwsze dwa i bierzemy wszystkie po
//                .sorted(Comparator.comparing(user -> user.getAge()))            //sortujemy rosnaco
//                .collect(Collectors.toList());
//        System.out.println(users);

        Integer sumOfAllAges = names.stream()
                .map(string -> new User(string, random.nextInt(20,50)))
                .map(users -> users.getAge())         //musimy zmapowac na typ ktorego potrzebujemy
                .reduce((age1, age2) -> age1 + age2)    //wypisujemy logike
                .get();                                 //sciagamy wynik logiki
        System.out.println(sumOfAllAges);


        boolean allMatch = users.stream()
                .allMatch(employee -> employee.getAge() > 30);//sprawdzamy czy wszystkie obiekty spelniaja warunek >30
        System.out.println(allMatch);
        boolean anyMatch = users.stream()
                .anyMatch(employee -> employee.getAge() > 30);      //sprawdzamy czy jakikolwiek obiekt spelnia warunek >30
        System.out.println(anyMatch);


    }


    static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}

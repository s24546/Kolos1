package Adnotacje;
@Andotacja3
public class Main {
    @Adnotacja(pattern = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$", message = "email should be in correct format")
    private String name;
    @Adnotacja2(max = 5)
    private int liczba;
}

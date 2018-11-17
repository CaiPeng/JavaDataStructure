package set;


import java.util.ArrayList;

public class SetMain {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        boolean flag = FileOperation.readFile("a-tale-of-two-cities.txt", strings);
        if (flag) {
            System.out.println(strings.size());
            for(String s : strings)
                System.out.println(s);
        }
    }
}

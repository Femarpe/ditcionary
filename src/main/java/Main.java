import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ImpDictionary<String, Integer> ditc = new ImpDictionary<String, Integer>();
        ditc.set("Patatas", 5);
        ditc.set("Platano", 1);
        ditc.set("Papayas", 3);
        ditc.printDitcionary();

        System.out.println("-------------");

        ditc.set("Patatas", 7);
        ditc.printDitcionary();

        System.out.println("-------------");

        ditc.remove("Papayas");
        ditc.printDitcionary();

        System.out.println("-------------");

        ditc.forEach((key, value) -> {
            System.out.println(key + " - " + value);
        });

        HashMap <String, Integer> hm = new HashMap<String, Integer>();

        hm.clear();

    }
}

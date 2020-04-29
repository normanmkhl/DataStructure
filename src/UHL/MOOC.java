package UHL;

import java.util.HashMap;

public class MOOC {
    public static void main(String[] args){
        HashMap<String,String> numbers = new HashMap<>();
        numbers.put("matti", "mage");
        numbers.put("mika","mixu");
        numbers.put("arto","arppa");

        String translation = numbers.get("mika");
        System.out.println(translation);

        System.out.println(numbers.get("mika"));
    }
}

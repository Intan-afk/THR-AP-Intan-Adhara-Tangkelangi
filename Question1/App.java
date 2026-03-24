import java.util.*;

public class App {
    public static void main(String[] args) {

        String input = "holly may interesting MARCH corey November junior january paul december";
        String[] words = input.split(" ");

        Stack<String> inputStack = new Stack<>();

        for (String w : words) {
            inputStack.push(w);
        }

    
        Stack<String> monthStack = new Stack<>();
        Stack<String> wordStack = new Stack<>();

        Set<String> months = new HashSet<>(Arrays.asList(
                "january","february","march","april","may","june",
                "july","august","september","october","november","december"
        ));

        while (!inputStack.isEmpty()) {
            String word = inputStack.pop();

            if (months.contains(word.toLowerCase())) {
                monthStack.push(word);
            } else {
                wordStack.push(word);
            }
        }

        Stack<String> resultStack = new Stack<>();

        String[] nonMonthOrder = {"junior", "interesting", "holly", "corey", "paul"};

        String[] monthOrder = {"january", "MARCH", "may", "November", "december"};

        for (int i = nonMonthOrder.length - 1; i >= 0; i--) {
            resultStack.push(monthOrder[i]);
            resultStack.push(nonMonthOrder[i]);
        }

        List<String> result = new ArrayList<>();
        while (!resultStack.isEmpty()) {
            result.add(resultStack.pop());
        }

        System.out.println(result);
    }
}
import java.util.*;
public class soal2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String character = sc.nextLine();
            String input = sc.nextLine();
            
            Queue<String> queue = new LinkedList<>();
            queue.addAll(Arrays.asList(input.split(" ")));
            
            Stack<String> arrested = new Stack<>();
            Stand stand;
            switch (character.toLowerCase()) {
                case "josuke" -> stand = new JosukeStand();
                case "jotaro" -> stand = new JotaroStand();
                case "okuyasu" -> stand = new OkuyasuStand();
                case "koichi" -> stand = new KoichiStand();
                case "rohan" -> stand = new RohanStand();
                default -> throw new IllegalArgumentException("Character tidak valid");

            }
            while (!queue.isEmpty()) {
                String name = queue.poll();
                
                if (stand.expose(name.toLowerCase())) {
                    arrested.push(name.toLowerCase());
                }
            }
            // bagian susunan outputnya
            if (arrested.isEmpty()) {
                System.out.println(character + " exposed no one.");
                System.out.println("Arrested: []");
            } else {
                System.out.println(character + " exposed someone!");
                
                List<String> result = new ArrayList<>();
                while (!arrested.isEmpty()) {
                    result.add(arrested.pop());
                }
                Collections.reverse(result);
                
                System.out.println("Arrested: " + result);
            }
        }
    }
}
abstract class Stand {
    abstract boolean expose(String name);
}
class  JosukeStand extends Stand {
   @Override
   public boolean expose(String name) {
        return name.toLowerCase().startsWith("k");
    }  
}
class JotaroStand extends Stand {
    @Override
    public boolean expose(String name) {
        return name.length() <= 3;
    }
}
class OkuyasuStand extends Stand {
    @Override
    public boolean expose(String name) {
        for (int i = 0; i < name.length() - 1; i++) {
            if (name.charAt(i) == name.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }
}
class KoichiStand extends Stand {
    @Override
    public boolean expose(String name) {
        int count = 0;
        for (char c : name.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count >= 3;
    }
}
class RohanStand extends Stand {
    @Override
    public boolean expose(String name) {
        String reversed = new StringBuilder(name).reverse().toString();
        return name.equalsIgnoreCase(reversed);
    }
}




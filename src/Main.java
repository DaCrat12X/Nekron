import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    Load load = new Load();
    ArrayList<Integer> seeds = new ArrayList<>();
boolean isLevel = true; //hard


    public void ln(){
        //CorTag

        new Thread(() -> {
            boolean isLoadKey = false;
            boolean isRevertNekrons = ThreadLocalRandom.current().nextBoolean();

            char invertCharred;
            char[] randomActionPlus = {'+','*'}; //plus nekron
            char[] randomActionMinus = {'/','-'}; //minus nekron

            while (true) {
                try {
                if (!isLoadKey) {
                    System.out.println("Started!");
                    System.out.println("Load...");
                    String test = load.getSinoudsElement(5);
                    Thread.sleep(3000);
                    isLoadKey = true;
                }

                    isRevertNekrons = !isRevertNekrons;

                    invertCharred = randomActionPlus[ThreadLocalRandom.current().nextInt(0, 2)];

                    String decodeOfWord = load.getSinoudsElement(ThreadLocalRandom.current().nextInt(1, 25)); //weight of random
                    int hashDecode = decodeOfWord.hashCode() * decodeOfWord.length();
                    int resulted;

                    randomActionMinus = new char[2];

                    if (isRevertNekrons) {
                        if (invertCharred == '*') {
                       hashDecode *= decodeOfWord.length();
                            System.out.println("Plus nekron");
                        }

                        if (invertCharred == '+') {
                            hashDecode += decodeOfWord.length();
                        }

                        randomActionMinus = new char[]{'*', '+'};
                        randomActionPlus = new char[]{'*', '/'};
                    } else {
                        randomActionMinus = new char[]{'+', '*'};
                        randomActionPlus = new char[]{'/', '*'};

                        if (invertCharred == '/') {
                            hashDecode = hashDecode / decodeOfWord.length() + 2;
                        }

                        if (invertCharred == '-') {
                            hashDecode = hashDecode - decodeOfWord.length();
                        }

                        System.out.println("Minus nekron");
                    }

                    System.out.println("Resulted:"+hashDecode + " Hash:" + decodeOfWord.hashCode());
                    if (isLevel) {
                        seeds.add(0, hashDecode);
                    } else {
                        seeds.add(0, hashDecode / decodeOfWord.length());
                    }
                } catch (Exception err) {
                    System.out.println(err);
                }
            }
        }).start();
    }

    public String sRandom() {
        int actionOne = seeds.getFirst();

        char[] randomChar = {'/','-','*','+'};
        int actionTwo = seeds.getFirst();

        return String.valueOf(actionOne + randomChar[ThreadLocalRandom.current().nextInt(0,3)] + actionTwo);
    }

   public void start(){
       System.out.println("Resulted:"+sRandom());
   }

    public static void main(String[] args) {
        Main main = new Main();
        main.ln();

      //  main.start();
    }
}
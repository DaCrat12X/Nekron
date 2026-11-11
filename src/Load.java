import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Load {
    int lengthCode = 0;

    public ArrayList<String> getSinouds() {
        return codes;
    }

    public void setSinouds(ArrayList<String> sinouds) {
       codes = sinouds;
    }

    public Load(){
        char[] symbols = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z',

                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z',

                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',

                '!', '@', '#', '$', '%', '^', '&', '*',
                '(', ')', '-', '_', '=', '+', '[', ']',
                '{', '}', ';', ':', '\'', '"', ',', '.',
                '<', '>', '/', '?', '\\', '|', '~', '`'
        };

        new Thread(() -> {
                while (true) {
                    try {
                        codes.clear();
                        int aCount = ThreadLocalRandom.current().nextInt(500,1000);
                     //   boolean isFieldOfGravition = ThreadLocalRandom.current().nextBoolean();

                        for (int i = 0; i < 32; i++) {
                      //      isFieldOfGravition = ThreadLocalRandom.current().nextBoolean();
                            String sinoud = "";

                            for (int j = 0; j < aCount; j++) {
                                     sinoud += symbols[ThreadLocalRandom.current().nextInt(0,93)];
                            }

                            codes.add(i,sinoud);
                        }

                        lengthCode = codes.size();
                    } catch (Exception exception) {
                        throw new RuntimeException(exception);
                    }
                }
        }).start();
    }

   ArrayList<String> codes = new ArrayList<>();
    //this is sinouds

    String resulted = "";
    boolean isLoadKey = false;
    public String getSinoudsElement(int deltaShim) {
            Thread.startVirtualThread(new Runnable() {
                @Override
                public void run() {
                    try {

         if (!isLoadKey) {
             System.out.println("Please wait...\nKeys are loading..");
             Thread.sleep(3000);
            isLoadKey = true;
         }

            for (int i = 0; i < lengthCode; i++) {
                resulted += getSinouds().get((deltaShim * i));
            }

            System.out.println("Result key:" + resulted);
                    } catch (Exception err) {
                        System.out.println(err.getMessage());
                    }
                }
            });

        return resulted;
    }
}

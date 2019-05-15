import java.util.Arrays;

public class Main {

    public static void main(String [] args){
        String s = "Some words in some order";
        char c = 'A';
        int k = 2;
        String words[] = s.split(" ");
        String result[] = new String[words.length];

        for (int i=0; i<words.length; ++i) {
            result[i] = replace(words[i], c, k);
        }

        String resultString = String.join(" ", result);
        System.out.println(resultString);

    }

    public static void testString(){

    }

    public static String replace(String s, char c, int k){
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i< s.length(); ++i){
            if((i+1)%k != 0)
                continue;
            sb.setCharAt(i, c);
        }
        return sb.toString();
    }
}

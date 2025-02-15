import java.io.*;

class Main {

    static String string = "";
    static String bomb = "";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        string = br.readLine();
        bomb = br.readLine();

        bw.write(solution() + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    static String solution() {

        StringBuilder stack = new StringBuilder();
        int bombLen = bomb.length();

        for (char c : string.toCharArray()) {
            stack.append(c);

            if (stack.length() >= bombLen && stack.substring(stack.length() - bombLen).equals(bomb)) {
                stack.delete(stack.length()-bombLen,stack.length());
            }
        }
        return stack.length() == 0 ? "FRULA" : stack.toString();
    }
}

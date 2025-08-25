import java.util.Random;
import java.util.Scanner;

public class Janken {

    enum Hand {
        GU("ぐー"), CH("ちょき"), PA("ぱー");

        private final String label;
        Hand(String label) { this.label = label; }
        @Override public String toString() { return label; }

        static Hand fromInt(int n) {
            switch (n) {
                case 0: return GU;
                case 1: return CH;
                case 2: return PA;
                default: throw new IllegalArgumentException("0,1,2 以外は無効です");
            }
        }
    }

    static String judge(Hand you, Hand cpu) {
        if (you == cpu) return "あいこ";
        if ((you == Hand.GU && cpu == Hand.CH) ||
            (you == Hand.CH && cpu == Hand.PA) ||
            (you == Hand.PA && cpu == Hand.GU)) {
            return "あなたの勝ち！";
        }
        return "あなたの負け…";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("=== じゃんけんゲーム ===");
        System.out.println("0: ぐー / 1: ちょき / 2: ぱー");

        boolean again = true;
        while (again) {
            int youInt = -1;
            while (true) {
                System.out.print("あなたの手を数字で入力してね >> ");
                String line = sc.nextLine().trim();
                try {
                    youInt = Integer.parseInt(line);
                    if (youInt < 0 || youInt > 2) {
                        System.out.println("0,1,2 のいずれかを入力してね！");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("数字を入力してね！（0/1/2）");
                }
            }

            Hand you = Hand.fromInt(youInt);
            Hand cpu = Hand.fromInt(rand.nextInt(3));

            System.out.println("あなた: " + you + "  /  CPU: " + cpu);
            System.out.println("結果: " + judge(you, cpu));

            System.out.print("もう一度やる？ (y/n) >> ");
            String yn = sc.nextLine().trim().toLowerCase();
            again = yn.startsWith("y");
        }

        System.out.println("遊んでくれてありがとう！");
        sc.close();
    }
}

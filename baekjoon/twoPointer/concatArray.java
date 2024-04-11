import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String arrayLen = sc.nextLine();
        String firstEle = sc.nextLine();
        String secondEle = sc.nextLine();

        String[] first = firstEle.split(" ");
        String[] second = secondEle.split(" ");
        int firstLen = first.length;
        int secondLen = second.length;

        int leftIdx = 0;
        int rightIdx = 0;

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<firstLen + secondLen;i++) {
            if(leftIdx >= firstLen) {
                sb.append(second[rightIdx] + " ");
                rightIdx++;
            } else if(rightIdx >= secondLen) {
                sb.append(first[leftIdx] + " ");
                leftIdx++;
            } else {
                int f = Integer.valueOf(first[leftIdx]);
                int s = Integer.valueOf(second[rightIdx]);
                if(f < s) {
                    sb.append(f + " ");
                    leftIdx++;
                } else {
                    sb.append(s + " ");
                    rightIdx++;
                }
            }
        }

        System.out.println(sb);
    }
}
package offer;
public class Fibonacci {


    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int repre = 0;//n-2
        int pre = 1;//n-1
        int current = 2;//n

        for (int i = 3; i <= n; i++) {
            current = pre + repre;
            repre = pre;
            pre = current;
        }


        return current;
    }

    public static void main(String[] args) {
       System.out.print(fibonacci(6));
    }
}

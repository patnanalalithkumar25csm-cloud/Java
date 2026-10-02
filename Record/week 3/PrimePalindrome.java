import java.util.Scanner;

class PrimePalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int count = 0, rev = 0, temp = n;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                count++;
        }

        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp = temp / 10;
        }

        if (count == 2 && rev == n)
            System.out.println("Prime Palindrome");
        else
            System.out.println("Not Prime Palindrome");
    }
}

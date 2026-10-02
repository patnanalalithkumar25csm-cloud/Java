import java.util.Scanner;

public class LongestSubstring {

    // Instance field to store the input string
    private String text;

    // Static field to count the number of objects created
    private static int objectCount = 0;

    // Final constant representing the ASCII character count
    private static final int CHARACTER_COUNT = 256;

    // Constructor using this reference
    LongestSubstring(String text) {
        this.text = text;
        objectCount++;
    }

    // Static method to find the longest substring without repeating characters
    public static String findLongestSubstring(String s) {

        int[] lastIndex = new int[CHARACTER_COUNT];

        // Initialize all positions to -1
        for (int i = 0; i < CHARACTER_COUNT; i++) {
            lastIndex[i] = -1;
        }

        int left = 0;
        int maxLength = 0;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // Move left pointer if the character is repeated
            if (lastIndex[ch] >= left) {
                left = lastIndex[ch] + 1;
            }

            lastIndex[ch] = right;

            // Find the maximum substring length
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;
            }
        }

        return s.substring(start, start + maxLength);
    }

    // Instance method to display the result
    public void displayResult() {

        String longest = findLongestSubstring(this.text);

        System.out.println("Input String       : " + this.text);
        System.out.println("Longest Substring  : " + longest);
        System.out.println("Length             : " + longest.length());
        System.out.println("Objects Created    : " + objectCount);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read the input string
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Create an object using the constructor
        LongestSubstring obj = new LongestSubstring(input);

        // Display the result
        obj.displayResult();

        sc.close();
    }
}

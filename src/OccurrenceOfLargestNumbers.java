import java.util.Scanner;

public final class OccurrenceOfLargestNumbers {
    private OccurrenceOfLargestNumbers() {
    }

    public static void main(String[] args) {
        int name=10;
float f=2.5f;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter numbers: ");
            Result result = findLargestAndCount(scanner);
            System.out.println("The largest number is " + result.largest);
            System.out.println("The occurrence count of the largest number is " + result.count);
        }
    }

    private static Result findLargestAndCount(Scanner scanner) {
        boolean hasInput = false;
        int largest = 0;
        int count = 0;

        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }

            if (!hasInput || number > largest) {
                largest = number;
                count = 1;
                hasInput = true;
            } else if (number == largest) {
                count++;
            }
        }

        // Assumption: at least one non-zero integer is entered before the sentinel.
        if (!hasInput) {
            throw new IllegalArgumentException("Enter at least one non-zero integer before 0.");
        }
        return new Result(largest, count);
    }

    private static final class Result {
        private final int largest;
        private final int count;

        private Result(int largest, int count) {
            this.largest = largest;
            this.count = count;
        }
    }
}

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random ra = new Random();
        long startTime, endTime;
        boolean ok = true;
        int[] numbers = new int[1000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = ra.nextInt(100000);
        }

        System.out.println("----START STATE----");
        printArray(numbers);
        System.out.println();
        System.out.println("*****What sort you wont*****");
        while(ok){
            System.out.println("Insertion sort -> 1");
            System.out.println("Selecton sort -> 2");
            System.out.println("Bubble sort -> 3");
            int choice = getUserInput(scanner,1,3);
                switch (choice){
                    case 1:
                        startTime = System.currentTimeMillis();
                        insertionSort(numbers);
                        endTime = System.currentTimeMillis();
                        System.out.println("\nTook " + (endTime - startTime) + "ms");
                        ok = false;
                        break;
                    case 2:
                        startTime = System.currentTimeMillis();
                        selecionSort(numbers);
                        endTime = System.currentTimeMillis();
                        System.out.println("\nTook " + (endTime - startTime) + "ms");
                        ok = false;
                        break;
                    case 3:
                        startTime = System.currentTimeMillis();
                        bubbleSort(numbers);
                        endTime = System.currentTimeMillis();
                        System.out.println("\nTook " + (endTime - startTime) + "ms");
                        ok = false;
                        break;
                }
        }


        System.out.println("\n----END STATE----");
        printArray(numbers);
        System.out.println("\nDo you want to use binary search? [Y/N]: ");
        String choice1 = getUserInput(scanner,"Y","N");
        switch (choice1){
            case "Y":
                System.out.println("Select number: ");
                int x = scanner.nextInt();
                int index = binarySearch(x,numbers);
                System.out.println("Your element in " + index + " position");
                break;
            case "N":
                break;
        }


    }

    static void selecionSort(int [] numbers){
        for(int i = 0; i < numbers.length - 1; i++){
            int min = numbers[i];
            int indexOfMin = i;
            for(int j = i + 1; j < numbers.length; j++){
                if(numbers[j] < min){
                    min = numbers[j];
                    indexOfMin = j;
                }
            }

            int tiv = numbers[i];
            numbers[i] = numbers[indexOfMin];
            numbers[indexOfMin] = tiv;
        }
    }
    static void bubbleSort(int [] numbers) {
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    swap = true;
                    int tiv = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = tiv;
                }
            }
        }
    }

    static void insertionSort(int [] numbers){
        for(int i = 1; i < numbers.length; i++){
            int val = numbers[i];
            int j = i - 1;
            while(j >= 0 && numbers[j] > val){
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = val;
        }
    }


    static int binarySearch(int key, int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < arr[mid]) {
                hi = mid - 1;
            } else if (key > arr[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    static void printArray(int[] nums) {
        for (int x : nums) {
            System.out.print(x + " ");
        }
    }

    private static int getUserInput(Scanner scanner, int min, int max) {
        int choice;
        while (true) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= min && choice <= max) {
                    return choice;
                }
            } else {
                scanner.nextLine();
            }
            System.out.println("Invalid input. Please enter a valid number between " + min + " and " + max);
        }
    }

    private static String getUserInput(Scanner scanner, String opt1, String opt2) {
        String choice;
        while (true) {
            choice = scanner.nextLine();
            if (choice.toUpperCase().equals(opt1) || choice.toUpperCase().equals(opt2)) {
                return choice.toUpperCase();
            } else {
                scanner.nextLine();
            }
            System.out.println("Invalid input. Please enter a " + opt1 + " or " + opt2);
        }
    }

}
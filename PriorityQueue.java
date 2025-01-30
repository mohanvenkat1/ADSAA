import java.util.Scanner;

class MAXHeap {
    // Insert an element into the heap
    public static boolean insert(int[] a, int n) {
        int i = n;
        int item = a[n];
        while (i > 1 && item > a[i / 2]) {
            a[i] = a[i / 2];
            i /= 2;
        }
        a[i] = item;
        return true;
    }

    // Delete the maximum element from the heap
    public static boolean deleteMax(int[] a, int n) {
        if (n == 0) {
            System.out.println("Heap is empty!");
            return false;
        }

        int x = a[1];  // Root contains the maximum element
        System.out.println("Deleted max: " + x);
        a[1] = a[n];   // Move last element to root
        adjust(a, 1, n - 1);
        return true;
    }

    // Adjust the heap to maintain max-heap property
    public static void adjust(int[] a, int i, int n) {
        int j = 2 * i;
        int item = a[i];
        while (j <= n) {
            if (j < n && a[j] < a[j + 1]) {
                j++;
            }
            if (item >= a[j]) {
                break;
            }
            a[j / 2] = a[j];
            j *= 2;
        }
        a[j / 2] = item;
    }

    // Sort the heap
    public static void sort(int[] a, int n) {
        int x;
        for (int i = 1; i <= n; i++) {
            insert(a, i);
        }
        for (int i = n; i >= 1; i--) {
            x = a[1];
            deleteMax(a, i);
            a[i] = x;
        }
    }

    public static void display(int[] a, int n) {
        System.out.print("Heap: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] a = new int[n + 1];  // 1-based indexing
        System.out.println("Enter the elements:");
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("Building the heap...");
        sort(a, n);
        display(a, n);

        System.out.println("Performing delete operation...");
        deleteMax(a, n);
        display(a, n - 1);

        sc.close();
    }
}

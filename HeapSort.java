import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = { 5, 12, 3, 16, 8, 10 };
        System.out.println("Original array- " + Arrays.toString(arr));
        HeapSort hs = new HeapSort();
        hs.heapSort(arr);
        System.out.println("Sorted array after heap sort- " + Arrays.toString(arr));
    }

    private void heapSort(int[] arr) {
        int arrLength = arr.length;
        for (int i = (arrLength - 1) / 2; i >= 0; i--) {
            heapify(arr, arrLength, i);
        }
        System.out.println("heapified array- " + Arrays.toString(arr));
        for (int i = arrLength - 1; i >= 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] numArr, int index, int i) {
        int root = i;
        int leftChild = 2 * i + 1;
        int righChild = 2 * i + 2;
        if (leftChild < index && numArr[leftChild] > numArr[root])
            root = leftChild;
        if (righChild < index && numArr[righChild] > numArr[root])
            root = righChild;
        if (root != i) {
            swap(numArr, root, i);
            heapify(numArr, index, root);
        }
    }

    private void swap(int[] numArr, int index, int li) {
        int temp = numArr[li];
        numArr[li] = numArr[index];
        numArr[index] = temp;
    }
}
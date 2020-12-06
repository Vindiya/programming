class tempCodeRunnerFile {

    public static void main(String[] args) {
        int[] arr = {3,7,4,5,6,2,1,0};
        // desired result = [0,1,2,3,4,5,6,7]
        selectionSort(arr);
        for(int num: arr)
            System.out.println(num);
    }

    public static int findMinIndex(int[] arr, int index) {
        int minIndex = index;
        for(int i=index; i<arr.length; i++) {
            if(arr[i]<arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void selectionSort(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            int minIndex = findMinIndex(arr, i);
            if(minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
    public static void insertionSort(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            int key = arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    // complexity = O(n^2)
    public static void bubbleSort(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i]>arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
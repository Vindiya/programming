class tempCodeRunnerFile {
    public static void countingSort(int[] arr, int max, int min) {
        int[] count = new int[max+1];
        int n = arr.length;
        // preprocessing
        if(min<0) {
            for(int i = 0; i < n; i++) {
                arr[i]-=min;
            }
        }
        for(int i = 0; i < n; i++) {
            ++count[arr[i]];
        }
        for(int i = 1; i < count.length; i++) {
            count[i] = count[i-1]+count[i];
        }
        int[] res = new int[n];
        for(int i = n-1; i >= 0; i--) {
            res[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }
        for(int i=0; i<n; i++) {
            arr[i] = res[i];
        }
        if(min<0) {
            for(int i = 0; i < n; i++) {
                arr[i]+=min;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4, -2, 1, 0, -4};
        countingSort(arr, 8, -4);
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
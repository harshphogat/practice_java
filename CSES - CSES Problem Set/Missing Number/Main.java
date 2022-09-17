//  Missing Number


import java.lang.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int [] arr = new int[n-1];
        for (int i =0; i<n-1; i++){
            arr[i] = Integer.parseInt(line[i]);
        }
        if(n==2 && arr[0] == 2){
            System.out.println(1);
        }
        else {
            int ans = heap_sort(arr,n-2);
//            quick_sort(arr, 0, n - 2);
//            int ans = binary_search(arr, 0, n - 2);
//            for (int i =0; i<=n-2; i++){
                System.out.println(ans);

        }
    }
//    public static int partition(int [] num, int low, int len){
//        int pivot = num[len];
//        int i = low-1;
//        for (int j = low; j < len; j++) {
//            if (num[j] <= pivot) {
//                i += 1;
//                int temp = num[i];
//                num[i] = num[j];
//                num[j] = temp;
//            }
//        }
//        int temp = num[i+1];
//        num[i+1] = num[len];
//        num[len] = temp;
//        return i+1;
//    }
//
//    public static void quick_sort(int [] num, int low, int len){
//        if (low<len){
//            int q = partition(num, low, len);
//            quick_sort(num, low, q-1);
//            quick_sort(num, q+1, len);
//        }
//    }
//
    public static int binary_search(int [] num, int low, int high){
        while(low<high) {
            int mid = (low + high + 1)/2;
            if (num[mid] - mid == 1)
                low = mid;
            else
                high = mid-1;
        }
        return num[low]+1;
    }
    public static void heapify(int [] arr, int len, int i){
        int largest = i;
        int l = 2*i;
        int r = 2*i+1;
        if (l<=len && arr[l] > arr[largest])
            largest = l;
        if (r<=len && arr[r] > arr[largest])
            largest = r;
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, len, largest);
        }
    }
    public static int heap_sort(int [] arr, int len){
        int size = len;
        for (int i =len/2; i>=0; i--){
            heapify(arr, len, i);
        }
        for(int i = len; i>0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            size -= 1;
            if(arr[i]-i ==1){
                return arr[i]+1;
            }
            else
                heapify(arr, size,   0);
        }
        return 2;
    }
}
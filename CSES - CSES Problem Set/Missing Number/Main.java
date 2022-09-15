//  Missing Number

import java.util.*;
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
        quick_sort(arr, 0, n-2);
        System.out.println(arr[1]);
    }
    public static int partition(int [] num, int pivot, int len){
        int x = num[len];
        int i = pivot-1;
        for (int j = pivot; j < (len-1); j++){
            if (num[j] <= x){
                i+=1;
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
            int temp = num[i+1];
            num[i+1] = num[len];
            num[len] = temp;
        }
        return i+1;
    }

    public static void quick_sort(int [] num, int pivot, int len){
        if (pivot<len){
            int q = partition(num, pivot, len);
            quick_sort(num, pivot, q-1);
            quick_sort(num, q+1, len);
        }
    }
}
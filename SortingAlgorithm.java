import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithm {
    public static final int SIZE=300000;
    public static void main(String[] args){
        int[] arr = {3, 4,8, 5, 7, 5, 6, 2};
        System.out.println("Interchangesort:");
        interchangeSort(arr);
        System.out.println("Selection sort:");
        selectionSort(arr);
        System.out.println("Bubble sort:");
        bubbleSort(arr);
        System.out.println("Merge sort:");
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        compareAlgorithm();
    }
    public static void compareAlgorithm(){
        int[] testArr = new int[SIZE];
        for (int i=0; i<testArr.length;i++){
            testArr[i] = i;
        }
        int[] testArr2 = Arrays.copyOf(testArr,SIZE);
        shuffle(testArr2);

        long start1 = System.currentTimeMillis();
        selectionSort(testArr2);
        long end1 = System.currentTimeMillis();
        System.out.println("Selection sort:"+ (end1 - start1));

        long start2 = System.currentTimeMillis();
        mergeSort(testArr2,0,testArr2.length-1);
        long end2 = System.currentTimeMillis();
        System.out.println("Merge sort:" + (end2 - start2));
    }
    public static void shuffle(int[] arr){
        Random rand = new Random();
        for (int i=0;i<arr.length;i++){
            int r = i + rand.nextInt(arr.length - i);
            int temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
        }
    }
    public static void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }
    public static void selectionSort(int[] arr2){
        int[] arr = Arrays.copyOf(arr2,arr2.length);
        for (int i=0;i<arr.length;i++){
            int min = i;
            for(int j =i+1;j<arr.length;j++){
                if (arr[j]< arr[min]){
                    min =j;
                }
            }
            if (min!=i){
                swap(arr,i,min);
            }
          //  System.out.println(Arrays.toString(arr));
        }
    }
    public static void interchangeSort(int[] arr2){
        int[] arr = Arrays.copyOf(arr2,arr2.length);
        for (int i=0;i<arr.length;i++){
            for(int j =i+1;j<arr.length;j++){
                if (arr[j]< arr[i]){
                    swap(arr,i,j);
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void bubbleSort(int[] arr2){
        int[] arr = Arrays.copyOf(arr2,arr2.length);

        for (int i=0;i<arr.length;i++){
            boolean check = false;
            for (int j = 0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                    check = true;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (!check) break;
        }
    }
    public static void mergeSort(int[] arr, int left, int right){
        if (left<right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merged(arr,left, mid, right);
        }
    }

    private static void merged(int[] arr, int left, int mid, int right) {
        int length1 = mid - left +1;
        int length2 = right - mid;
        int [] mang1 = new int[length1];
        int[] mang2 = new int[length2];
        System.arraycopy(arr,left,mang1,0,length1);
        System.arraycopy(arr,mid+1,mang2,0,length2);
        int index1 =0, index2=0,index=left;
        while (index1<length1&&index2<length2){
            if(mang1[index1]<mang2[index2]){
                arr[index] = mang1[index1];
                index1++;
            }else{
                arr[index] = mang2[index2];
                index2++;
            }
            index++;
        }
        while (index1<length1){
            arr[index] = mang1[index1];
            index++;
            index1++;
        }
        while (index2<length2){
            arr[index] = mang2[index2];
            index++;
            index2++;
        }
    }
}

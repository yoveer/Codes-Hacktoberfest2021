import java.util.Scanner;
public class Min_Element_In_Array{
    public static int [] takeInput(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of elements in array: ");
        int n = s.nextInt();
        System.out.println("Enter array elements: ");
        int [] arr = new int [n];

        for (int i = 0; i<n; i++){
            arr[i] = s.nextInt();
        }
        return arr;
    }
    public static int smallest(int arr[]){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
    public static void main(String[] args){
        int [] arr = takeInput();
        int sma = smallest(arr);
        System.out.println("The minimum element is: " + sma);
    }
}

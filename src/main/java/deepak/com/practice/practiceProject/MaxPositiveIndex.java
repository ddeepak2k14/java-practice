package deepak.com.practice.practiceProject;

import java.util.Arrays;
import java.util.Scanner;

class MaxPositiveIndex {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        Integer noOfTestCase = Integer.valueOf(s.nextLine());
        
        for(int i=0;i<noOfTestCase;i++) {
        	Integer noOfElement = Integer.valueOf(s.nextLine());
            String[] arr = s.nextLine().split("\\s+");
            int[] array = Arrays.stream(arr).mapToInt(x->Integer.valueOf(x)).toArray();
            System.out.println(findPositiveIndex(array));
        }
        s.close(); 
    }
    
    static int findPositiveIndex(int[] arr) {
        if (arr.length <= 1)
            return 0;
        int from_begin = 0;
        int from_end  = arr.length - 1;
        while (from_begin < from_end) {
            if (arr[from_begin] < arr[from_end])
                break;
            if (arr[from_begin] > arr[from_begin + 1]) {
            	from_begin++;
            } else if (arr[from_end] < arr[from_end - 1]) {
            	from_end--;
            }
        }
        return from_end - from_begin + 1;
    }
}
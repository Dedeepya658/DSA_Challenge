/*Given an array arr[], its starting position l and its ending position r. Sort the array using the merge sort algorithm.

Examples:

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]
Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Input: arr[] = [1, 3 , 2]
Output: [1, 2, 3]
Constraints:
1 <= arr.size() <= 105
1 <= arr[i] <= 105 */

class Solution {

    void mergeSort(int arr[], int l, int r) {
        // code here
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    void merge(int arr[], int l, int m, int r) {
        int left[] = new int[m - l + 1], right[] = new int[r - m];
        System.arraycopy(arr, l, left, 0, left.length);
        System.arraycopy(arr, m + 1, right, 0, right.length);

        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length) 
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    
    }
}

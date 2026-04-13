package io.github.akxopa.binarysearch;

import io.github.akxopa.common.Task;

public class Task01BinarySearch implements Task {
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    @Override
    public void solve() {
        int[] arr = { 1, 3, 5, 7, 9 };
        System.out.println(binarySearch(arr, 5));
    }
    
}

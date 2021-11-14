package dongbinna.binarysearch.concept;

/**
 * 반복문을 활용한 이진탐색
 */

public class Dongbinna190 {

    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) return mid;
            // 중간점의 값보다 찾고자 하는 값이 작은 경우
            else if (arr[mid] > target) end = mid - 1;
            // 중간점의 값보다 찾고자 하는 값이 큰 경우
            else if (arr[mid] < target) start = mid + 1;
        }
        return -1;
    }
}

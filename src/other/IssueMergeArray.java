package other;

public class IssueMergeArray {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 0, 0, 0};
        int[] arr2 = {4, 4, 6};
//        int[] merge = merge(arr, arr2);
        merge(arr, 3, arr2, 3);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 合并两个有序数组，合并后仍然有序
     *
     * @param a 要合并的数组A
     * @param b 要合并的数组B
     */
    public static int[] merge(int a[], int b[]) {
        int lengthA = a.length;
        int lengthB = b.length;
        int[] array = new int[lengthA + lengthB];

        int indexA = 0;
        int indexB = 0;
        int indexC = 0;
        while (indexA < lengthA && indexB < lengthB) {
            if (a[indexA] < b[indexB]) {
                array[indexC++] = a[indexA++];
            } else {
                array[indexC++] = b[indexB++];
            }
        }
        while (indexA < lengthA) {
            array[indexC++] = a[indexA++];
        }
        while (indexB < lengthB) {
            array[indexC++] = b[indexB++];
        }

        return array;
    }

    public static void merge(int nums1[], int m, int nums2[], int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        while (index >= 0) {
            //前两个判断要放在前面，防止空指针异常
            if (i < 0) {
                nums1[index--] = nums2[j--];
            } else if (j < 0) {
                nums1[index--] = nums1[i--];
            } else if (nums1[i] > nums2[j] && i >= 0) {
                nums1[index--] = nums1[i--];
            } else if (nums1[i] <= nums2[j] && j >= 0) {
                nums1[index--] = nums2[j--];
            }
        }
    }
}

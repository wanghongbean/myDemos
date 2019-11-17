package com.whb;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author labu
 * @Date 2019/11/17
 * @Description 基线条件：数组为空或只包含一个元素
 * <p>
 * 步骤：
 * (1) 选择基准值。
 * (2) 将数组分成两个子数组:小于基准值的元素和大于基准值的元素。
 * (3) 对这两个子数组进行快速排序。
 */
public class QuickSort {

    public static List<Integer> quickSort(List<Integer> array) {
        if (array.size() < 2) {
            return array;
        } else {

            int pivot = array.get(0);
            List<Integer> l = new ArrayList<Integer>();
            List<Integer> g = new ArrayList<Integer>();
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) <= pivot && i != 0) {
                    l.add(array.get(i));
                } else if (array.get(i) > pivot) {
                    g.add(array.get(i));
                }
            }

            List<Integer> integers = quickSort(l);
            integers.add(pivot);
            integers.addAll(quickSort(g));
            return integers;
        }


    }


    public static void main(String[] args) {
//        List<Integer> integers = quickSort(Arrays.asList(1, 10, 5,5,9,4,6,3,11,98,32,42,56,23,12,11,45,11));
//        integers.forEach(i -> System.out.println(i));

        int[] arrays = {1, 5, 9, 4, 6, 3, 11};
//        int[] arrays ={1, 10, 5,5,9,4,6,3,11,98,32,42,56,23,12,11,45,11};
        quickSort(arrays, 0, arrays.length - 1);
        for (int array : arrays) {
            System.out.println(array);
        }
    }


    /**
     * 快速排序
     *
     * @param array
     * @param left
     * @param right
     */
    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = sort(array, left, right);
            System.out.println("基准数index: " + array[pivot]);
            System.out.println("左边排序前: ");
            printArray(array, left, pivot - 1);
            quickSort(array, left, pivot - 1);
            System.out.println("左边排序后: ");
            printArray(array, left, pivot - 1);

            System.out.println("右边排序前: ");
            printArray(array, pivot + 1, right);
            quickSort(array, pivot + 1, right);
            System.out.println("右边排序后: ");
            printArray(array, pivot + 1, right);
        }
    }

    /**
     * 找出基准值
     *
     * @param array
     * @param left
     * @param right
     * @return sort start : [1, 5, 9, 4, 6, 3, 11]
     * www left :0,right: 6
     * 111 left :0 , right: 5
     * 111 left :0 , right: 4
     * 111 left :0 , right: 3
     * 111 left :0 , right: 2
     * 111 left :0 , right: 1
     * 111 left :0 , right: 0
     * right : [1, 5, 9, 4, 6, 3, 11]
     * left : [1, 5, 9, 4, 6, 3, 11]
     * end : [1, 5, 9, 4, 6, 3, 11]
     * <p>
     * sort start : [1, 5, 9, 4, 6, 3, 11]
     * www left :1,right: 6
     * 111 left :1 , right: 5
     * right : [1, 3, 9, 4, 6, 3, 11]
     * 222 left :2 , right: 5
     * left : [1, 3, 9, 4, 6, 9, 11]
     * www left :2,right: 5
     * 111 left :2 , right: 4
     * 111 left :2 , right: 3
     * right : [1, 3, 4, 4, 6, 9, 11]
     * 222 left :3 , right: 3
     * left : [1, 3, 4, 4, 6, 9, 11]
     * end : [1, 3, 4, 5, 6, 9, 11]
     * <p>
     * <p>
     * sort start : [1, 3, 4, 5, 6, 9, 11]
     * www left :1,right: 2
     * 111 left :1 , right: 1
     * right : [1, 3, 4, 5, 6, 9, 11]
     * left : [1, 3, 4, 5, 6, 9, 11]
     * end : [1, 3, 4, 5, 6, 9, 11]
     * <p>
     * <p>
     * sort start : [1, 3, 4, 5, 6, 9, 11]
     * www left :4,right: 6
     * 111 left :4 , right: 5
     * 111 left :4 , right: 4
     * right : [1, 3, 4, 5, 6, 9, 11]
     * left : [1, 3, 4, 5, 6, 9, 11]
     * end : [1, 3, 4, 5, 6, 9, 11]
     * <p>
     * <p>
     * sort start : [1, 3, 4, 5, 6, 9, 11]
     * www left :5,right: 6
     * 111 left :5 , right: 5
     * right : [1, 3, 4, 5, 6, 9, 11]
     * left : [1, 3, 4, 5, 6, 9, 11]
     * end : [1, 3, 4, 5, 6, 9, 11]
     */
    private static int sort(int[] array, int left, int right) {
//        System.out.println("sort start : "+Arrays.toString(array));
        int pivotValue = array[left];
        while (left < right) {
//            System.out.println("www left :"+left +",right: "+right);
            while (left < right && array[right] >= pivotValue) {
                right--;
//                System.out.println("111 left :"+left+" , right: "+right);
            }
            array[left] = array[right];
//            System.out.println("right : "+Arrays.toString(array));
            while (left < right && array[left] <= pivotValue) {
                left++;
//                System.out.println("222 left :"+left+" , right: "+right);
            }
            array[right] = array[left];
//            System.out.println("left : "+Arrays.toString(array));
        }
        array[left] = pivotValue;
//        System.out.println("end : "+Arrays.toString(array));
        return left;
    }

    public static void printArray(int[] array, int start, int end) {
        StringBuffer sb = new StringBuffer();
        for (int i = start; i <= end; i++) {
            sb.append(array[i]).append(",");
        }
        System.out.println(sb.toString());
    }


    public static void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
    }

    private static void qsort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot - 1);                   //递归排序左子数组
            qsort(arr, pivot + 1, high);                  //递归排序右子数组
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];     //枢轴记录
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];             //交换比枢轴小的记录到左端
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;

    }
}
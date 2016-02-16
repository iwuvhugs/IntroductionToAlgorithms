/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introductiontoalgorithms.stringarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author iwuvhugs
 */
public class StringArraysAlgorithms {

    public static void testAlgorithms() {

        // Remove element example
        int[] array = {1, 2, 3, 4, 1, 2, 3, 2, 1, 2, 3};
        int num = 2;
        removeElement(array, num);

        // Search Insert Position
        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        int target = 9;
        System.out.println("Position to insert: " + searchInsert(array2, target));
        System.out.println("Position to insert: " + searchInsertBinary(array2, target));

        // Anagram example
        String[] strings = {"torchwood", "doctorwho", "hello", "tommarvoloriddle", "iamlordvoldemort"};
        anagrams(strings);
    }

    /**
     * Given an array and a value, remove all instances of that value in place
     * and return the new length. (Note: The order of elements can be changed.
     * It doesn't matter what you leave beyond the new length.)
     *
     * @author http://www.programcreek.com/2014/04/leetcode-remove-element-java/
     *
     * @param array
     * @param elem
     * @return i new length
     */
    public static int removeElement(int[] array, int elem) {
        System.out.println("Initial array: " + Arrays.toString(array));
        System.out.println("Initial length = " + array.length);

        int i = 0;
        int j = 0;

        while (j < array.length) {

            if (array[j] != elem) {
                array[i] = array[j];
                i++;
            }

            j++;

        }

        int[] newArray = new int[i];
        System.arraycopy(array, 0, newArray, 0, i);

        System.out.println("New array: " + Arrays.toString(newArray));
        System.out.println("New length = " + i);
        return i;
    }

    /**
     *
     * Given a sorted array and a target value, return the index if the target
     * is found. If not, return the index where it would be if it were inserted
     * in order. You may assume no duplicates in the array.
     *
     * @author
     * http://www.programcreek.com/2013/01/leetcode-search-insert-position/
     *
     * @param A
     * @param target
     * @return
     */
    public static int searchInsert(int[] A, int target) {

        if (A == null) {
            return 0;
        }

        if (target <= A[0]) {
            return 0;
        }

        for (int i = 0; i < A.length - 1; i++) {
            System.out.println("Brute Force");
            if (target > A[i] && target <= A[i + 1]) {
                return i + 1;
            }
        }

        return A.length;
    }

    public static int searchInsertBinary(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }

        return searchInsert(A, target, 0, A.length - 1);
    }

    public static int searchInsert(int[] A, int target, int start, int end) {
        System.out.println("Binary");
        int mid = (start + end) / 2;

        if (target == A[mid]) {
            return mid;
        } else if (target < A[mid]) {
            return start < mid ? searchInsert(A, target, start, mid - 1) : start;
        } else {
            return end > mid ? searchInsert(A, target, mid + 1, end) : (end + 1);
        }
    }

    /**
     *
     * Given an array of strings, return all groups of strings that are
     * anagrams.
     *
     * Analysis
     *
     * An anagram is a type of word play, the result of rearranging the letters
     * of a word or phrase to produce a new word or phrase, using all the
     * original letters exactly once; for example Torchwood can be rearranged
     * into Doctor Who.
     *
     * If two strings are anagram to each other, their sorted sequence is the
     * same. Therefore, this problem can be seen as a problem of finding
     * duplicate elements.
     *
     * @author http://www.programcreek.com/2014/04/leetcode-anagrams-java/
     *
     * @param strs
     * @return
     */
    public static List<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String t = String.valueOf(arr);
            if (map.get(t) == null) {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(t, l);
            } else {
                map.get(t).add(i);
            }
        }

        for (ArrayList<Integer> l : map.values()) {
            if (l.size() > 1) {
                for (Integer i : l) {
                    result.add(strs[i]);
                    System.out.println(strs[i]);
                }
            }
        }

        return result;
    }

}

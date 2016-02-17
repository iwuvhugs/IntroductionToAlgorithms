/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introductiontoalgorithms.tree;

import introductiontoalgorithms.datastructures.TreeNode;

/**
 *
 * @author iwuvhugs
 */
public class BinaryTreeAlgorithm {

    public static void testBT() {
        TreeNode first = new TreeNode(5);

        TreeNode secondLeft = new TreeNode(3);
        TreeNode secondRight = new TreeNode(7);
        first.left = secondLeft;
        first.right = secondRight;

        TreeNode thirdLeftLeft = new TreeNode(1);
        TreeNode thirdLeftRight = new TreeNode(4);
        secondLeft.left = thirdLeftLeft;
        secondLeft.right = thirdLeftRight;

        TreeNode thirdRightLeft = new TreeNode(6);
        TreeNode thirdRightRight = new TreeNode(8);
        secondRight.left = thirdRightLeft;
        secondRight.right = thirdRightRight;

        System.out.println(maxPathSum(first));
    }

    /**
     * Given a binary tree, find the maximum path sum. The path may start and
     * end at any node in the tree. For example, given the below binary treeF
     *
     * @param root
     * @return
     *
     * @author
     * http://www.programcreek.com/2013/02/leetcode-binary-tree-maximum-path-sum-java/
     */
    public static int maxPathSum(TreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculateSum(root, max);
        return max[0];
    }

    public static int calculateSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int left = calculateSum(root.left, max);
        int right = calculateSum(root.right, max);

        int current = Math.max(root.value, Math.max(root.value + left, root.value + right));

        max[0] = Math.max(max[0], Math.max(current, left + root.value + right));

        return current;
    }
}

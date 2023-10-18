package com.crr.dsa.priorityqueue;

public class MinHeapPreorderSorted {
	static class TreeNode {
		int val;
		TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static TreeNode sortAsc(int[] elements, int i) {
		if (i >= elements.length - 1)
			return null;
		int data = elements[i];
		int min = data;
		for (int j = i; j < elements.length - 2; j++) {
			min = Math.min(min, elements[j + 1]);
			if (min != data) {
				elements[min] = elements[j];
			}
		}
		i++;

		sortAsc(elements, i);
		return null;

	}

	public static void sortdes(int[] elements, int i) {
		if (i >= elements.length - 1)
			return;
		int data = elements[i];
		int min = data;
		int max = 0;
		for (int j = i; j < elements.length - 1; j++) {

			if (elements[j + 1] > min) {
				min = elements[j + 1];
				max = j + 1;
			}
		}
		if (max != 0) {
			elements[i] = elements[max];
			elements[max] = data;
		}
		i++;

		sortdes(elements, i);

	}

	public static void buildHeapTreeAsc(int[] array, int i) {
		if (i >= array.length - 1)
			return;

		int left = i * 2 + 1;
		int right = i * 2 + 2;
		int shift = right * 2 + 1 - right - 1;

		if (shift >= array.length - 1)
			return;

		for (int j = right * 2 + 1 - 1; shift != 0; shift--) {
			int temp = array[j - 1];

			array[j - 1] = array[j];
			array[j] = temp;
			j--;
		}
		i++;
		buildHeapTreeAsc(array, i + 1);
	}

	public static TreeNode buildTree(int[] array, int i) {
		if (i > array.length - 1)
			return null;
		TreeNode root = new TreeNode(array[i]);

		root.left = buildTree(array, i * 2 + 1);
		root.right = buildTree(array, i * 2 + 2);
		return root;
	}

	public static void preorderTraversal(TreeNode node) {
		if (node != null) {
			System.out.print(node.val + " ");
			preorderTraversal(node.left);
			preorderTraversal(node.right);
		}
	}

	public static void main(String[] args) {
		int[] elements = { 3, 5, 10, 12, 15, 18, 20 };
		System.out.println("System.out.println(\"Preorder Traversal of the Max-Heap (sorted in ascending order):\");");
		// sortAsc(elements, 0);
		buildHeapTreeAsc(elements, 0);
		TreeNode root = buildTree(elements, 0);
		for (int i : elements) {
			System.out.print(i + " ");
		}
		System.out.println();
		preorderTraversal(root);
		System.out.println();
		 System.out.println("Preorder Traversal of the Max-Heap (sorted in descending order):");
		sortdes(elements, 0);
		for (int i : elements) {
			System.out.print(i + " ");
		}
		buildHeapTreeAsc(elements, 0);
		System.out.println();
		for (int i : elements) {
			System.out.print(i + " ");
		}
		TreeNode root1 = buildTree(elements, 0);
		System.out.println();
		preorderTraversal(root1);
	}
}

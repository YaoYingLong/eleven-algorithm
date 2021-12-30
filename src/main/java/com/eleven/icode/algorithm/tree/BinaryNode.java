package com.eleven.icode.algorithm.tree;

/**
 * @author by Eleven on 2021/12/30
 */
public class BinaryNode {
	int data;
	BinaryNode left;
	BinaryNode right;
	BinaryNode parent;

	public BinaryNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}

package com.bsttoskewed.answer2;

import java.io.*;

//Binary Search Tree conversion to Skewed Tree

public class BSTtoSkewedConversion {
	
		int val;
		BSTtoSkewedConversion left, right;
		
		// with the given data and NULL left and right
		// pointers.
		BSTtoSkewedConversion(int item)
		{
			val = item;
			left = right = null;
		}
	}
	class GFG
	{
		public static BSTtoSkewedConversion node;
		static BSTtoSkewedConversion prevNode = null;
		static BSTtoSkewedConversion headNode = null;


		// BS tree into a skewed tree in
		// increasing / decreasing order
		static void BSTToSkewed(BSTtoSkewedConversion root, int order)
		{
		
			// Base Case
			if(root == null)
			{
				return;
			}
		
			// checking Condition to order in which the skewed tree to maintain
			
			if(order > 0)
			{
				BSTToSkewed(root.right, order);
			}
			else
			{
				BSTToSkewed(root.left, order);
			}
			BSTtoSkewedConversion rightNode = root.right;
			BSTtoSkewedConversion leftNode = root.left;
		
			// Condition to check if the root Node of the skewed tree is not define
			if(headNode == null)
			{   headNode = root;
				root.left = null;
				prevNode = root;	}
			else
			{	prevNode.right = root;
				root.left = null;
				prevNode = root;	}
		
			// Left & Right recursive call 
			
			if (order > 0)
			{	BSTToSkewed(leftNode, order);	}
			else
			{	BSTToSkewed(rightNode, order);	}
		}

		// Right traversal function, skewed tree using recursion
		static void traverseRightSkewed(BSTtoSkewedConversion root)
		{	if(root == null)
			{
				return;
				
			}	System.out.print(root.val + " ");
			traverseRightSkewed(root.right);	
		}

		// Main Driver 
		public static void main (String[] args)
		{
		/* 				5
			 		  /   \
					30	   60	
				   /         \
		         10           55		*/

			
			GFG tree = new GFG();
	tree.node = new BSTtoSkewedConversion(50);
	tree.node.left = new BSTtoSkewedConversion(30);
	tree.node.right = new BSTtoSkewedConversion(60);
	tree.node.left.left = new BSTtoSkewedConversion(10);
	tree.node.right.left= new BSTtoSkewedConversion(55);
		

			int order = 0;
			BSTToSkewed(node, order);
			traverseRightSkewed(headNode);
		}
	}

	// by ~Uprant

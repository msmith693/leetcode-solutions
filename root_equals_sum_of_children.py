"""
Problem: Root Equals Sum of Children
Link: https://leetcode.com/problems/root-equals-sum-of-children
Difficuty: Easy

Approach: Access the values of the roots left and right child nodes. 
Return true if the sum of these values is equal to the value stored in root node, and false if not.
This was carried out with boolean operator == in return statement, eliminating need for if statement.
""" 
class Solution(object):
    def checkTree(self, root):
        return (root.left.val+root.right.val)==root.val
        
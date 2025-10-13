"""
Problem: Running Sum of 1d Array
Link: https://leetcode.com/problems/running-sum-of-1d-array
Difficuty: Easy

Approach: 
Create a new array (although problem did not specify that the nums array could be modified in place).
Initialise a running sum variable previousNum that tracks the total value of numbers in array up to the current number of interest.
Iterate through array and add number newNum to previousNum.
Append total sum of array so far to the end of the runningSumArr.
""" 

class Solution(object):
    def runningSum(self, nums):
        runningSumArr=[]
        previousNum=0
        for num in nums:
            newNum=num+previousNum
            previousNum=newNum
            runningSumArr.append(newNum)
        return runningSumArr
        
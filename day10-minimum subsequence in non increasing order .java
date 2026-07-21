class Solution:
    def minSubsequence(self, nums: List[int]) -> List[int]:
        # Sort in descending order
        nums.sort(reverse=True)
        
        total_sum = sum(nums)
        sub_sum = 0
        result = []
        
        # Pick the largest numbers until their sum is greater than remaining sum
        for num in nums:
            sub_sum += num
            result.append(num)
            
            if sub_sum > total_sum - sub_sum:
                break
        
        return result
      

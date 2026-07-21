class Solution:
    def canConstruct(self, s: str, k: int) -> bool:
        n = len(s)

        # Need at least k characters to make k non-empty strings
        if n < k:
            return False

        freq = [0] * 26

        for ch in s:
            freq[ord(ch) - ord('a')] += 1

        odd_count = 0

        for count in freq:
            if count % 2 == 1:
                odd_count += 1

        # Each palindrome can handle at most one odd frequency character
        return odd_count <= k
      

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        mapping = {
            ')': '(',
            '}': '{',
            ']': '['
        }

        for char in s:
            # If it's a closing bracket
            if char in mapping:
                # Check if stack is not empty and top matches
                if stack and stack[-1] == mapping[char]:
                    stack.pop()
                else:
                    return False
            else:
                # If it's an opening bracket
                stack.append(char)

        # Valid only if no unmatched opening brackets remain
        return len(stack) == 0
          

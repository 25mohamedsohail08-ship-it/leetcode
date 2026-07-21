class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        INT_MAX = 2**31 - 1
        INT_MIN = -2**31

        # Overflow case
        if dividend == INT_MIN and divisor == -1:
            return INT_MAX

        # Determine sign of result
        negative = (dividend < 0) != (divisor < 0)

        # Work with positive numbers
        dividend = abs(dividend)
        divisor = abs(divisor)

        quotient = 0

        # Subtract divisor using bit shifting
        while dividend >= divisor:
            temp = divisor
            multiple = 1

            while dividend >= (temp << 1):
                temp <<= 1
                multiple <<= 1

            dividend -= temp
            quotient += multiple

        # Apply sign
        if negative:
            quotient = -quotient

        # Clamp to 32-bit integer range
        return max(INT_MIN, min(INT_MAX, quotient))

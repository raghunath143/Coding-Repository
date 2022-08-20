def largestRectangleArea(self, heights: List[int]) -> int:
        maxArea = 0
        stack = []
        for i, n in enumerate(heights):
            start = i
            while stack and stack[-1][1] > n:
                idx, h = stack.pop()
                maxArea = max(maxArea, h*(i-idx))
                start = idx
            stack.append((start,n))
            
        for i,h in stack:
            maxArea = max(maxArea, h*(len(heights)-i))
        return maxArea

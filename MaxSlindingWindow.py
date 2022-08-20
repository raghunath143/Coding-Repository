def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        nu = len(nums)
        if nu * k == 0:
            return []
        if k==1:
            return nums
        q = collections.deque()
        l = r = 0
        ans = []
        while r < len(nums):
            while q and nums[r]>nums[q[-1]]:
                q.pop()
            q.append(r)
            if l > q[0]:
                q.popleft()
            if r+1 >= k:
                ans.append(nums[q[0]])
                l+=1
            r+=1
        return ans

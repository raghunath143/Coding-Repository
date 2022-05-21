//Given the head of a singly linked list, return true if it is a palindrome.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode f = head;
        ListNode l = head;
        while(l.next != null && l.next.next != null){
            f = f.next;
            l = l.next.next;
        }
        
        ListNode m = new ListNode();
        
        if(l.next==null){
            m = f;
        }
        else{
            m = f.next;
        }
        
        ListNode a = reverse(m);
        ListNode b = head;
        
        while(a != null && b != null){
            if(a.val == b.val){
                a = a.next;
                b = b.next;
            }
            else{
                return false;
            }
        }
        
        return true;
        
    }
    
    public ListNode reverse(ListNode head){
        ListNode temp = null, curr = head, prev = null;
        while(curr !=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}
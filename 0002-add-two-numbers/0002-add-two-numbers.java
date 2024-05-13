public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // Deserialize method to convert a string to a linked list
    public static ListNode deserialize(String s) {
        s = s.replaceAll("[\\[\\]]", ""); // Remove square brackets
        String[] values = s.split(",");
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (String value : values) {
            current.next = new ListNode(Integer.parseInt(value.trim())); // Trim spaces
            current = current.next;
        }
        return dummy.next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}
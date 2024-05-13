class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static ListNode deserialize(String s) {
        if (s == null || s.isEmpty()) {
            return null; 
        }
        s = s.replaceAll("[\\[\\]]", ""); 
        String[] values = s.split(",");
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (String value : values) {
            try {
                current.next = new ListNode(Integer.parseInt(value.trim())); 
                current = current.next;
            } catch (NumberFormatException e) {
                return null; 
            }
        }
        return dummy.next;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }
        
        return dummy.next;
    }
}

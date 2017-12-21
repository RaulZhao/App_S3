package test;
import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class Solution2 {
    LinkedList<ListNode> headers = new LinkedList<ListNode>();
    ListNode dummy = new ListNode(-1);
    ListNode result = new ListNode(-1);

    public ListNode mergeKLists(ListNode[] lists) {
        for(int i=0; i < lists.length; i++) {
            if (lists[i] != null) {
                headers.add(lists[i]);
            }
        }
        if (headers.size() < 1) {
            return null;
        }
        ListNode tmp = getNext();
        dummy.next = tmp;
        dummy = tmp;
        result.next = tmp;
        while(tmp != null) {
            tmp = getNext();
            dummy.next = tmp;
            dummy = tmp;
        }
        return result.next;
    }
    public ListNode getNext() {
        Collections.sort(headers, new NodeComparator());
        ListNode currNode = headers.get(0);
        ListNode result = currNode;
        if(currNode != null) {
            currNode = currNode.next;
        }
        return result;
    }
     
}

class NodeComparator implements Comparator<ListNode> {
    public int compare(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return -1;
        } else if (node2 == null) {
            return 1;
        } else {
            if (node1.val > node2.val) {
                return 1;
            } else if(node1.val == node2.val) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
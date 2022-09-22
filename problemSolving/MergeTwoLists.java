package problemSolving;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/"> link to the problem description </a>
 */

public class MergeTwoLists {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

	}


	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
			ListNode dummynode = new ListNode() ;
			ListNode currentNode = dummynode ;

			while (list1 != null || list2 != null){
				int x = list1 != null ? list1.val : 101 ;
				int y = list2 != null ? list2.val : 101 ;
				ListNode tempNode = new ListNode() ;
				if(x > y  ){
					tempNode.val = y ;
					 list2 = list2.next ;
				}else  {
					tempNode.val = x ;
					 list1 = list1.next ;
				}
				currentNode.next = tempNode ;
				currentNode = currentNode.next ;
			}

			return dummynode.next ;
	}

	/**
	 * another version of the solution with enhancement in the space complexity
	 * time complexity : O(n + m) n and m are the lenght of the two nodes
	 * space complexity is : O(1) because we don't use another list to store the result like we did in the other solution
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

		ListNode p1 = list1 ;
		ListNode p2 = list2 ;

		if(p1 == null){
			return  p2 ;
		} else if (p2 == null) {
			return p1 ;
		}
		ListNode head = p1.val < p2.val ? p1 : p2 ;

		ListNode firstNode = null ;
		if(p1.val == p2.val) {
			firstNode = new ListNode(p1.val) ;
		}

		ListNode prev1  = null ;
		ListNode prev2  = null ;

		while (list1 != null && list2 != null){
			if (p1.val <= p2.val){
				if(p1.next != null){
					if (p1.next.val > p2.val){
						list1 = list1.next ;
						p1.next = p2 ;
						p1 = list1 ;
					}else {
						list1 = list1.next ;
						p1 = list1 ;
					}
				}else {
					list1 = list1.next ;
					p1.next = p2 ;
				}

			}else  {
				if(p2.next != null){
					if(p2.next.val < p1.val){
						list2 = list2.next ;
						p2 = list2 ;
					}else {
						list2 = list2.next ;
						p2.next = p1 ;
						p2 = list2 ;
					}
				}else {
					list2 = list2.next ;
					p2.next = p1 ;
				}
			}

		}
		if(firstNode  != null) {
			firstNode.next = head ;
			return firstNode ;
		}
		return head ;
	}

	public static void main(String[] args) {
		ListNode node1 =	new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2))));
		ListNode node2 =	new ListNode(1, new ListNode(2)) ;


		ListNode node = mergeTwoLists2(node1, node2);

		ListNode currentNode =  node ;

		while(currentNode != null){

			System.out.println(currentNode.val);
			currentNode = currentNode.next ;
		}
	}
}

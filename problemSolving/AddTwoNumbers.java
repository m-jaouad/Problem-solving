package problemSolving;


/**
 * <a href="https://leetcode.com/problems/add-two-numbers/">link to the problem description</a>
 */


public class AddTwoNumbers {

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

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum = 0  ;
		int reminder = 0 ;
		ListNode node = new ListNode();

		ListNode currentNode = node;
		ListNode previousNode = null ;
		while(l1 != null && l2 != null){
			sum = l1.val + l2.val  + reminder;
			reminder = sum / 10 ;
			int val = sum % 10 ;
			currentNode.val = val ;
			System.out.println("( " + l1.val + ", "+l2.val + ")" + "=" + val);


			currentNode.next = new ListNode() ;
			l1 = l1.next ;
			l2 = l2.next ;
			previousNode = currentNode ;
			currentNode = currentNode.next ;
		}
		ListNode continueNode = null ;
		if(l1 == null) continueNode = l2 ;
		else if (l2 == null) continueNode = l1 ;

		while (continueNode != null){
			sum = continueNode.val  + reminder;
			reminder = sum / 10 ;
			int val = sum % 10 ;
			currentNode.val = val ;
			System.out.println("( " + continueNode.val  +")" + "=" + val);


			currentNode.next = new ListNode() ;
			continueNode = continueNode.next ;

			previousNode = currentNode ;
			currentNode = currentNode.next ;
		}

		if(reminder > 0) currentNode.val = reminder ;
		else previousNode.next = null ;
		return node ;
	}


	/**
	 * another version for the solution , but only using one loop instead of two seperate loops
	 * still the time complexity is the same : O(max(n, m))
	 * space complexity  is : O(max(n, m))
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2){
		ListNode dummyHead = new ListNode() ;
		int carry = 0 ;

		ListNode currentNode = dummyHead ;
		while (l1 != null || l2 != null || carry > 0){
			// access the  value of the nodes in the linked list if there still any nodes
			int x = l1 != null ? l1.val : 0 ;
			int y = l2 != null ? l2.val : 0 ;

			// calculate the sum and the carry
			int sum = x + y + carry ;
			carry = sum / 10 ;
			currentNode.next = new ListNode(sum % 10) ;

			if (l1 != null) l1 = l1.next ;
			if (l2 != null) l2 = l2.next ;

			currentNode = currentNode.next ;

		}

		return dummyHead.next ;
	}


	public static void main(String[] args) {
		//creation of a second node within the linked list
	ListNode node1 =	new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(5)))) ;
	ListNode node2 =	new ListNode(5, new ListNode(6, new ListNode(9))) ;
		ListNode node = addTwoNumbers2(node2, node1);

		ListNode currentNode =  node ;

	while(currentNode != null){

		System.out.println(currentNode.val);
		currentNode = currentNode.next ;
	}
	}

}

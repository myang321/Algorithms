package leetcode;


public class MergeTwoSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] a= {-4,1} ;
		int [] b= {-3,0};
		ListNode l1 = reateList(a);
		ListNode l2 = reateList(b);
		
		printList(mergeTwoLists(l1,l2));
		
	}
	
	static ListNode reateList(int [] arr){
		ListNode head= new ListNode(0);
		ListNode old = head;
		for (int e : arr){
			old.next = new ListNode(e);
			old=old.next;
		}
		return head.next;
	}
	
	static void printList(ListNode l){
		while(l!=null){
			System.out.print(l.val+" ");
			l=l.next;
		}
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1==null)
			return l2;
		if (l2==null)
			return l1;
		if (l1.val>l2.val){
			ListNode tmp = l1;
			l1=l2;
			l2=tmp;
		}
		ListNode head =l1;
		ListNode l1cur=l1;//current l1
		ListNode l1old=null;
		ListNode l2oldnext=null;
		while(l2!=null){
			if (l1cur.val >l2.val){
				// insert l2 between l1old and l1cur
				l2oldnext = l2.next;
				l1old.next=l2;
				l2.next=l1cur;
				l1old=l2;
				l2=l2oldnext;
			}else if (l1cur.next!=null){
				l1old=l1cur;
				l1cur=l1cur.next;
			}else{
				//reach l1's end
				l1cur.next=l2;
				break;
			}
		}
		return head;  
    }

}

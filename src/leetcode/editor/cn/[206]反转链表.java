package leetcode.editor.cn;//反转一个单链表。
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1383 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode headNode = new ListNode(0);
        ListNode node = headNode;
        while(head!=null){
            //根据head的值新生成一个listnode节点
            ListNode temp = new ListNode(head.val);
            temp.next=node.next;
            node.next=temp;
            head=head.next;
        }
        return headNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

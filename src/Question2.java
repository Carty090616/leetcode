/**
 * 两数相加
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author lifeifei
 * @create 2020-06-17
 * @since 1.0.0
 */
public class Question2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static String print(ListNode l) {
        StringBuilder sb = new StringBuilder();
        while (l != null) {
            sb.append(l.val);
            l = l.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l1Next = new ListNode(4);
        ListNode l1NextNext = new ListNode(3);
        l1Next.next = l1NextNext;
        l1.next = l1Next;

        ListNode l2 = new ListNode(5);
        ListNode l2Next = new ListNode(6);
        ListNode l2NextNext = new ListNode(4);
        l2Next.next = l2NextNext;
        l2.next = l2Next;

        System.out.println(print(solution(l1, l2)));

    }
}
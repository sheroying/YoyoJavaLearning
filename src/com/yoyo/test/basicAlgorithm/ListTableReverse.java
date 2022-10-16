package com.yoyo.test.basicAlgorithm;

public class ListTableReverse {

    public static void main(String[] args) {
        /*
        reverse the link table;
         */
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);


        ListNode prev = ListNode.reverseByIterate(node1);
        System.out.println(prev);
        ListNode prev2 = ListNode.reverseByRecursion(node1);
        System.out.println(prev2);

    }

    public static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value, ListNode listNode) {
            this.value = value;
            this.next = listNode;
        }

        //迭代下一个直至最后一个

//        next = current.next;
//        current.next = prev;
//        prev = current;
//
//        current = next;
        public static ListNode reverseByIterate(ListNode head) {
            ListNode prev = null;
            ListNode next;
            ListNode current = head;
            while (current != null) {
                // 先保存current.next 值，防止丢失
                next = current.next;
                current.next = prev;
                prev = current;

                //将循环变量指向下一个元素，依次进行迭代直至迭代至最后一个元素完成反转
                current = next;
            }
            return prev;
        }

        /*
            递归形成循环，从找到链表的最后一个开始进行反向指，直到head 变成空或者head.next变成空
         */
        public static ListNode reverseByRecursion(ListNode head) {
            if (null == head || head.next == null) {
                return head;
            }
//       自己调用自己，并将新返回的值保存起来并return回去；调用自己形成循环，直到找到链表的最后一个节点，然后进行反向指向
            ListNode new_head = reverseByRecursion(head.next);
            //进行反向指向，头变尾
            head.next.next = head;
            //当前节点的next变为空，防止形成环形链表
            head.next = null;
            return new_head;
        }
    }
}
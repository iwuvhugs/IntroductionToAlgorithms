/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introductiontoalgorithms.linkedlist;

import introductiontoalgorithms.datastructures.Node;

/**
 *
 * @author iwuvhugs
 */
public class LinkedListAlgorithms {

    public static void testLinkedList() {

        Node first = new Node(1);
        Node second = new Node(2);
        first.next = second;
        Node third = new Node(3);
        second.next = third;
        Node forth = new Node(4);
        third.next = forth;

        Node start = first;
        System.out.println(start.val);
        while (start.next != null) {
            start = start.next;
            System.out.println(start.val);
        }
        
        start = reverseList(first);
        System.out.println("");
        
        System.out.println(start.val);
        while (start.next != null) {
            start = start.next;
            System.out.println(start.val);
        }

    }

    /**
     * 
     * @param head
     * @return 
     */
    public static Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node p1 = head;
        Node p2 = head.next;

        head.next = null;
        while (p1 != null && p2 != null) {
            Node t = p2.next;
            p2.next = p1;
            p1 = p2;
            if (t != null) {
                p2 = t;
            } else {
                break;
            }
        }

        return p2;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introductiontoalgorithms.datastructures;

/**
 *
 * @author
 * http://www.programcreek.com/2012/11/top-10-algorithms-for-coding-interview/
 */
public class Queue {

    Node first, last;

    public void enqueue(Node n) {
        if (first == null) {
            first = n;
            last = first;
        } else {
            last.next = n;
            last = n;
        }
    }

    public Node dequeue() {
        if (first == null) {
            return null;
        } else {
            Node temp = new Node(first.val);
            first = first.next;
            return temp;
        }
    }
}

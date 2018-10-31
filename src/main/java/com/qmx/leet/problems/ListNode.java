package com.qmx.leet.problems;

import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        if (Objects.isNull(next)) {
            return String.valueOf(val) + Strings.EMPTY;
        } else {
            return String.valueOf(val) + next.toString();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListNode listNode = (ListNode) o;

        if (val != listNode.val) return false;
        return next != null ? next.equals(listNode.next) : listNode.next == null;
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }
}

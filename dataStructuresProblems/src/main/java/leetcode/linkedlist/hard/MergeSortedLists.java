package leetcode.linkedlist.hard;

import model.ListNode;

/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
start time: 15:29 - end time 16:18
Runtime: 10.17% / Memory: 53.70%
 */
public class MergeSortedLists {

    public static void main(String args[]) {
        ListNode[] lists = new ListNode[2];
        lists[0] = new ListNode(1);
        lists[1] = new ListNode(0);

        MergeSortedLists mergeLists = new MergeSortedLists();
        mergeLists.mergeKLists(lists);
    }
    ListNode mergedList;

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 0) {
            return mergedList;
        }


        int total = lists.length;
        int k = 0;

        while (k < lists.length) {
            merge(lists[k]);
            k++;
        }

        return mergedList;
    }

    private void merge(ListNode list) {

        if (mergedList == null) {
            mergedList = list;
            return;
        }

        ListNode currentMerged = mergedList;
        ListNode currentToMerge = list;

        while (currentToMerge != null) {

             if (currentToMerge.val < currentMerged.val) {
                ListNode temp = currentToMerge.next;
                currentToMerge.next = currentMerged;
                mergedList = currentToMerge;
                currentMerged = currentToMerge;
                currentToMerge = temp;
            }
            else if (currentMerged.next == null || currentToMerge.val < currentMerged.next.val) {
                ListNode temp = currentToMerge.next;
                currentToMerge.next = currentMerged.next;
                currentMerged.next = currentToMerge;
                currentToMerge = temp;
            } else {
                currentMerged = currentMerged.next;
            }

        }

    }
}

package leetcode.arrays.hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    public static void main(String args[]) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);

        Double median = medianFinder.findMedian();
    }
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue(Collections.reverseOrder());
        minHeap = new PriorityQueue();
    }

    public void addNum(int num) {

        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

    }

    public Double findMedian() {

        if (maxHeap.size() > minHeap.size()) {
            return Double.valueOf(maxHeap.peek());
        }

        return (maxHeap.peek() + minHeap.peek()) / 2D;
    }
}

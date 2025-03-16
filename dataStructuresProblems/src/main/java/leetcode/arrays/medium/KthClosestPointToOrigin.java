package leetcode.arrays.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
Runtime: 48.30% / Memory: 37.87%
 */
public class KthClosestPointToOrigin {

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Point> heap = new PriorityQueue<Point>(Comparator.comparingDouble(point -> point.distanceOrigin));

        for (int i = 0; i < points.length; i++) {
            heap.offer(new Point(points[i]));
        }

        int[][] result = new int[Math.min(heap.size(), k)][2];
        int i = 0;
        while (i < k && !heap.isEmpty()) {
            Point point = heap.poll();
            result[i] = point.points;
            i++;
        }

        return result;
    }

    private class Point {

        public int[] points;
        public Double distanceOrigin;

        Point(int[] points) {
            this.points = points;
            this.distanceOrigin = Math.sqrt(Math.pow(points[0], 2) + Math.pow(points[1], 2));
        }

    }
}

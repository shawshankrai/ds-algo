package java.ds.arrays.meetingroom;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    
    private static int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(!queue.isEmpty() && start >= queue.peek()) {
                queue.poll();
            }

            queue.offer(end);
        }
        
        return queue.size();
    }

    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}})); // 2
        System.out.println(minMeetingRooms(new int[][]{{7,10},{2,4}}));         // 1
        System.out.println(minMeetingRooms(new int[][]{{1,5},{2,6},{4,8}}));    // 3
        System.out.println(minMeetingRooms(new int[][]{}));                     // 0
    }
}

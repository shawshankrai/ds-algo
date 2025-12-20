package java.ds.arrays.meetingroom;

import java.util.Arrays;

public class MeetingRooms {

    private static boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return true;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int previousEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(previousEnd > start) return false;

            previousEnd = end;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canAttendMeetings(new int[][]{{0,30},{5,10},{15,20}})); // false
        System.out.println(canAttendMeetings(new int[][]{{7,10},{2,4}}));         // true
    }
}
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        String[] arriveA = arriveAlice.split("-");
        String[] arriveB = arriveBob.split("-");
        String[] leaveA = leaveAlice.split("-");
        String[] leaveB = leaveBob.split("-");

        int A_arrive_month = Integer.parseInt(arriveA[0]);
        int A_arrive_day   = Integer.parseInt(arriveA[1]);

        int A_leave_month  = Integer.parseInt(leaveA[0]);
        int A_leave_day    = Integer.parseInt(leaveA[1]);

        int B_arrive_month = Integer.parseInt(arriveB[0]);
        int B_arrive_day   = Integer.parseInt(arriveB[1]);

        int B_leave_month  = Integer.parseInt(leaveB[0]);
        int B_leave_day    = Integer.parseInt(leaveB[1]);

        int sum1 = A_arrive_day;
        int sum2 = B_arrive_day;

        for (int i = 1; i < A_arrive_month; i++) {
            if (i == 2) {
                sum1 += 28;
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                sum1 += 30;
            } else {
                sum1 += 31;
            }
        }

        for (int i = 1; i < B_arrive_month; i++) {
            if (i == 2) {
                sum2 += 28;
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                sum2 += 30;
            } else {
                sum2 += 31;
            }
        }

        int leave1 = A_leave_day;
        int leave2 = B_leave_day;

        for (int i = 1; i < A_leave_month; i++) {
            if (i == 2) {
                leave1 += 28;
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                leave1 += 30;
            } else {
                leave1 += 31;
            }
        }

        for (int i = 1; i < B_leave_month; i++) {
            if (i == 2) {
                leave2 += 28;
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                leave2 += 30;
            } else {
                leave2 += 31;
            }
        }

        int start = Math.max(sum1, sum2);
        int end = Math.min(leave1, leave2);

        if (start > end) {
            return 0;
        }

        return end - start + 1;
    }
}
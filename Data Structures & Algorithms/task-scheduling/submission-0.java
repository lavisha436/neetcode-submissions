class Solution {

    public int leastInterval(char[] tasks, int n) {

        // Frequency array
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Max Heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }

        // {remainingFrequency, availableTime}
        Queue<int[]> queue = new LinkedList<>();

        int time = 0;

        while (!maxHeap.isEmpty() || !queue.isEmpty()) {

            time++;

            // First move all tasks whose cooldown is over
            while (!queue.isEmpty() && queue.peek()[1] <= time) {
                maxHeap.offer(queue.poll()[0]);
            }

            // Execute the task with maximum remaining frequency
            if (!maxHeap.isEmpty()) {

                int remaining = maxHeap.poll();
                remaining--;

                if (remaining > 0) {
                    queue.offer(new int[]{remaining, time + n + 1});
                }
            }
        }

        return time;
    }
}
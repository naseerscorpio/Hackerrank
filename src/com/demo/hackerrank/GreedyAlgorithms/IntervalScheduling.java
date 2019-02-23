package com.demo.hackerrank.GreedyAlgorithms;

import java.util.Arrays;
import java.util.LinkedList;

class Job implements Comparable<Job> {

    private int start;
    private int finish;
    private String name;

    public Job(int start, int finish, String name) {
        this.start = start;
        this.finish = finish;
        this.name = name;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Job job) {
        return this.finish - job.finish;
    }

    @Override
    public String toString() {
        return "Job{" +
                "start=" + start +
                ", finish=" + finish +
                ", name='" + name + '\'' +
                '}';
    }
}

public class IntervalScheduling {


    public void scheduleJobs(Job[] jobs) {
        Arrays.sort(jobs);

        LinkedList<Job> selectedJobs = new LinkedList<>();
        selectedJobs.add(jobs[0]);

        Job lastAddedJob = jobs[0];

        for (int i = 1; i < jobs.length; i++) {
            if (jobs[i].getStart() >= lastAddedJob.getFinish()) {//compatible
                selectedJobs.add(jobs[i]);
                lastAddedJob = jobs[i];
            }
        }

        for (Job selected : selectedJobs) {
            System.out.println(selected.getName());
        }
    }

    public static void main(String[] args) {
        Job[] jobs = {
                new Job(0, 6, "a"),
                new Job(1, 4, "b"),
                new Job(3, 5, "c"),
                new Job(3, 8, "d"),
                new Job(4, 7, "e"),
                new Job(5, 9, "f"),
                new Job(6, 10, "g"),
                new Job(8, 11, "h"),
        };

        IntervalScheduling scheduling = new IntervalScheduling();
        scheduling.scheduleJobs(jobs);
    }
}

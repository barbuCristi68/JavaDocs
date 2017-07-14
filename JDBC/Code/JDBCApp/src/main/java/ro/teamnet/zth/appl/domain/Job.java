package ro.teamnet.zth.appl.domain;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

/**
 * Created by Cristian.Barbu on 7/12/2017.
 */
@Table(name="JOBS")
public class Job {
    @Id(name="JOB_ID")
    private int jobId;
    @Column(name="JOB_TITLE")
    private String jobTitle;
    @Column(name="MIN_SALARY")
    private int minSalary;
    @Column(name="MAX_SALARY")
    private int maxSalary;

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", jobTitle='" + jobTitle + '\'' +
                ", minSalary=" + minSalary +
                ", maxSalary=" + maxSalary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (jobId != job.jobId) return false;
        if (minSalary != job.minSalary) return false;
        if (maxSalary != job.maxSalary) return false;
        return jobTitle.equals(job.jobTitle);
    }

    @Override
    public int hashCode() {
        int result = jobId;
        result = 31 * result + jobTitle.hashCode();
        result = 31 * result + minSalary;
        result = 31 * result + maxSalary;
        return result;
    }

    public void setJobId(int jobId) {

        this.jobId = jobId;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public int getJobId() {

        return jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }
}

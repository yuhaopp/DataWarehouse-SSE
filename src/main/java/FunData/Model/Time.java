package FunData.Model;

import javax.persistence.*;

/**
 * Created by 13987 on 2016/12/1.
 */
@Entity
@Table(name = "Time")
public class Time {

    @Id
    @Column(nullable = false)
    private Long timeId;

    private int year;
    private int month;
    private int weekday;
    private int quarter;
    private int day;
    //年月 201612

    //年季度  20164
    private int yQuarter;
    //年周几   20161
    private int yWeekday;

    private int yMonth;

    public Time() {
        super();
    }

    public Time(Long timeId, int year, int month, int weekday, int quarter, int day, int yQuarter, int yWeekday, int yMonth) {
        this.timeId = timeId;
        this.year = year;
        this.month = month;
        this.weekday = weekday;
        this.quarter = quarter;
        this.day = day;
        this.yQuarter = yQuarter;
        this.yWeekday = yWeekday;
        this.yMonth = yMonth;
    }

    public Long getTimeId() {
        return timeId;
    }

    public void setTimeId(Long timeId) {
        this.timeId = timeId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getWeekday() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getyQuarter() {
        return yQuarter;
    }

    public void setyQuarter(int yQuarter) {
        this.yQuarter = yQuarter;
    }

    public int getyWeekday() {
        return yWeekday;
    }

    public void setyWeekday(int yWeekday) {
        this.yWeekday = yWeekday;
    }

    public int getyMonth() {
        return yMonth;
    }

    public void setyMonth(int yMonth) {
        this.yMonth = yMonth;
    }
}


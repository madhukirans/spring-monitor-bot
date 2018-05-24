package com.oracle.bm.monitor.monitor.model;

//import org.hibernate.annotations.Type;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.Date;


@Embeddable
public class Maintanicnce {



    //@Type(type=)
    private Boolean isMaintanicnce=false;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    public Maintanicnce(){

    }

    public Maintanicnce(Boolean isMaintanicnce, Date start, Date end) {
        this.isMaintanicnce = isMaintanicnce;
        this.startTime = start;
        this.endTime = end;

    }
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean getMaintanicnce() {
        return isMaintanicnce;
    }

    public void setMaintanicnce(Boolean maintanicnce) {
        isMaintanicnce = maintanicnce;
    }
}

package com.oracle.bm.monitor.monitor.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Monitor {
    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @OneToMany
    private EndPoint endPoint;

    private String serviceName;
  //  private String url;

    private Monitor() { } // JPA only



    private Maintanicnce maintanicnce;

    public Maintanicnce getMaintanicnce() {
        return maintanicnce;
    }

    public void setMaintanicnce(Maintanicnce maintanicnce) {
        this.maintanicnce = maintanicnce;
    }

    public Monitor(final EndPoint endpoint, Maintanicnce maint,  final String serviceName, final String url) {
        this.serviceName = serviceName;
        this.url = url;
        this.endPoint = endpoint;
        this.maintanicnce =maint;
    }

    public Long getId() {
        return id;
    }

    public EndPoint getEndPoint() {
        return endPoint;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}MG9NR

package com.oracle.bm.monitor.monitor.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EndPoint {

    @Id
    @GeneratedValue
    private Long id;

    private String label;
    private String url;



    private EndPoint() { } // JPA only

    public EndPoint (String label, String url) {
        this.label = label;
        this.url = url;
    }

    public Long getId() {
        return id;
    }
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
       // if (maintanicnce.getMaintanicnce() != true)
            return url;
       // else
       //     return null;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}

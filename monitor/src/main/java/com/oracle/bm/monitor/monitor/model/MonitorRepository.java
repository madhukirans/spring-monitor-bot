package com.oracle.bm.monitor.monitor.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;


public interface MonitorRepository extends JpaRepository<Monitor, Long> {
    Collection<Monitor> findByEndPointUrl(String url);
}
package com.oracle.bm.monitor.monitor.model;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EndPointRepository extends JpaRepository<EndPoint, Long> {
    Optional<EndPoint> findByUrl(String url);
}

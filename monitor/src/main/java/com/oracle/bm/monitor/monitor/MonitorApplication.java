package com.oracle.bm.monitor.monitor;

import com.oracle.bm.monitor.monitor.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.util.Arrays;
import java.util.Calendar;

@SpringBootApplication
public class MonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorApplication.class, args);
    }

    @Bean
    CommandLineRunner init(EndPointRepository endPointRepository, MonitorRepository monitorRepository) {
        return (evt) -> Arrays.asList(
                "https://google.com,https://amazon.com,https://oracle.com,https://prometheus.prod.jafar.sauron.us-ashburn-1.oracledx.com, http://slc09cwv.us.oracle.com:8080".split(","))
                .forEach(
                        url -> {
                            Maintanicnce m = new Maintanicnce(true, Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
                            String name =  url.replaceAll("(\\.|:\\/\\/)", "_");
                            EndPoint endPoint = endPointRepository.save(new EndPoint(name, url));

                            monitorRepository.save(new Monitor(endPoint, name, url));

                            System.out.println("Added :" + name + url);

                            //monitorRepository.save(new Monitor(endPoint,
                             //       "http://bookmark.com/2/" + a, "A description"));
                        });
    }
}
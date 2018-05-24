
package com.oracle.bm.monitor.monitor.controllers;

import com.oracle.bm.monitor.monitor.model.EndPointRepository;
import com.oracle.bm.monitor.monitor.model.Monitor;
import com.oracle.bm.monitor.monitor.LabelNotFoundException;
import com.oracle.bm.monitor.monitor.model.MonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;


@RestController
@RequestMapping("/monitor")
class MonitorRestController {

	private final MonitorRepository monitorRepository;
	private final EndPointRepository endPointRepository;

	@Autowired
    MonitorRestController(MonitorRepository monitorRepository, EndPointRepository endPointRepository) {
		this.monitorRepository = monitorRepository;
		this.endPointRepository = endPointRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	Collection<Monitor> readMonitors() {
		//this.validatUrl(url);
        System.out.println("IN readMonitors");
        return this.monitorRepository.findAll();//.findByEndPointUrl(url);
	}

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody Monitor input) {
		//this.validatUrl(url);

		return this.endPointRepository
				.findByUrl("")
				.map(monitor -> {
					Monitor result = monitorRepository.save(new Monitor(monitor,
                            input.getName(), input.getUrl()));

					URI location = ServletUriComponentsBuilder
						.fromCurrentRequest().path("/{id}")
						.buildAndExpand(result.getId()).toUri();

					return ResponseEntity.created(location).build();
				})
				.orElse(ResponseEntity.noContent().build());

	}

//	@RequestMapping(method = RequestMethod.GET, value = "/{monitorId}")
//	EndPoint readMonitor(@PathVariable String url, @PathVariable Long monitorId) {
//		this.validatUrl(url);
//		return this.endPointRepository.findOne(monitorId);//.findOne(monitorId);
//	}

	private void validatUrl(String url) {
        this.endPointRepository.findByUrl(url).orElseThrow(
                () -> new LabelNotFoundException(url));
	}
}
// end::code[]

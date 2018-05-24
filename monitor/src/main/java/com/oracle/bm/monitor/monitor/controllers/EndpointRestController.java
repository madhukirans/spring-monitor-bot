
package com.oracle.bm.monitor.monitor.controllers;

import com.oracle.bm.monitor.monitor.LabelNotFoundException;
import com.oracle.bm.monitor.monitor.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;


@RestController
@RequestMapping("/endpoint")
class EndpointRestController {
	private final EndPointRepository endPointRepository;

	@Autowired
    EndpointRestController(EndPointRepository endPointRepository) {
		this.endPointRepository = endPointRepository;

	}

	@RequestMapping(method = RequestMethod.GET)
	Collection<EndPoint> readEndPoints() {
		//this.validatUrl(url);
        System.out.println("IN endpoints");
        return this.endPointRepository.findAll();//.findByEndPointUrl(url);
	}

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@RequestBody Monitor input) {
		//this.validatUrl(url);

		return this.endPointRepository
				.findByUrl("")
				.map(endpoint -> {
					//Maintanicnce m = new Maintanicnce(false, null,null);
					EndPoint result = endPointRepository.save(new EndPoint(input.getName(), input.getUrl()));

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

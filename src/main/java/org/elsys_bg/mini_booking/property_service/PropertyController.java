package org.elsys_bg.mini_booking.property_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PropertyController {
	
	@Autowired
	private CassandraOperations cassandraTemplate;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;


	@GetMapping("/properties")
	public List<PropertyOfUser> getProperties() {
		List<PropertyOfUser> properties = cassandraTemplate.query(PropertyOfUser.class).all();
		return properties;
	}

	@PostMapping("/property")
	public void addProperty() {
		PropertyOfUser peshoMansion = new PropertyOfUser(1,
														 1,
														 "pesh manshon",
														 "us za isus",
														 69);
		cassandraTemplate.insert(peshoMansion);
	}

	@PostMapping("/request")
	public void requestProperty() {
		kafkaTemplate.send("requested", "Pesho iska kushta");
	}
}

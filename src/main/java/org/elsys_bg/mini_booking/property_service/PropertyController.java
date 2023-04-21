package org.elsys_bg.mini_booking.property_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;


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
	public ResponseEntity<String> addProperty(HttpSession session, @RequestBody PropertyOfUser propertyOfUser) {
		if (session.getAttribute("userId") == null) {
			return ResponseEntity.badRequest().body("user not logged in!");
		}

		cassandraTemplate.insert(propertyOfUser);
		return ResponseEntity.ok().body("OK");
	}

	@PostMapping("/request")
	public ResponseEntity<String> requestProperty() {
		kafkaTemplate.send("request", "Pesho iska kushta");
		return ResponseEntity.ok().body("OK");
	}
}

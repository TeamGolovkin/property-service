package org.elsys_bg.mini_booking.property_service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PropertyController {
	
	@Autowired
	private CassandraOperations cassandraTemplate;

	@GetMapping("/properties")
	public List<Property> getProperties() {
		List<Property> properties = cassandraTemplate.query(Property.class).all();
		return properties;
	}

	@PostMapping("/property")
	public void addProperty() {
		Property peshoMansoin = new Property(69, "us");
		cassandraTemplate.insert(peshoMansoin);

		Property queriedPesho = cassandraTemplate.selectOneById(69, Property.class);
		System.out.println(queriedPesho);
	}
}

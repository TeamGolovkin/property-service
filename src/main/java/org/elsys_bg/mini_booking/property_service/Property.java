package org.elsys_bg.mini_booking.property_service;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table
public class Property {

	@PrimaryKey private int id;
	// private int id;
	private String description;

	public Property(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return String.format(
			"{ @type = %1$s, id = %2$s, name = %3$s }",
			getClass().getName(), getId(), getDescription()
		);
	}
}

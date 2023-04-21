package org.elsys_bg.mini_booking.property_service;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


@Table(value = "property_of_user")
public class PropertyOfUser {

    @PrimaryKeyColumn(
		name = "user_id",
        ordinal = 0,
        type = PrimaryKeyType.PARTITIONED
	) private int userId;

    @PrimaryKeyColumn(
		name = "property_id",
        ordinal = 0,
        type = PrimaryKeyType.PARTITIONED
	) private int propertyId;

	@Column(value = "property_title")
	private String propertyTitle;

	@Column(value = "property_title")
	private String propertyDescription;
	// private double propertyPrice;


	public PropertyOfUser(int userId,
						  int propertyId,
						  String propertyTitle,
						  String propertyDescription
						//   double propertyPrice
						  ) {
		this.userId = userId;
		this.propertyId = propertyId;
		this.propertyTitle = propertyTitle;
		this.propertyDescription = propertyDescription;
		// this.propertyPrice = propertyPrice;
	}

	public int getUserId() {
		return userId;
	}


	public int getPropertyId() {
		return propertyId;
	}


	public String getPropertyTitle() {
		return propertyTitle;
	}


	public String getPropertyDescription() {
		return propertyDescription;
	}


	// public double getPropertyPrice() {
	// 	return propertyPrice;
	// }

	@Override
	public String toString() {
		return "PropertyOfUser [userId=" + userId + ", propertyId=" + propertyId + ", propertyTitle=" + propertyTitle
				+ ", propertyDescription=" + propertyDescription + "]";
	}
}

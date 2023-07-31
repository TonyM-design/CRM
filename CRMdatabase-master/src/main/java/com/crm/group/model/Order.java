package com.crm.group.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "type_presta")
	private String typePresta;

	@Column(name = "designation")
	private String designation;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@Column(name = "nb_days")
	private Integer nbDays;

	@Column(name = "unit_price")
	private Integer unitPrice;

	@Column(name = "state")
	@Enumerated(EnumType.ORDINAL)
	private StatusOrder state;

	@Override
	public String toString() {
		return "Order [typePresta=" + typePresta + ", designation=" + designation + ", client=" + client + ", nbDays="
				+ nbDays + ", unitPrice=" + unitPrice + ", state=" + state + "]";
	}

	public Order(String typePresta, String designation, Client client, Integer nbDays, Integer unitPrice,
			StatusOrder state) {
		this.typePresta = typePresta;
		this.designation = designation;
		this.client = client;
		this.nbDays = nbDays;
		this.unitPrice = unitPrice;
		this.state = state;
	}

	public Order() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypePresta() {
		return typePresta;
	}

	public void setTypePresta(String typePresta) {
		this.typePresta = typePresta;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Integer getNbDays() {
		return nbDays;
	}

	public void setNbDays(Integer nbDays) {
		this.nbDays = nbDays;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public StatusOrder getState() {
		return state;
	}

	public void setState(StatusOrder state) {
		this.state = state;
	}

}

package com.team2.inventory.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private String name;
	private String brand;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dom;
	private String colour;
	@Column(nullable = false)
	private double oriPrice;
	private double wholesalePrice; // lower price
	private double retailPrice; // highest price
	private double partnerPrice; // 2nd highest
	private String description;
	private String dimension;
	private String category;
	public Product() {
		super();
	}

	public Product(String name, String brand, LocalDate dom, String colour, double oriPrice, double wholesalePrice,
			double retailPrice, double partnerPrice, String description, String dimension, String category) {
		super();
		this.name = name;
		this.brand = brand;
		this.dom = dom;
		this.colour = colour;
		this.oriPrice = oriPrice;
		this.wholesalePrice = wholesalePrice;
		this.retailPrice = retailPrice;
		this.partnerPrice = partnerPrice;
		this.description = description;
		this.dimension = dimension;
		this.category = category;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public LocalDate getDom() {
		return dom;
	}

	public void setDom(LocalDate dom) {
		this.dom = dom;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public double getOriPrice() {
		return oriPrice;
	}

	public void setOriPrice(double oriPrice) {
		this.oriPrice = oriPrice;
	}

	public double getWholesalePrice() {
		return wholesalePrice;
	}

	public void setWholesalePrice(double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public double getPartnerPrice() {
		return partnerPrice;
	}

	public void setPartnerPrice(double partnerPrice) {
		this.partnerPrice = partnerPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double CalculatePrice(int OrdQty, double oriPrice) {
		return Math.round(OrdQty * oriPrice * 100.0) / 100.0;
	}
}
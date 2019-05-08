package com.coda.springboot;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class product {

    @Id
    public ObjectId _id;
	public String name;
    public String category;
    public String description;
    
    public String get_id() {
		return _id.toHexString();
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}

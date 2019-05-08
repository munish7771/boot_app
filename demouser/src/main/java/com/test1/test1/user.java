package com.test1.test1;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class user {
    @Id
    public ObjectId _id;

    public String name;
    public String phone;
    public String place;


    public user() {
    }

    public user(ObjectId _id, String name, String phone, String place) {
        this._id = _id;
        this.name = name;
        this.phone = phone;
        this.place = place;


    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }


}

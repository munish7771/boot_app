package com.coda.springboot.models;

// to-do later
// import org.springframework.boot.*;
import org.springframework.data.annotation.Id;
// import org.bson.types.Object_id;
import org.bson.types.ObjectId;

public class user {
    @Id
    public ObjectId _id;
    public String name;
    public String userid;
    public String password;

      // ObjectId needs to be converted to string
    public String get_id() { return _id.toHexString(); }
    public void set_id(ObjectId _id) { this._id = _id; }
  
    public String getname() { return name; }
    public void setname(String name) { this.name = name; }
  
    public String getuserid() { return userid; }
    public void setuserid(String userid) { this.userid = userid; }
  
    public String getpassword() { return password; }
    public void setpassword(String password) { this.password = password; }

    public user(ObjectId _id, String name, String userid, String password){
        this._id = _id;
        this.name = name;
        this.userid = userid;
        this.password = password;
    }
}
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';import { BehaviorSubject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AdminService {
  baseUrl='http://localhost:9007/user'
  constructor(public http:HttpClient) { }
  private userSource = new BehaviorSubject('list');
  currentUserList = this.userSource.asObservable();

  listAllUser() {
    return this.http.get(this.baseUrl+'/');
  }

  addUser(name, phone,place) {
    const user = {
      name: name,
      phone: phone,
      place: place
    };
    return this.http.post(`${this.baseUrl}/single`, user);
  }

editUser(name,phone,place,id){
  const user = {
    name: name,
    phone: phone,
    place: place

  };
  return this.http.put(this.baseUrl+'/'+id, user);

}
deleteUser(id){
  return this.http.delete(this.baseUrl+'/'+id);
}

}

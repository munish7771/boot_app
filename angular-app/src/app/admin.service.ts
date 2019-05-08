import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';import { BehaviorSubject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AdminService {
  baseUrl='http://localhost:8080/users'
  constructor(public http:HttpClient) { }
  private userSource = new BehaviorSubject('list');
  currentUserList = this.userSource.asObservable();

  listAllUser() {
    return this.http.get(this.baseUrl+'/');
  }

  addUser(name, userid,password) {
    const user = {
      name: name,
      userid: userid,
      password: password
    };
    return this.http.post(`${this.baseUrl}/`, user);
  }

editUser(name,userid,password,id){
  const user = {
    name: name,
    userid: userid,
    password: password

  };
  return this.http.put(this.baseUrl+'/'+id, user);

}
deleteUser(id){
  return this.http.delete(this.baseUrl+'/'+id);
}

}

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

    addUser(name, username, password) {
      const user = {
        name: name,
        userid: username,
        password: password
      };
      return this.http.post(`${this.baseUrl}/`, user);
    }
  
}

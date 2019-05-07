import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';import { BehaviorSubject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AdminService {
  baseUrl='http://localhost:9006/user'
  constructor(public http:HttpClient) { }
  private userSource = new BehaviorSubject('list');
  currentUserList = this.userSource.asObservable();


    listAllUser() {
      return this.http.get(this.baseUrl+'/');
    }

    addUser(name, phone) {
      const user = {
        name: name,
        phone: phone
      };
      return this.http.post(`${this.baseUrl}/single`, user);
    }
  
}

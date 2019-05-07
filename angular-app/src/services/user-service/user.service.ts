import { Injectable } from '@angular/core';
import { Iuser } from 'src/interfaces/user-interface';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  users: Iuser[];
  constructor() { }

  get_users(){
    this.users = [
      {"name":"munish sharma","username":"munish@123"},
      {"name":"jithen","username":"jithen123"}
    ]
    return this.users;
  }
}

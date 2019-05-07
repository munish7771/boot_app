import { Injectable } from '@angular/core';
import { Iuser } from 'src/interfaces/user-interface';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  users: Iuser[];
  constructor(private http: HttpClient) { }

  //get_users(){
  //   this.users = [
  //     {"name":"munish sharma","username":"munish@123"},
  //     {"name":"jithen","username":"jithen123"}
  //   ]
  //   return this.users;
  // }
  getusers(): Observable<Iuser[]>{
      let tempvar = this.http.get<Iuser[]>('http://localhost:8080/users/');
      console.log(tempvar)
      return tempvar;
  }
}

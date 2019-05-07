import { Component, OnInit } from '@angular/core';
import { Iuser } from 'src/interfaces/user-interface';
import { UserService } from 'src/services/user-service/user.service';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users: Iuser[]
  constructor(private _userservice:UserService) { }

  ngOnInit() {
    // this.users = this._userservice.getusers();
    this.getusers();
  }
  getusers(){
    this._userservice.getusers().subscribe(
      responseProductData => {
        this.users = responseProductData;
        // todo- flag later
      }
    )
  }
}

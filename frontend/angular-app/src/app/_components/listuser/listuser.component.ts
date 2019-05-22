import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { UserService } from 'src/app/_services/user.service';
import { InsertUserComponent } from 'src/app/_components/insert-user/insert-user.component';
import { EditUserComponent } from 'src/app/_components/edit-user/edit-user.component';
import { Register } from 'src/app/_models/register';
import { User } from 'src/app/_models/user';

@Component({
  selector: 'app-listuser',
  templateUrl: './listuser.component.html'
})
export class ListuserComponent implements OnInit {
register: Register;
_user: User;
userlist:any;
name:string;
username:string;
password:string;
phoneno:string;
gender:string;
  constructor(public user: UserService,public dialog: MatDialog) { }
  ngOnInit() {
    if (this.isAdmin()){
this.getUserList()
    }else{
      this.userlist = [];
      this._user = JSON.parse(localStorage.getItem('currentUser'));
      console.log(this._user);
      this.userlist.push(this._user);
      console.log(this.userlist);
    }
this.register = new Register();
console.log(localStorage.getItem)
  }
  getUserList(){

    this.user.getAll().subscribe((data)=>{
      console.log(data);
      this.userlist=data;
    })
  }
  isAdmin(){
    return localStorage.getItem('role') == '1';
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(InsertUserComponent, {
      width: '500px',
     data: {name: this.name, username: this.username, phoneno: this.phoneno, gender: this.gender, password: this.password}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      if(result != undefined){
      this.register.name = result.name;
      this.register.username = result.username;
      this.register.phonenumber = result.phoneno;
      if(result.gender != undefined){
      this.register.gender = result.gender[0];
      }
      this.register.password = result.password;
      this.register.role = ["user"];

      this.user.register(this.register).subscribe(() => {
        this.getUserList(),
        err => console.log("something went wrong")
      })
    }
    });
  }

  openDialogEdit(u:User): void {
    const dialogRef = this.dialog.open(EditUserComponent, {
      width: '500px',
     data: u
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      if(result != undefined){
        u.name = result.name;
        u.username = result.username;
        u.phoneno = result.phoneno;
      this.user.updateUser(u).subscribe(() => {
        console.log("edited user");
        this.getUserList();
      })
    }
    });
  }

  editUser(u: User){
console.log(u);
this.openDialogEdit(u)
  }
  deleteUser(u: User){
    this.user.deleteUser(u.username).subscribe(()=> {
      console.log("user deleted")
      this.getUserList()
    })
  }

}
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { UserService } from 'src/app/_services/user.service';

@Component({
  selector: 'app-listuser',
  templateUrl: './listuser.component.html'
})
export class ListuserComponent implements OnInit {
userlist:any;
name:string;
userid:string;
password:string;
  constructor(public user: UserService,public dialog: MatDialog) { }

  ngOnInit() {
this.getUserList()
  }

  getUserList(){
    this.user.getAll().subscribe((data)=>{
      console.log(data);
      this.userlist=data;
    })
  }

  // openDialog(): void {
  //   const dialogRef = this.dialog.open(InsertComponent, {
  //     width: '500px',
  //    data: {name: this.name, userid: this.userid}
  //   });

  //   dialogRef.afterClosed().subscribe(result => {
  //     console.log('The dialog was closed');
  //     console.log(result);
  //     if(result != undefined){
  //     this.admin.addUser(result.name,result.userid,result.password).subscribe(() => {
  //       console.log("added user");
  //       this.getUserList()
  //     })
  //   }
  //   });
  // }

  // openDialogEdit(user): void {
  //   const dialogRef = this.dialog.open(EditComponent, {
  //     width: '500px',
  //    data: user
  //   });

  //   dialogRef.afterClosed().subscribe(result => {
  //     console.log('The dialog was closed');
  //     console.log(result);
  //     if(result != undefined){
  //     this.admin.editUser(result.name,result.userid,result.password,result._id).subscribe(() => {
  //       console.log("edited user");
  //       this.getUserList()
        
  //     })
  //   }
  //   });
  // }

//   editUser(user){
// console.log(user);
// this.openDialogEdit(user)


//   }
//   deleteUser(user){
//     this.admin.deleteUser(user._id).subscribe(()=> {
//       console.log("user deleted")
//       this.getUserList()
      

      
//     })
//   }

}
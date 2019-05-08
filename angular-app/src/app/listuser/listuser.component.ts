import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { MatDialog } from '@angular/material/dialog';
import { InsertComponent } from '../insert/insert.component';
import { EditComponent } from '../edit/edit.component';

@Component({
  selector: 'app-listuser',
  templateUrl: './listuser.component.html',
  styleUrls: ['./listuser.component.scss']
})
export class ListuserComponent implements OnInit {
userlist:any;
name:string;
phone:string;
  constructor(public admin: AdminService,public dialog: MatDialog) { }

  ngOnInit() {
this.getUserList()
  }

  getUserList(){
    this.admin.listAllUser().subscribe((data)=>{
      console.log(data);
      this.userlist=data;
      
    })
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(InsertComponent, {
      width: '500px',
     data: {name: this.name, phone: this.phone}

    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      if(result){
        this.admin.addUser(result.name,result.phone,result.place).subscribe(() => {
          console.log("added user");
          this.getUserList()
          
        })
      }

    });
  }

  openDialogEdit(user): void {
    const dialogRef = this.dialog.open(EditComponent, {
      width: '500px',
     data: user
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      if (result){
        this.admin.editUser(result.name,result.phone,result.place,result._id).subscribe(() => {
          console.log("edited user");
          this.getUserList()
          
        })
      }
   

    });
  }


  editUser(user){
console.log(user);
this.openDialogEdit(user)


  }
  deleteUser(user){
    this.admin.deleteUser(user._id).subscribe(()=> {
      console.log("user deleted")
      this.getUserList()
      

      
    })
  }

}

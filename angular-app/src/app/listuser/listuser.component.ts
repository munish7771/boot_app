import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { MatDialog } from '@angular/material/dialog';
import { InsertComponent } from '../insert/insert.component';

@Component({
  selector: 'app-listuser',
  templateUrl: './listuser.component.html',
  styleUrls: ['./listuser.component.scss']
})
export class ListuserComponent implements OnInit {
userlist:any;
name:string;
userid:string;
password:string;
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
     data: {name: this.name, userid: this.userid, password: this.password}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      this.admin.addUser(result.name,result.userid,result.password).subscribe(() => {
        console.log("added user");
        this.getUserList()
      })
    });
  }

}

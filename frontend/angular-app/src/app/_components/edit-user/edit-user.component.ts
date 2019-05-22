import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { InsertUserComponent, DialogData } from 'src/app/_components/insert-user/insert-user.component';
@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {
  userdata:any;
  editForm: FormGroup;
  constructor(private fb: FormBuilder, private router: Router,
    public dialogRef: MatDialogRef<EditUserComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {
      this.userdata=data
      this.editForm = this.fb.group({
        username: ['', Validators.required],
        phoneNo: ['', Validators.required],
        name:''
      });
 
  }
  ngOnInit() {
  }
  editUser(){

  }

}

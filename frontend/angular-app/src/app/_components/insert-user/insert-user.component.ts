import { Component, OnInit, Inject } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

export interface DialogData {
  name: string;
  username: string;
  phoneno: string;
  gender: string;
  password: string;
}
@Component({
  selector: 'app-insert-user',
  templateUrl: './insert-user.component.html',
  styleUrls: ['./insert-user.component.css']
})
export class InsertUserComponent implements OnInit {
  genders: string[] = ['male','female'];
  createForm: FormGroup;
  constructor(private fb: FormBuilder, private router: Router,
    public dialogRef: MatDialogRef<InsertUserComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {
    this.createForm = this.fb.group({
      name: ['', Validators.required],
      username: '',
      password:'',
      phoneno:'',
      gender:''
    });
  }
  ngOnInit() {
  }
  random(){}

}

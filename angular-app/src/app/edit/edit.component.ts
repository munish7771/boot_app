import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { InsertComponent, DialogData } from '../insert/insert.component';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.scss']
})
export class EditComponent implements OnInit {

  userdata:any;
  editForm: FormGroup;
  constructor(private fb: FormBuilder, private router: Router,
    public dialogRef: MatDialogRef<InsertComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {
      this.userdata=data
      this.editForm = this.fb.group({
        name: ['', Validators.required],
        phone: '',
        place:''
      });
 
  }

  ngOnInit() {
  
    
  }

  editUser(){

  }

}

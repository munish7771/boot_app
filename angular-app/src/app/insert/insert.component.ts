import { Component, OnInit, Inject } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

export interface DialogData {
  name: string;
  userid: string;
  password: string;
}
@Component({
  selector: 'app-insert',
  templateUrl: './insert.component.html',
  styleUrls: ['./insert.component.scss']
})
export class InsertComponent implements OnInit {
  createForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router,
    public dialogRef: MatDialogRef<InsertComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {
    this.createForm = this.fb.group({
      name: ['', Validators.required],
      userid: '',
      password: ['', Validators.required]
    });
  }

  ngOnInit() {
  }

}

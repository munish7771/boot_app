import { Component, OnInit, Inject } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

export interface DialogData {
  name: string;
  category: string;
  description: string;
}
@Component({
  selector: 'app-insert-product',
  templateUrl: './insert-product.component.html',
  styleUrls: ['./insert-product.component.css']
})
export class InsertProductComponent implements OnInit {
  createForm:FormGroup
  constructor(private fb: FormBuilder, private router: Router,
    public dialogRef: MatDialogRef<InsertProductComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {
    this.createForm = this.fb.group({
      name: ['', Validators.required],
      category: '',
      description:''
    });
  }
  ngOnInit() {
  }
  addProduct(name){
    // do nothing
  }

}
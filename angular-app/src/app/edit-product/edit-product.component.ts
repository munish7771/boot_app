import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { InsertProductComponent, DialogData } from '../insert-product/insert-product.component';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.scss']
})
export class EditProductComponent implements OnInit {

  userdata:any;
  editForm: FormGroup;
  constructor(private fb: FormBuilder, private router: Router,
    public dialogRef: MatDialogRef<InsertProductComponent>,
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
  editProduct(product){

  }
}

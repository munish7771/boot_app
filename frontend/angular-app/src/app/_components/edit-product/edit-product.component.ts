import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { InsertProductComponent, DialogData } from 'src/app/_components/insert-product/insert-product.component';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {
  productdata:any;
  editForm: FormGroup;
  constructor(private fb: FormBuilder, private router: Router,
    public dialogRef: MatDialogRef<EditProductComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData) {
      this.productdata=data
      console.log(this.productdata)
      this.editForm = this.fb.group({
        name: ['', Validators.required],
        category: '',
        description:''
      });
 
  }
  ngOnInit() {
  }
  editProduct(product){
    // do nothing - to avoid error
  }
}

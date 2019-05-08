import { Component, OnInit } from '@angular/core';
import {ProductService} from '../product.service';
import { MatDialog } from '@angular/material';
import { InsertProductComponent } from '../insert-product/insert-product.component';
import {EditProductComponent} from '../edit-product/edit-product.component'
@Component({
  selector: 'app-listproduct',
  templateUrl: './listproduct.component.html',
  styleUrls: ['./listproduct.component.scss']
})
export class ListproductComponent implements OnInit {
  productlist: any
  name: string
  category: string
  description: string
  constructor(public product: ProductService,public dialog: MatDialog) { }

  ngOnInit() {
    this.getProductList();
  }

  getProductList(){
    // subscribe to service layer
    this.product.listAllProduct().subscribe((data)=>{
      console.log(data);
      this.productlist=data;
      
    })
  }
  openDialog(): void {
    const dialogRef = this.dialog.open(InsertProductComponent, {
      width: '500px',
     data: {name: this.name, category: this.category}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      if(result != undefined){
      this.product.addProduct(result.name,result.category,result.description).subscribe(() => {
        console.log("added product");
        this.getProductList()
      })
    }
    });
  }

  openDialogEdit(user): void {
    const dialogRef = this.dialog.open(EditProductComponent, {
      width: '500px',
     data: user
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      if(result != undefined){
      this.product.editProduct(result.name,result.category,result.description,result._id).subscribe(() => {
        console.log("edited product");
        this.getProductList()  
      })
    }

    });
  }

  deleteProduct(product){
    this.product.deleteProduct(product._id).subscribe(()=> {
      console.log("product deleted")
      this.getProductList()
    })
  }

  editProduct(product){
    console.log(product)
    this.openDialogEdit(product)
  }

}

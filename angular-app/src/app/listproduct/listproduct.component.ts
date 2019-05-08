import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { InsertpComponent } from '../insertp/insertp.component';
import { MatDialog } from '@angular/material/dialog';
import { EditpComponent } from '../editp/editp.component';

@Component({
  selector: 'app-listproduct',
  templateUrl: './listproduct.component.html',
  styleUrls: ['./listproduct.component.scss']
})
export class ListproductComponent implements OnInit {
name: String;
category:String;
  constructor(public product: ProductService,public dialog: MatDialog) { }
  productlist:any;
  ngOnInit() {
    this.getProductList()
  }

  getProductList(){
    this.product.listAllProducts().subscribe((data)=>{
      console.log(data);
      this.productlist=data;
      
      
    })
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(InsertpComponent, {
      width: '500px',
     data: {name: this.name, category: this.category}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      if (result){
        this.product.addproduct(result.name,result.category,result.description).subscribe(() => {
          console.log("added product");
          this.getProductList()
          
        })
      }
   

    });
  }

  openDialogEdit(product): void {
    const dialogRef = this.dialog.open(EditpComponent, {
      width: '500px',
     data: product
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      if (result){
        this.product.editProduct(result.name,result.category,result.description,result._id).subscribe(() => {
          console.log("edited product");
          this.getProductList()
          
        })
      }
    
  

    });
  }

  deleteProduct(product){
    this.product.deleteUser(product._id).subscribe(()=> {
      console.log("user deleted")
      this.getProductList()
      

      
    })
  }

}

import { Component, OnInit } from '@angular/core';
import { UserService } from '../../_services/user.service';
import { MatDialog } from '@angular/material/dialog';
import { InsertProductComponent} from 'src/app/_components/insert-product/insert-product.component'
import { ProductService } from 'src/app/_services/product.service';
import { Product } from 'src/app/_models/product';
import { EditProductComponent } from '../edit-product/edit-product.component';

@Component({
  selector: 'app-listproduct',
  templateUrl: './listproduct.component.html',
  styleUrls: ['./listproduct.component.css']
})
export class ListproductComponent implements OnInit {
  _product = new Product();
  productlist : any[]
  constructor(public user: UserService, public product: ProductService, public dialog: MatDialog) { }

  ngOnInit() {
    this.getProductList();
  }

  getProductList(){
    this.user.getProducts().subscribe((data) =>{
      console.log(data);
      this.productlist = data;
    })
  }
  isAdmin(){
    return localStorage.getItem('role') == '1';
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(InsertProductComponent, {
      width: '500px',
     data: {name: "", category: ""}
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      if(result != undefined){
      this._product.name = result.name;
      this._product.category = result.category;
      this._product.description = result.description;
      console.log(this._product)
      this.product.addProduct(this._product).subscribe(() => {
        console.log("added product");
      }, error => console.log(error))
      this.getProductList();
    }
    });
  }

  openDialogEdit(p: Product): void {
    const dialogRef = this.dialog.open(EditProductComponent, {
      width: '500px',
     data: p
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      console.log(result);
      if(result != undefined){
      this._product = result;
      console.log(this._product)
      this.product.updateProduct(result).subscribe(() => {
        console.log("edited user");
        this.getProductList();
      },
        error=> console.log(error))
    }
    });
  }

  editProduct(p: Product){
    console.log(p);
    this.openDialogEdit(p)
      }
      deleteProduct(p: Product){
        this.product.deleteProduct(p.id).subscribe(()=> {
          console.log("product deleted")
          this.getProductList();
        },
        error=> console.log(error)
        );
      }
}

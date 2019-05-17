import { Component, OnInit } from '@angular/core';
import { UserService } from '../../_services/user.service';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-listproduct',
  templateUrl: './listproduct.component.html',
  styleUrls: ['./listproduct.component.css']
})
export class ListproductComponent implements OnInit {
  productlist : any[]
  constructor(public user: UserService,public dialog: MatDialog) { }

  ngOnInit() {
    this.getProductList();
  }

  getProductList(){
    this.user.getProducts().subscribe((data) =>{
      console.log(data);
      this.productlist = data;
    })
  }
}

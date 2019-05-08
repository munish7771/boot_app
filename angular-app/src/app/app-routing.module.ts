import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListuserComponent } from './listuser/listuser.component';
import { HomeComponent } from './home/home.component';
import { InsertComponent } from './insert/insert.component';
import { EditComponent } from './edit/edit.component';
import { ListproductComponent } from './listproduct/listproduct.component';
import { InsertProductComponent } from './insert-product/insert-product.component';
import { EditProductComponent } from './edit-product/edit-product.component';


const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'insert',component:InsertComponent},
  {path:'edit',component:EditComponent},
  {path:'listproduct',component:ListproductComponent},
  {path:'insertproduct',component:InsertProductComponent},
  {path:'editproduct',component:EditProductComponent},
  {path:''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListuserComponent } from './listuser/listuser.component';
import { HomeComponent } from './home/home.component';
import { InsertComponent } from './insert/insert.component';
import { EditComponent } from './edit/edit.component';
import { InsertpComponent } from './insertp/insertp.component';
import { EditpComponent } from './editp/editp.component';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'insert',component:InsertComponent},
  {path:'edit',component:EditComponent},
  {path:'insertp',component:InsertpComponent},
  {path:'editp',component:EditpComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

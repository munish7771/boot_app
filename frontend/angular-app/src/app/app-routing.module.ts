import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './_guards/auth.guard';
import { InsertUserComponent} from './_components/insert-user/insert-user.component';
import { EditUserComponent } from './_components/edit-user/edit-user.component';
import { InsertProductComponent } from './_components/insert-product/insert-product.component';
import { EditProductComponent } from './_components/edit-product/edit-product.component';

const routes: Routes = [
{ path: '', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'insertuser', component: InsertUserComponent},
    { path: 'edituser', component: EditUserComponent},
    { path: 'insertproduct', component: InsertProductComponent},
    { path: 'editproduct', component: EditProductComponent},
    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routing = RouterModule.forRoot(routes);

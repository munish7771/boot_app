import { NgModule }      from '@angular/core';
import { CommonModule } from '@angular/common'; 
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule }    from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent }  from './app.component';
import { AppRoutingModule }        from './app-routing.module';
import { MatRadioModule } from '@angular/material';
import { AlertComponent } from './_components/alert/alert.component';
import { JwtInterceptor } from './_interceptors/jwt.interceptor';
import { ErrorInterceptor } from './_interceptors/error.interceptor';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './_components/material/material.module';
import { ListuserComponent } from './_components/listuser/listuser.component';
import { ListproductComponent } from './_components/listproduct/listproduct.component';
import { InsertUserComponent } from './_components/insert-user/insert-user.component';
import { EditUserComponent } from './_components/edit-user/edit-user.component';
import { InsertProductComponent } from './_components/insert-product/insert-product.component';
import { EditProductComponent } from './_components/edit-product/edit-product.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    AlertComponent,
    ListuserComponent,
    ListproductComponent,
    InsertUserComponent,
    EditUserComponent,
    InsertProductComponent,
    EditProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    MatRadioModule,
    CommonModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

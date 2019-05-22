
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AlertService } from '../_services/alert.service';
import { UserService } from '../_services/user.service';
import { AuthenticationService } from '../_services/authentication.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  genders:['Male','Female'];
  registerForm: FormGroup;
  loading = false;
  submitted = false;
  flag:Boolean

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private authenticationService: AuthenticationService,
    private userService: UserService,
    private alertService: AlertService
  ) { 
    if (this.authenticationService.currentUserValue) { 
      this.router.navigate(['/']);
  }
  }

  ngOnInit() {
    this.flag = true;
    this.registerForm = this.formBuilder.group({
      name: ['', Validators.required],
      phonenumber: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
      gender:['', Validators.required],
      role:''
  });
  }
  get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;
    console.log("on submit invoked")

    // stop here if form is invalid
    if (this.registerForm.invalid) {
        return;
    }
    this.loading = true;
    this.registerForm.value.role = ["user"]
    this.userService.register(this.registerForm.value)
        // .pipe(first())
        .subscribe(
            data => {
              console.log("success")
                this.alertService.success('Registration successful', true);
                this.router.navigate(['/login']);
            },
            error => {
              console.log(error);
              if(error == "OK"){
                this.flag = false;
              }else{
                this.alertService.error("something went wrong!");
                this.loading = false;
                this.flag = false;
              }
            }
            );
          if(this.flag == true){
            this.alertService.success('Registration successful', true);
            this.router.navigate(['/login']);
          }
}

}

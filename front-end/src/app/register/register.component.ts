import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { ValidationService } from '../services/validation.service';
import { MyUserLogin, MyUser } from '../shared/interfaces';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  errorMessage: string;
  usertype: string;
  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private authService: AuthService) {
    this.registerForm = this.formBuilder.group({
      // email:      ['', [ Validators.required, ValidationService.emailValidator ]],
      // password:   ['', [ Validators.required, ValidationService.passwordValidator ]]
      usertype: "admin",
      fullname: "",
      email: "",
      phone: "",
      password: "",
      confirmed: true
    });
  }

  ngOnInit() {

  }

  onSubmit(registerData) {
    this.authService.createUser(registerData).subscribe(
      (resp: MyUser) => {
        window.alert(`Hi ${resp.fullname}`);
        localStorage.setItem("myUser", JSON.stringify(resp));
      },
      (error) => {
        console.log(error);
      }
    )
    console.warn('Your data has been submitted', registerData);
    console.log(this.usertype);
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AuthService } from '../services/auth.service';
import { ValidationService } from '../services/validation.service';
import { MyUserLogin } from '../shared/interfaces';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})


export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  errorMessage: string;
  creds: MyUserLogin;

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private authService: AuthService) {
    this.loginForm = this.formBuilder.group({
      email:      ['', [ Validators.required, ValidationService.emailValidator ]],
      password:   ['', [ Validators.required, ValidationService.passwordValidator ]]
    });
  }

  ngOnInit() {

  }

  onSubmit(loginData) {
    // this.loginForm.reset();
    this.creds = loginData;
    let resp = this.authService.login(loginData);
    console.log("####");
    console.log(resp);
    console.log("####");
    console.warn('Your login credentials have been submitted', loginData);
  }
}

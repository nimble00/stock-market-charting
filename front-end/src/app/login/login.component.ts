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

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private authService: AuthService) {
    this.loginForm = this.formBuilder.group({
      email:      ['', [ Validators.required, ValidationService.emailValidator ]],
      password:   ['', [ Validators.required, ValidationService.passwordValidator ]]
      // email: "",
      // password: ""
    });
  }

  ngOnInit() {

  }

  onSubmit(loginData) {
    // IMPLEMENT AUTHENTICATION HERE!!!
    this.loginForm.reset();
    console.warn('Your order has been submitted', loginData);
  }
}

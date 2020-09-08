import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AuthService } from '../services/auth.service';
import { ValidationService } from '../services/validation.service';
import { MyUserLogin } from '../shared/interfaces';
import { Router } from '@angular/router';

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
      password: ""
    });
  }

  ngOnInit() {

  }

  onSubmit(registerData) {
    // IMPLEMENT AUTHENTICATION HERE!!!
    this.registerForm.reset();
    console.warn('Your order has been submitted', registerData);
    console.log(this.usertype);
  }

}

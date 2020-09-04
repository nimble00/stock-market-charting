import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { ValidationService } from '../services/validation.service';

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
              private authService: AuthService) { }

  ngOnInit() {
      this.buildForm();
  }

  buildForm() {
      this.loginForm = this.formBuilder.group({
          email:      ['', [ Validators.required, ValidationService.emailValidator ]],
          password:   ['', [ Validators.required, ValidationService.passwordValidator ]]
      });
  }

  submit({value} : {value: FormGroup}) {
  // submit({ value, valid }: { value: IUserLogin, valid: boolean }) {
      // this.authService.login(value)
      //     .subscribe((status: boolean) => {
      //         if (status) {
      //             this.growler.growl('Logged in', GrowlerMessageType.Info);
      //             if (this.authService.redirectUrl) {
      //                 const redirectUrl = this.authService.redirectUrl;
      //                 this.authService.redirectUrl = '';
      //                 this.router.navigate([redirectUrl]);
      //             } else {
      //                 this.router.navigate(['/customers']);
      //             }
      //         } else {
      //             const loginError = 'Unable to login';
      //             this.errorMessage = loginError;
      //             this.growler.growl(loginError, GrowlerMessageType.Danger);
      //         }
      //     },
      //     (err: any) => this.logger.log(err));
      console.log("you clicked on login");
  }

}

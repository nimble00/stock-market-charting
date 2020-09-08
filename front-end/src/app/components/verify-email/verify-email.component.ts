import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-verify-email',
  templateUrl: './verify-email.component.html',
  styleUrls: ['./verify-email.component.css']
})
export class VerifyEmailComponent implements OnInit {


  verifyForm: FormGroup;
  errorMessage: string;

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private authService: AuthService) {
    this.verifyForm = this.formBuilder.group({
      token: ""
    });
  }

  ngOnInit() {

  }

  onSubmit(verifyData) {
    // IMPLEMENT AUTHENTICATION HERE!!!
    this.verifyForm.reset();
    console.warn('Your order has been submitted', verifyData);
  }

}

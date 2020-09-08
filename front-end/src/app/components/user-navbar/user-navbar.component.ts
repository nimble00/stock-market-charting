import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';

import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-user-navbar',
  templateUrl: './user-navbar.component.html',
  styleUrls: ['./user-navbar.component.css']
})
export class UserNavbarComponent implements OnInit {

  isCollapsed: boolean;
  loginLogoutText = 'Login';
  sub: Subscription;

  constructor(private router: Router,
    private authservice: AuthService) { }

  ngOnInit(): void {

  }

  loginOrOut() {
    // const isAuthenticated = this.authservice.isAuthenticated;
    // if (isAuthenticated) {
    //     this.authservice.logout()
    //         .subscribe((status: boolean) => {
    //             this.setLoginLogoutText();
    //             this.growler.growl('Logged Out', GrowlerMessageType.Info);
    //             this.router.navigate(['/customers']);
    //             return;
    //         },
    //         (err: any) => this.logger.log(err));
    // }
    // this.redirectToLogin();
    console.log("login clicked!!!");
  }

  redirectToLogin() {
    this.router.navigate(['/login']);
  }

  setLoginLogoutText() {
    this.loginLogoutText = (this.authservice.isAuthenticated) ? 'Logout' : 'Login';
  }

}

import { Injectable } from '@angular/core';

import { MyUser } from "../shared/interfaces";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user: MyUser;
  isAuthenticated = false;
  redirectUrl: string;
  adminCredentials = {username:'admin', password:"batman" };
  constructor() { }

  login(credentials) {
    if (credentials.username=='admin' && credentials.password=='batman') {
      this.isAuthenticated = true;
      return true;
    }
  }

  getUser() {
    return this.user;
  }

}

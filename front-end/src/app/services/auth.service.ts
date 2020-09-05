import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

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
}

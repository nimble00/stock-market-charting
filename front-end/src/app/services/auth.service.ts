import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MyUser, MyUserLogin } from "../shared/interfaces";
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private baseUrl = 'http://localhost:8088/user-ws';
  loginReuest: MyUserLogin;

  user: MyUser;
  isAuthenticated = false;
  redirectUrl: string;
  constructor(private http: HttpClient, private router: Router) { }

  login(credentials: MyUserLogin) {
    this.http.post(`${this.baseUrl}/login`, credentials, {observe: 'response'}).subscribe(resp => {
      localStorage.setItem("myToken", JSON.stringify(resp.headers.get('myToken')));
      this.fetchUser(credentials.email).subscribe(
        (resp: MyUser) => {
          this.user = resp;
          localStorage.setItem("myUser", JSON.stringify(resp));
          this.router.navigate(["home"]);
          return this.getUser();
        },
        (error) => { return `${error} : try again! if you're new then click on Register button`; }
      );
    });
  }

  getUser() {
    return this.user;
  }

  fetchUser(mail: string) {
    return this.http.get(`${this.baseUrl}/users/email/${mail}`);
  }

  createUser(user: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/users/register`, user);
  }

  updateUser(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/users/update/${id}`, value);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/users/delete/${id}`, { responseType: 'text' });
  }

  getUsersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}

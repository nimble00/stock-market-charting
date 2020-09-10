import { Injectable } from '@angular/core';
import { Company } from "../shared/interfaces";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from "../services/auth.service";

@Injectable({
  providedIn: 'root'
})
export class StockmarketService {

  private baseUrl = 'http://192.168.1.100:8088/company-service/company/';

  constructor(private http: HttpClient, private auth: AuthService) { }

  getCompanies() {
    let tok = JSON.parse(localStorage.getItem("myToken"));
    console.log(tok);
    return this.http.get(`${this.baseUrl}all`, {headers: {"Authorization": tok}});
    // return this.http.get(`${this.baseUrl}all`);
  }

  deleteCompany(id: string) {
    return this.http.get(`${this.baseUrl}${id}`);
    // return "deleted successfully";
  }

  searchCompanies(ss: string) {
    return this.http.get(`${this.baseUrl}search/${ss}`);
  }

  updateCompany(company: Company, id: string) {
    return this.http.post(`${this.baseUrl}updateInfo/${id}`,company, {responseType:"json"});
  }

  addCompany(company: Company) {
    let tok = JSON.parse(localStorage.getItem("myToken"));
    console.log(tok);
    return this.http.post(`${this.baseUrl}addCompany`, company, {headers: {"Authorization": tok}});
    // return this.http.post(`${this.baseUrl}addCompany`,company);
  }
}

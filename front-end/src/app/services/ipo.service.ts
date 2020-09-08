import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IpoService {

  private baseUrl = 'http://localhost:8080/company-service/ipo/';

  constructor(private http: HttpClient) { }

  createIPO(ipo: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, ipo);
  }

  updateIPO(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteIPO(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getIPOList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
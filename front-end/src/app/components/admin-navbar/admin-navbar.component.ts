import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';

import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-admin-navbar',
  templateUrl: './admin-navbar.component.html',
  styleUrls: ['./admin-navbar.component.css']
})
export class AdminNavbarComponent implements OnInit {

  isCollapsed: boolean;
  loginLogoutText = 'Login';
  sub: Subscription;

  constructor(private router: Router,
    private authservice: AuthService) { }

  ngOnInit(): void {

  }
  showCompanies = true;
  showStockEx = true;
  showIPO = true;
  showUploader = true;
  showCharts = true;

  toggleCompanies() { this.showCompanies = !this.showCompanies; }
  toggleStockEx() { this.showStockEx = !this.showStockEx; }
  toggleIPO() { this.showIPO = !this.showIPO; }
  toggleUploader() { this.showUploader = !this.showUploader; }
  toggleCharts() { this.showCharts = !this.showCharts; }

}

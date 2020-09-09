import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { AdminNavbarComponent } from './components/admin-navbar/admin-navbar.component';
import { UserNavbarComponent } from './components/user-navbar/user-navbar.component';
import { ReactiveFormsModule } from "@angular/forms";
import { RegisterComponent } from './register/register.component';
import { TopbarComponent } from './topbar/topbar.component';
import { VerifyEmailComponent } from './components/verify-email/verify-email.component';
import { HomeComponent } from './components/home/home.component';
import { CompaniesComponent } from './components/companies/companies.component';
import { IPOComponent } from './components/ipo/ipo.component';
import { UploaderComponent } from './components/uploader/uploader.component';
import { StockExComponent } from './components/stock-ex/stock-ex.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ChartsComponent } from './components/charts/charts.component';

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    AdminComponent,
    LoginComponent,
    AdminNavbarComponent,
    UserNavbarComponent,
    RegisterComponent,
    TopbarComponent,
    VerifyEmailComponent,
    HomeComponent,
    CompaniesComponent,
    IPOComponent,
    UploaderComponent,
    StockExComponent,
    ChartsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [HttpClient, HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }

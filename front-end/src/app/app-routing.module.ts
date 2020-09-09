import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from "./register/register.component";

import { HomeComponent } from "./components/home/home.component";
import { VerifyEmailComponent } from "./components/verify-email/verify-email.component";
import { AddCompanyComponent } from './components/add-company/add-company.component';

const routes: Routes = [
  {path: "", component: LoginComponent},
  {path: "register", component: RegisterComponent},
  {path: "login", component: LoginComponent},
  {path: "home", component: HomeComponent},
  {path: "verify", component: VerifyEmailComponent},
  {path: "addCompany", component: AddCompanyComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

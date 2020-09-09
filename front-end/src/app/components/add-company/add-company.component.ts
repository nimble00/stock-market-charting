import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { MyUser, Company } from 'src/app/shared/interfaces';
import { StockmarketService } from 'src/app/services/stockmarket.service';

@Component({
  selector: 'app-add-company',
  templateUrl: './add-company.component.html',
  styleUrls: ['./add-company.component.css']
})
export class AddCompanyComponent implements OnInit {
  companyForm: FormGroup;
  errorMessage: string;
  usertype: string;
  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private marketService: StockmarketService) {
    this.companyForm = this.formBuilder.group({
      name: "",
      ceo: "",
      turnover: "",
      sector: "",
      briefWriteup: "",
      boardOfDirs: "",
      tickerList: "",
      stockExchangeList: ""
    });
  }

  ngOnInit() {

  }

  onSubmit(registerData) {
    this.marketService.addCompany(registerData).subscribe(
      (resp: Company) => {
        window.alert(`Hi, you added a new company : ${resp.name}`);
        this.router.navigate(["home"]);
      },
      (error) => {
        console.log("@@@ 1");
        console.log(error);
        console.log("@@@ 2");
        this.router.navigate(["home"]);
      }
    )
    console.warn('Your data has been submitted', registerData);
  }
}

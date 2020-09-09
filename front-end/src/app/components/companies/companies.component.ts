import { Component, OnInit, ComponentFactory } from '@angular/core';
import { StockmarketService } from "../../services/stockmarket.service";
import { Company } from "../../shared/interfaces";

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent implements OnInit {

  companies: any;
  editCompany : Company;


  constructor(private marketService: StockmarketService) {

  }

  ngOnInit() {
    this.getCompanies();
  }

  getCompanies(): void {
    this.marketService.getCompanies()
      .subscribe(companies => (this.companies = companies));
  }

  add(name: string): void {
    this.editCompany = undefined;
    name = name.trim();
    if (!name) {
      return;
    }

    // The server will generate the id for this new company
    const newCompany: Company = { name } as Company;
    this.marketService
      .addCompany(newCompany)
      .subscribe(company => this.companies.push(company));
  }

  delete(company: Company): void {
    this.companies = this.companies.filter(h => h !== company);
    this.marketService
      .deleteCompany(company.id)
      .subscribe();
    /*
    // oops ... subscribe() is missing so nothing happens
    this.marketService.deleteCompany(company.id);
    */
  }

  edit(company: Company) {
    this.editCompany = company;
  }

  search(searchTerm: string) {
    this.editCompany = undefined;
    if (searchTerm) {
      this.marketService
        .searchCompanies(searchTerm)
        .subscribe(companies => (this.companies = companies));
    }
  }

  update() {
    if (this.editCompany) {
      this.marketService
        .updateCompany(this.editCompany, this.editCompany.id)
        .subscribe((company: Company) => {
        // replace the company in the companies list with update from server
        const ix = company ? this.companies.findIndex(h => h.id === company.id) : -1;
        if (ix > -1) {
          this.companies[ix] = company;
        }
      });
      this.editCompany = undefined;
    }
  }

}

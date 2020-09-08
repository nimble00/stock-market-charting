import { Component, OnInit } from '@angular/core';

import { AuthService } from "../../services/auth.service";
import { MyUser } from "../../shared/interfaces";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  user: MyUser

  constructor(authService: AuthService) {
    this.user = authService.getUser();
  }

  ngOnInit(): void {
  }

}

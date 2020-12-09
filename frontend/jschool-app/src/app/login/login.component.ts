import {Component, OnInit} from '@angular/core';
import {SecurityService} from '../service/security/security.service';
import {CurrentUserService} from '../service/current-user/current-user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  isAuthenticated: boolean = false;
  login: string = '';
  password: string = '';

  constructor(
    private securityService: SecurityService,
    private currentUserService: CurrentUserService
  ) {
  }

  ngOnInit(): void {
    this.isAuthenticated = this.currentUserService.isAuthenticated();
  }

  onSubmit(login: string, password: string): void {
    this.securityService.login(login, password).subscribe(res => {
      console.log(res.token);
      this.currentUserService.setToken(res.token);
      this.isAuthenticated = true;
    });
  }

}

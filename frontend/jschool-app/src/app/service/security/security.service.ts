import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  constructor(
    private http: HttpClient
  ) {
  }

  login(login: string, password: string): Observable<LoginRes> {
    let body = {
      login,
      password
    };

    return this.http.post<LoginRes>('api/v1/security/login', body);
  }
}


export interface LoginRes {
  token: string;
}

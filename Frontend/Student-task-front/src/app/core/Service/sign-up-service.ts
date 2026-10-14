import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { inject, Injectable, Service } from '@angular/core';
import { SignUpRequste } from '../Model/Sign-up/sign-up-requste';

@Injectable({
  providedIn: 'root'
})
export class SignUpService {
    private BaseUrl = 'http://localhost:8080/api/v1/auth/register';
    private http = inject(HttpClient);
CreateAccount(data:any): Observable<SignUpRequste> {
return this.http.post<SignUpRequste>(this.BaseUrl,data)
  }
}

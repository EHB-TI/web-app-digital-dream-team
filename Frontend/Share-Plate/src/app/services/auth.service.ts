import { Injectable } from '@angular/core';
import { Subject, Subscriber } from 'rxjs';
import { User } from '../models/User';
import { Token } from '../models/Token'
import { ApiService } from './api.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  onUserChange: Subject<User | null> = new Subject<User | null>();
  user: User | null = null;
  token!: Token;
  
  constructor(private apiService:ApiService, private router:Router) { 

  }

  isUserLoggedIn(): boolean {
    return this.user != null;
  }

  login(username: string, password: string): void {
    var login: any = { username: username, password: password }
    this.apiService.getBearer(login).subscribe((token) => {
      this.token = token
      if (token) {
        window.sessionStorage.setItem('token', token.token);
        this.apiService.getAuthentication(token.token).subscribe((user) => {
          this.user = user;
          this.onUserChange.next(user);
        })
        console.log(this.token);
      }
    });
  }

  logout(): void {
    this.user = null;
    this.onUserChange.next(this.user);
  }

  getUserWithBearer(): void {
    const sessionToken: string | null = window.sessionStorage.getItem('token');
    if (sessionToken) {
      this.apiService.getAuthentication(sessionToken).subscribe((user) => {
        console.log(user)
        if (user) {
          this.user = user;
          this.onUserChange.next(user);
        }
      });
    }
  }
}

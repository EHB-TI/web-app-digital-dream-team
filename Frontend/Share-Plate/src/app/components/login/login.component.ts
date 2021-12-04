import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';
import { Token } from '../../models/Token';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { User } from '../../models/User'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user!: User | null;
  username!: string;
  password!: string;
  token!: Token;
  

  constructor(private apiService: ApiService, private router: Router, private authService:AuthService) { }

  ngOnInit(): void {
    this.user = this.authService.user;
    if (this.user) {
      this.router.navigate(['/']);
    }
    this.authService.onUserChange.subscribe(() => this.router.navigate(['/']))
  }

  onSubmit() {
    this.authService.login(this.username, this.password)
  }
}

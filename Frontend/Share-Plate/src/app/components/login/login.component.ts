import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';
import { Token } from '../../models/Token';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username!: string;
  password!: string;
  token!: Token;
  

  constructor(private apiService: ApiService, private router: Router, private authService:AuthService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.authService.onUserChange.subscribe(() => this.router.navigate(['/']))
    this.authService.login(this.username, this.password)
  }
}

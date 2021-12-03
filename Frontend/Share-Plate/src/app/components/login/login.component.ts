import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';
import { Token } from '../../models/Token';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username!: string;
  password!: string;
  token!: Token;
  

  constructor(private apiService: ApiService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    
    var login: any = { username: this.username, password: this.password }
    console.log(login);

    this.apiService.getBearer(login).subscribe((token) => {
      this.token = token
      if (token) {
        window.sessionStorage.setItem('token', token.token);
        console.log(this.token);
        this.router.navigate(['/']);
      }
    });
  }
}

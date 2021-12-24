import { Component, OnInit } from '@angular/core';
import { Token } from '../../models/Token';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { User } from '../../models/User'
import { FormControl, FormGroup, Validators } from '@angular/forms';

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
  alertMessage!: string;
  loginForm!: FormGroup;
  

  constructor(private router: Router, private authService:AuthService) { }

  ngOnInit(): void {
    this.user = this.authService.user;
    if (this.user) {
      this.router.navigate(['/']);
    }
    this.authService.onUserChange.subscribe(() => this.router.navigate(['/']))
    // this.loginForm = new FormGroup({
    //   username: new FormControl(this.username, [
    //     Validators.required,
    //     Validators.minLength(4)
    //   ]),
    //   password: new FormControl(this.password)
    // })
  }

  onSubmit() {
    // this.alertMessage = "";
    // if (!this.username) {
    //   this.alertMessage += 'Username cannot be empty!\n' ;
    // }
    // else if (this.username.length < 4)
    //   this.alertMessage += 'Username too short! (min: 4)\n'
    // if (!this.password) {
    //   this.alertMessage += 'Password cannot be empty!\n';
    // }
    // else if (this.password.length < 8) {
    //   this.alertMessage += 'Password too short! (min: 8)\n';
    // }
    // if (this.alertMessage.length > 0) {
    //   alert(this.alertMessage);
    //   return;
    // }
    this.authService.login(this.username, this.password)
  }
}

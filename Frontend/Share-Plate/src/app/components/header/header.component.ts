import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../models/User';
import { ApiService } from 'src/app/services/api.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  user!: User | null;
  
  constructor(private router:Router, private apiService:ApiService, private authService: AuthService) { }

  ngOnInit(): void {
    this.authService.onUserChange.subscribe((user) => this.user = user);
    this.authService.getUserWithBearer();
  }

  logOut(): void {
    this.authService.logout();
    window.sessionStorage.removeItem('token');
  }

  hasRoute(route:string){
    return this.router.url === route;
  }

}

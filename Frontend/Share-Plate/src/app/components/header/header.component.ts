import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../models/User';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  user!: User;
  loggedIn = false;
  constructor(private router:Router, private apiService:ApiService) { }

  ngOnInit(): void {
    this.apiService.getAuthentication().subscribe((user) => {
      this.user = user;
      if (user) {
        this.loggedIn = true;
      }
    })
  }

  hasRoute(route:string){
    return this.router.url === route;
  }

}

import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  user!: User | null

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    this.authService.onUserChange.subscribe((user) => this.user = user);
    this.user = this.authService.user;
    //this.authService.getUserWithBearer();
  }

}

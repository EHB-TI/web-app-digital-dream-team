import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User';
import { ApiService } from 'src/app/services/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  username!: string;
  name!: string;
  surname!: string;

  constructor(private apiService: ApiService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    if (!this.username) {
      alert('Username cannot be empty!');
      return;
    }

    const newUser: User = {
      username: this.username,
      firstname: this.name,
      lastname: this.surname
    }

    this.apiService.addUser(newUser).subscribe();
    console.log(newUser);

    this.router.navigate(['/']);
  }

}

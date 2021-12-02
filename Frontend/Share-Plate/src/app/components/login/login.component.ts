import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username!: string;
  password!: string;
  

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    
    var login: any = { username: this.username, password: this.password }
    console.log(login);

    var auth =  this.apiService.getBearer(login).subscribe();
    console.log(auth);
  }
}

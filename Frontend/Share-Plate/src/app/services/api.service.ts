import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Plate } from '../models/Plate'
import { User } from '../models/User'
import { stringify } from 'querystring';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})

export class ApiService {
  private apiUrl = 'http://localhost:5000';
  // private apiUrl = 'backend';

  constructor(private client: HttpClient) {
  }

  getUser(id: number): Observable<User> {
    const url = this.apiUrl + '/users/' + id;
    return this.client.get<User>(url);
  }

}

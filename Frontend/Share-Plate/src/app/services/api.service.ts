import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Plate } from '../models/Plate'
import { User } from '../models/User'
import { Token } from '../models/Token';
import { Pageable } from '../models/Pageable'


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
}



@Injectable({
  providedIn: 'root'
})

export class ApiService {
  //private apiUrl = 'http://localhost:8080/api/v1';
  private apiUrl = 'https://plates.azurewebsites.net/api/v1';
  plates: Plate[] = [];

  constructor(private client: HttpClient) {
  }
  
  makeHeaderWithToken(): HttpHeaders {
    const token = window.sessionStorage.getItem('token')
    var headers = new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + token
      })
    return headers
  }

  getUser(id: number): Observable<User> {
    const url = this.apiUrl + '/users/' + id;
    return this.client.get<User>(url);
  }

  //register user
  addUser(user: User): Observable<User> {
    const url = `${this.apiUrl}/auth/register`;
    return this.client.post<User>(url, user, httpOptions);
  }

  //get bearer token
  getBearer(login: {username: string, password: string}): Observable<Token> {
    const url = `${this.apiUrl}/auth/login`;
    return this.client.post<Token>(url, login, httpOptions);
  }

  getAuthentication(token: string): Observable<User> {
    const url = `${this.apiUrl}/auth/user`;
    var option = {
      headers: this.makeHeaderWithToken()
    }
    return this.client.get<User>(url, option)
  }

  // PLATE METHODS
  getPlates(): Observable<Pageable> {
    const url = `${this.apiUrl}/plates`;
    return this.client.get<Pageable>(url, httpOptions);
  }

  getPlate(id: number): Observable<Plate> {
    const url = this.apiUrl + '/plates/' + id;
    return this.client.get<Plate>(url);
  }

  deletePlate(plate: Plate): Observable<Plate> {
    const url = `${this.apiUrl}/plates/${plate.id}`;
    return this.client.delete<Plate>(url)
  }

  updatePlate(plate: Plate): Observable<Plate> {
    console.log(plate);
    const url = `${this.apiUrl}/plates/${plate.id}`;
    return this.client.put<Plate>(url, plate, httpOptions)
  }

  addPlate(plate: Plate): Observable<Plate> {
    console.log(plate)
    var option = {headers: this.makeHeaderWithToken()}
    return this.client.post<Plate>(this.apiUrl + '/plates/', plate, option)
  }
}

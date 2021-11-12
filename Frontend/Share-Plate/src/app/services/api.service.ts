import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Plate } from '../models/Plate'
import { User } from '../models/User'

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

  private plates: Plate[] = [];
  constructor(private client: HttpClient) {
  }

  getUser(id: number): Observable<User> {
    const url = this.apiUrl + '/users/' + id;
    return this.client.get<User>(url);
  }

  addUser(user: User): Observable<User> {
    const url = `${this.apiUrl}/users`;
    return this.client.post<User>(url, user, httpOptions);
  }

  // PLATE METHODS
  getPlates(): Observable<Plate[]> {
    const url = `${this.apiUrl}/plates`;
    return this.client.get<Plate[]>(url);
  }

  getPlate(id: number): Observable<Plate> {
    const url = this.apiUrl + '/plates/' + id;
    return this.client.get<Plate>(url);
  }

  deletePlate(plate: Plate): Observable<Plate> {
    const url = `${this.apiUrl}/plates/${plate.id}`;
    return this.client.delete<Plate>(url)
  }

  updatePlate(plate: Plate) : Observable<Plate> {
    const url = `${this.apiUrl}/plates/${plate.id}`;
    return this.client.put<Plate>(url, plate, httpOptions)
  }

  addPlate(plate: Plate):Observable<Plate> {
    return this.client.post<Plate>(this.apiUrl + '/plates/', plate, httpOptions)
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FilmService {

  constructor(private http: HttpClient) { }

  getGetCurrentFilmsUrl() {
    return "//localhost:4200/server/films/current"
  }

  getGetFutureFilmsUrl() {
    return "//localhost:4200/server/films/future"
  }

  getGetAllShowingsUrl() {
    return "//localhost:4200/server/showings"
  }

  getCurrentFilms(): Observable<any> {
    return this.http.get(this.getGetCurrentFilmsUrl());
  }

  getFutureFilms() : Observable<any> {
    return this.http.get(this.getGetFutureFilmsUrl());
  }

  getAllShowings(): Observable<any> {
    return this.http.get(this.getGetAllShowingsUrl());
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FilmService {

  constructor(private http: HttpClient) { }

  getGetAllFilmsUrl() {
    return "//localhost:4200/server/films"
  }

  getGetAllShowingsUrl() {
    return "//localhost:4200/server/showings"
  }

  getAllFilms(): Observable<any> {
    return this.http.get(this.getGetAllFilmsUrl());
  }

  getAllShowings(): Observable<any> {
    return this.http.get(this.getGetAllShowingsUrl());
  }
}

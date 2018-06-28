import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ScreenService {

  constructor(private http: HttpClient) { }

  getGetAllScreensUrl() {
    return "//localhost:4200/server/screens"
  }

  getAll(): Observable<any> {
    return this.http.get(this.getGetAllScreensUrl());
  }
}

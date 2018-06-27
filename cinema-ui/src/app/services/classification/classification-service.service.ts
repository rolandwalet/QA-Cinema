import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClassificationServiceService {

  constructor(private http: HttpClient) { }

  getGetAllClassificationsUrl() {
    return "//localhost:8080/classifications"
  }

  getAll(): Observable<any> {
    return this.http.get(this.getGetAllClassificationsUrl());
  }
}

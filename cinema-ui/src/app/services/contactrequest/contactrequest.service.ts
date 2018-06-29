import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ContactrequestService {

  constructor(private http: HttpClient) { }

  getPostResultURL() {
    return "//localhost:4200/server/classifications";
  }

  postForm(formData) {
    console.log("posting Data");
    console.log(this.http.post(this.getPostResultURL(), formData));
  }
}

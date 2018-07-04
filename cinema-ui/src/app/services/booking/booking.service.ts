import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private http: HttpClient) { }

  createBooking(booking) {
    console.log("create booking ran")
    return this.http.post('server/bookings', booking, httpOptions);
  }

  createTicket(ticket) {
    return this.http.post('server/tickets', ticket, httpOptions);
  }

  getTicketTypes() {
    return this.http.get('server/ticket_types')
  }

  getShowing(id: number) {
    return this.http.get('server/showings/' + id);
  }

}

import { Component, OnInit } from '@angular/core';
import { BookingService } from "../../services/booking/booking.service";
import { ActivatedRoute } from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {
  bookingForm: FormGroup;
  showing: {[k: string]: any} = {};
  booking: {[k: string]: any} = {};

  constructor(private bookingService: BookingService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getShowing(this.route.snapshot.params.showingId);
    this.getTicketTypes();
    this.bookingForm = new FormGroup({
      name: new FormControl('', Validators.required),
      adultQuantity: new FormControl(''),
      concessionQuantity: new FormControl(''),
      childQuantity: new FormControl('')
    });
  }

  getShowing(id: number) {
    this.bookingService.getShowing(id).subscribe(
      data => {
        this.showing = data;
      },
      err => console.log('err'),
      () => console.log('Showing loaded')
    );
  }

  getTicketTypes() {
    this.bookingService.getTicketTypes().subscribe(
      data => {
        this.ticketTypes = data;
      },
      err => console.log(err),
      () => console.log('Ticket Types loaded')
    );
  }

  createBooking(booking) {
    return this.bookingService.createBooking(booking).subscribe(
      data => {return true},
      err => console.log(err),
      () => console.log('Booking Successfully created')
    );
  }

  createTicket(ticket) {
    this.bookingService.createTicket(ticket).subscribe(
      data => {
        return true;
      },
      err => console.log(err),
      () => console.log('Ticket created')
    );
  }

  submitBooking(){
    console.log("showing id = "this.showing.id)
    this.booking.showingId = this.showing.id;
    this.bookingService.createBooking(this.booking).subscribe(
      response => console.log(response),
      err => console.log(err)
    );
  }

}

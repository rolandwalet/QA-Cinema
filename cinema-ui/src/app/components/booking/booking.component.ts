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
  public showing;
  public ticketTypes;
  public booking;

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
    if (this.bookingForm.controls.adultQuantity.value + this.bookingForm.controls.concessionQuantity.value + this.bookingForm.controls.childQuantity.value > 0 ) {
      console.log({showing: this.showing, customerName: this.bookingForm.controls.name.value});
      this.booking = this.createBooking({"showing": this.showing, "customerName": this.bookingForm.controls.name.value});
      console.log(this.booking);
      if (this.bookingForm.controls.adultQuantity.value>0) {
        this.createTicket({
          "ticketType": this.ticketTypes[0],
          "booking": this.booking,
          "quantity": this.bookingForm.controls.adultQuantity.value
        });
      }
      if (this.bookingForm.controls.concessionQuantity.value>0) {
        this.createTicket({
          "ticketType": this.ticketTypes[1],
          "booking": this.booking,
          "quantity": this.bookingForm.controls.concessionQuantity.value
        });
      }
      if (this.bookingForm.controls.childQuantity.value>0) {
        this.createTicket({
          "ticketType": this.ticketTypes[2],
          "booking": this.booking,
          "quantity": this.bookingForm.controls.childQuantity.value
        });
      }
    }
  }

}

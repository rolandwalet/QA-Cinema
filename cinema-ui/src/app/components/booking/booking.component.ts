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
    this.bookingService.createBooking(booking).subscribe(
      data => {
       return true;
      },
      err => console.log(err),
      () => console.log('Booking Successfully created')
    );
  }

  getBooking(id) {
    this.bookingService.getBooking(id).subscribe(
      data => {
        this.booking = data;
      },
      err => console.log(err),
      () => console.log('booking loaded')
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
    if (this.bookingForm.value.adultQuantity + this.bookingForm.value.concessionQuantity + this.bookingForm.value.childQuantity > 0 ) {
      this.booking = {"showing": this.showing,
                      "name": this.bookingForm.value.name};
      this.createBooking(this.booking);
      if (this.bookingForm.value.adultQuantity>0) {
        this.createTicket({
          "ticketType": this.ticketTypes[0],
          "booking": this.booking,
          "quantity": this.bookingForm.value.adultQuantity
        });
      }
      if (this.bookingForm.value.concessionQuantity>0) {
        this.createTicket({
          "ticketType": this.ticketTypes[0],
          "booking": this.booking,
          "quantity": this.bookingForm.value.concessionQuantity
        });
      }
      if (this.bookingForm.value.childQuantity>0) {
        this.createTicket({
          "ticketType": this.ticketTypes[0],
          "booking": this.booking,
          "quantity": this.bookingForm.value.childQuantity
        });
      }
    }
  }

}

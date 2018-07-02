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
  bookingState: boolean = true;

  constructor(private bookingService: BookingService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.bookingService.getShowing(this.route.snapshot.params.showingId).subscribe(
      data => {
        this.showing = data;
      },
      err => console.log('err'),
      () => console.log('Showing loaded')
    );
    this.booking.adultTickets = 0;
    this.booking.concessionTickets = 0;
    this.booking.childTickets = 0;
  }

  submitBooking(){
    if (this.booking.adultTickets + this.booking.concessionTickets + this.booking.childTickets <= 0) {
      window.alert("Booking must contain a ticket");
    }

    else if (this.booking.adultTickets + this.booking.concessionTickets + this.booking.childTickets > 10) {
      window.alert("Bookings cannot have more than 10 tickets");
    }

    else if (this.booking.customerName == null) {
      window.alert("Booking must have a name");
    }
    else {
      console.log("showing id = "this.showing.id)
      this.booking.showingId = this.showing.id;
      this.bookingService.createBooking(this.booking).subscribe(
        response => console.log(response),
        err => console.log(err)
      );
      this.bookingState = false;
    }

  }

}

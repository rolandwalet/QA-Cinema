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
    this.bookingService.getShowing(this.route.snapshot.params.showingId).subscribe(
      data => {
        this.showing = data;
      },
      err => console.log('err'),
      () => console.log('Showing loaded')
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

import { Component, OnInit } from '@angular/core';
import { BookingService } from "../../services/booking/booking.service";
import { ActivatedRoute } from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit, AfterViewChecked {
  bookingForm: FormGroup;
  showing: {[k: string]: any} = {};
  booking: {[k: string]: any} = {};
  bookingState: boolean = true;
  public didPaypalScriptLoad: boolean = false;
  public loading: boolean = true;

  public adultCost: number = 8.00;
  public concessionCost: number = 5.00;
  public childCost: number = 3.00;


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
      return false;
    }

    else if (this.booking.adultTickets + this.booking.concessionTickets + this.booking.childTickets > 10) {
      window.alert("Bookings cannot have more than 10 tickets");
      return false;
    }

    else if (this.booking.customerName == null) {
      window.alert("Booking must have a name");
      return false;
    }
    else {
      console.log("showing id = " + this.showing.id);
      this.booking.showingId = this.showing.id;
      this.bookingService.createBooking(this.booking).subscribe(
        response => console.log(response),
        err => console.log(err)
      );
      this.bookingState = false;
      return true;
      public paypalConfig: any = {
        env: 'sandbox',
        client: {
          sandbox: 'AcocL08o5-QeYbt49J4W0L1R-L7QStxs3D0NtohWpRoQ8rLPs1tRqAGEYqgimW1JyMlxWjF-IpMR162B',
          production: 'xxxxxxxxxx'
        },
        commit: true,
        payment: (data, actions) => {
          if(!this.submitBooking()) {
            return false;
          }
          else {
            return actions.payment.create({
              payment: {
                transactions: [
                  { amount: { total: (this.booking.adultTickets * this.adultCost) + (this.booking.concessionTickets * this.concessionCost) + (this.booking.childTickets * this.childCost), currency: 'GBP' } }
                ]
              }
            });
          }
        },
        onAuthorize: (data, actions) => {
          return actions.payment.execute().then((payment) => {
            window.alert('Thank you for your purchase!');
          });
        }
      };

      public ngAfterViewChecked(): void {
        if(!this.didPaypalScriptLoad) {
          this.loadPaypalScript().then(() => {
            paypal.Button.render(this.paypalConfig, '#paypal-button');
            this.loading = false;
          });
        }
      }

      public loadPaypalScript(): Promise<any> {
        this.didPaypalScriptLoad = true;
        return new Promise((resolve, reject) => {
          const scriptElement = document.createElement('script');
          scriptElement.src = 'https://www.paypalobjects.com/api/checkout.js';
          scriptElement.onload = resolve;
          document.body.appendChild(scriptElement);
        });
      }

    }

  }




}

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-opening-times',
  templateUrl: './opening-times.component.html',
  styleUrls: ['./opening-times.component.css']
})
export class OpeningTimesComponent implements OnInit {

  information: Array<any>;


  constructor() { }

  ngOnInit() {
    this.information = [{
      day: 'Monday',
      openingTime: '10:00',
      closingTime: '23:00',
    },
    {
      day: 'Tuesday',
      openingTime: '10:00',
      closingTime: '23:00',
    },
    {
      day: 'Wednesday',
      openingTime: '10:00',
      closingTime: '23:00',
    },
    {
      day: 'Thursday',
      openingTime: '10:00',
      closingTime: '23:00',
    },
    {
      day: 'Friday',
      openingTime: '10:00',
      closingTime: '01:00',
    },
    {
      day: 'Saturday',
      openingTime: '09:00',
      closingTime: '01:00',
    },
    {
      day: 'Sunday',
      openingTime: '11:00',
      closingTime: '21:00',
    }];
  }

}

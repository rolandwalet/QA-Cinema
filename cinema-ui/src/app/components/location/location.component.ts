import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.css']
})
export class LocationComponent implements OnInit {

  lat: number = 53.473922;
  lng: number = -2.286154;
  zoomLevel: number = 15;

  constructor() { }

  ngOnInit() {
  }

}

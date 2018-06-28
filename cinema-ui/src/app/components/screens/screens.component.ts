import { Component, OnInit } from '@angular/core';
import { ScreenService } from '../../services/screen/screen.service';

@Component({
  selector: 'app-screens',
  templateUrl: './screens.component.html',
  styleUrls: ['./screens.component.css']
})
export class ScreensComponent implements OnInit {

  screens: Array<any>;

  constructor( private screenService: ScreenService ) { }

  ngOnInit() {
    this.screenService.getAll().subscribe(data => {
      this.screens = data;
      console.log(data);
    });
  }

}

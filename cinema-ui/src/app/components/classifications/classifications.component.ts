import { Component, OnInit } from '@angular/core';
import { ClassificationServiceService } from '../../services/classification/classification-service.service';

@Component({
  selector: 'app-classifications',
  templateUrl: './classifications.component.html',
  styleUrls: ['./classifications.component.css']
})
export class ClassificationsComponent implements OnInit {

  classifications: Array<any>;

  constructor( private classificationService: ClassificationServiceService ) { }

  ngOnInit() {
    this.classificationService.getAll().subscribe(data => {
      this.classifications = data;
      console.log(data);
    });
  }

}

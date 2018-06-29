import { Component, OnInit } from '@angular/core';
import { ContactrequestService } from '../../services/contactrequest/contactrequest.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  formData: {[k: string]: any} = {};

  constructor(private contactrequestService : ContactrequestService) { }

  ngOnInit() {
  }

  formSubmit() {
    console.log("formSubmit hit " + this.formData.customerName + " " + this.formData.customerEmail + " " + this.formData.customerMessage);
    this.contactrequestService.postForm(this.formData);
  }

}

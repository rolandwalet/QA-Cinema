import { TestBed, inject } from '@angular/core/testing';

import { ContactrequestService } from './contactrequest.service';

describe('ContactrequestService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ContactrequestService]
    });
  });

  it('should be created', inject([ContactrequestService], (service: ContactrequestService) => {
    expect(service).toBeTruthy();
  }));
});

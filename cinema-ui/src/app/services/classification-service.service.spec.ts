import { TestBed, inject } from '@angular/core/testing';

import { ClassificationServiceService } from './classification-service.service';

describe('ClassificationServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ClassificationServiceService]
    });
  });

  it('should be created', inject([ClassificationServiceService], (service: ClassificationServiceService) => {
    expect(service).toBeTruthy();
  }));
});

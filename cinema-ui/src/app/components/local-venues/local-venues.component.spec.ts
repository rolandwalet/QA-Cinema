import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LocalVenuesComponent } from './local-venues.component';

describe('LocalVenuesComponent', () => {
  let component: LocalVenuesComponent;
  let fixture: ComponentFixture<LocalVenuesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LocalVenuesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LocalVenuesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

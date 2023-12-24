import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomefreelanceComponent } from './homefreelance.component';

describe('HomefreelanceComponent', () => {
  let component: HomefreelanceComponent;
  let fixture: ComponentFixture<HomefreelanceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomefreelanceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomefreelanceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

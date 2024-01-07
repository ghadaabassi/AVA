import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAvaeComponent } from './create-avae.component';

describe('CreateAvaeComponent', () => {
  let component: CreateAvaeComponent;
  let fixture: ComponentFixture<CreateAvaeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateAvaeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateAvaeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

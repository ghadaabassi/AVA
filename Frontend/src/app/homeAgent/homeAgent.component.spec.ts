import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeAgentComponent } from './homeAgent.component';

describe('HomeAgentComponent', () => {
  let component: HomeAgentComponent;
  let fixture: ComponentFixture<HomeAgentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeAgentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeAgentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

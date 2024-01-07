import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeAgentEtrangerComponent } from './home-agent-etranger.component';

describe('HomeAgentEtrangerComponent', () => {
  let component: HomeAgentEtrangerComponent;
  let fixture: ComponentFixture<HomeAgentEtrangerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeAgentEtrangerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeAgentEtrangerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

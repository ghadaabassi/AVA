import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupAgentEtrangerComponent } from './signup-agent-etranger.component';

describe('SignupAgentEtrangerComponent', () => {
  let component: SignupAgentEtrangerComponent;
  let fixture: ComponentFixture<SignupAgentEtrangerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SignupAgentEtrangerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SignupAgentEtrangerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

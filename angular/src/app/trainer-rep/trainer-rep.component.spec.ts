import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerRepComponent } from './trainer-rep.component';

describe('TrainerRepComponent', () => {
  let component: TrainerRepComponent;
  let fixture: ComponentFixture<TrainerRepComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrainerRepComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainerRepComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

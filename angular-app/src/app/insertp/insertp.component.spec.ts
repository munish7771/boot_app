import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertpComponent } from './insertp.component';

describe('InsertpComponent', () => {
  let component: InsertpComponent;
  let fixture: ComponentFixture<InsertpComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertpComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

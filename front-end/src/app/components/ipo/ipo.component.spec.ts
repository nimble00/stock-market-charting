import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IPOComponent } from './ipo.component';

describe('IPOComponent', () => {
  let component: IPOComponent;
  let fixture: ComponentFixture<IPOComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IPOComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IPOComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

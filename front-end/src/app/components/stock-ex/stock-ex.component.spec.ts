import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StockExComponent } from './stock-ex.component';

describe('StockExComponent', () => {
  let component: StockExComponent;
  let fixture: ComponentFixture<StockExComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StockExComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StockExComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

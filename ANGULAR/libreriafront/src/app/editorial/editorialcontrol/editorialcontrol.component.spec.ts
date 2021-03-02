import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditorialcontrolComponent } from './editorialcontrol.component';

describe('EditorialcontrolComponent', () => {
  let component: EditorialcontrolComponent;
  let fixture: ComponentFixture<EditorialcontrolComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditorialcontrolComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditorialcontrolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

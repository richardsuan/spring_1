import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrocontrolComponent } from './librocontrol.component';

describe('LibrocontrolComponent', () => {
  let component: LibrocontrolComponent;
  let fixture: ComponentFixture<LibrocontrolComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibrocontrolComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LibrocontrolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AutorcontrolComponent } from './autorcontrol.component';

describe('AutorcontrolComponent', () => {
  let component: AutorcontrolComponent;
  let fixture: ComponentFixture<AutorcontrolComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AutorcontrolComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AutorcontrolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

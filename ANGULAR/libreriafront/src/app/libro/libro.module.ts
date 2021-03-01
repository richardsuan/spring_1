import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LibrocontrolComponent } from './librocontrol/librocontrol.component';



@NgModule({
  declarations: [LibrocontrolComponent],
  imports: [
    CommonModule
  ],
  exports:[LibrocontrolComponent]
})
export class LibroModule { }

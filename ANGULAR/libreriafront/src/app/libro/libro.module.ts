import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LibrocontrolComponent } from './librocontrol/librocontrol.component';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [LibrocontrolComponent],
  imports: [
    CommonModule,
    BrowserModule,    
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule

  ],
  exports:[LibrocontrolComponent]
})
export class LibroModule { }

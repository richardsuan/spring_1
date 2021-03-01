import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { EditorialcontrolComponent } from './editorialcontrol/editorialcontrol.component';


@NgModule({
  declarations: [EditorialcontrolComponent],
  imports: [
    
    CommonModule,
    BrowserModule,    
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  exports:[EditorialcontrolComponent]
})
export class EditorialModule { }

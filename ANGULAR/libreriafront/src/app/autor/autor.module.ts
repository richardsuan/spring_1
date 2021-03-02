import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AutorcontrolComponent } from './autorcontrol/autorcontrol.component';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [AutorcontrolComponent],
  imports: [
    CommonModule,
    BrowserModule,    
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  exports:[AutorcontrolComponent]
})
export class AutorModule { }

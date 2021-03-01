import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { LibroModule } from './libro/libro.module';
import { EditorialModule } from './editorial/editorial.module';

//import { EditorialcontrolComponent } from './editorial/editorialcontrol/editorialcontrol.component';   EditorialcontrolComponent

@NgModule({
  declarations: [
    AppComponent,
  
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    LibroModule ,
    EditorialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

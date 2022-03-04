import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AutorcontrolComponent } from './autor/autorcontrol/autorcontrol.component';

import { InicioComponent } from './inicio/inicio/inicio.component';



const routes: Routes = [
  { path: '', component:InicioComponent},
  { path: 'autor', component:AutorcontrolComponent},
  
    { path: '**', component: InicioComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

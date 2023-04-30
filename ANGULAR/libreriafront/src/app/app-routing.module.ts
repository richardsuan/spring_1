import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AutorcontrolComponent } from './autor/autorcontrol/autorcontrol.component';
import { InicioComponent } from './inicio/inicio/inicio.component';
import { LibrocontrolComponent } from './libro/librocontrol/librocontrol.component';



const routes: Routes = [
  { path: '', component: InicioComponent},
  { path: 'autor', component: AutorcontrolComponent},
  { path: 'libro', component: LibrocontrolComponent},
  { path: '**', component: InicioComponent }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

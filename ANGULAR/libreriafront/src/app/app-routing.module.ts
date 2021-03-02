import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AutorcontrolComponent } from './autor/autorcontrol/autorcontrol.component';
import { EditorialcontrolComponent } from './editorial/editorialcontrol/editorialcontrol.component';
import { LibrocontrolComponent } from './libro/librocontrol/librocontrol.component';



const routes: Routes = [
  { path: '', component:AppComponent},
  { path: 'autor', component:AutorcontrolComponent},
  { path: 'editorial', component:EditorialcontrolComponent},
  { path: 'libro', component:LibrocontrolComponent},
  { path: '**', component: AppComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

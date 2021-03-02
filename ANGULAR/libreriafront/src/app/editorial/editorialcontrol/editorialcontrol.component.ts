import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EditorialService } from 'src/app/services/editorial/editorial.service';

@Component({
  selector: 'app-editorialcontrol',
  templateUrl: './editorialcontrol.component.html',
  styleUrls: ['./editorialcontrol.component.css']
})
export class EditorialcontrolComponent implements OnInit {

  constructor(
    public fb: FormBuilder,
    public editorialService:EditorialService
  ) { }
  editorialForm!:FormGroup;
  ngOnInit(): void {
    this.editorialForm = this.fb.group({
     
      nombre : ['', Validators.required],
      direccion_correspondencia : ['', Validators.required],
      telefono : ['', Validators.required],
      correo : ['', Validators.required],
      maximo_libros : ['', Validators.required]
     
    })
  }
  guardar(): void {
    this.editorialService.saveEditorial(this.editorialForm.value).subscribe(resp => {
    //this.autorForm.reset();
   // this.personas=this.personas.filter(persona=> resp.id!==persona.id);
    //this.personas.push(resp);
  },
    error => { console.error(error) }
  )
}
buscarEditorial(): void {
  this.editorialService.getsimilarEditorial(this.editorialForm.value).subscribe(resp => {
  //this.autorForm.reset();
 // this.personas=this.personas.filter(persona=> resp.id!==persona.id);
  //this.personas.push(resp);
},
  error => { console.error(error) }
)
}

}

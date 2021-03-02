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
  editoriales:any;
  editorial:any;
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
    this.editorialForm.reset();
    
    this.editorial.push(resp);
  },
    error => { console.error(error) }
  )
}
buscarEditorial(): void {
  //Headers:
  this.editorialService.getsimilarEditorial(this.editorialForm.get("nombre")?.value).subscribe(resp => {
  this.editorial=resp;
  
  console.log(resp);
},
  error => { console.error(error) }
)
}

}

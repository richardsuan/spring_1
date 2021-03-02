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
      id: ['', Validators.required],
      nombre : ['', Validators.required],
      direccion_correspondencia : ['', Validators.required],
      telefono : ['', Validators.required],
      correo : ['', Validators.required],
      maximo_libros : ['', Validators.required],
      libros_editados_int : ['', Validators.required],
      libros_editados: ['', Validators.required]
    })

    this.editorialService.getAllEditorial().subscribe (resp => {
      this.editoriales=resp;
    
      console.log(resp);
    },
      error => { console.error(error) }
    );

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
eliminar(editorial:any): void {
  this.editorialService.deleteEditorial(editorial).subscribe(resp => {
  console.log(resp);
  if(resp===true){
    this.editoriales.pop(editorial);
  }
},
  error => { console.error(error) }
)
}

}

import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LibroService } from 'src/app/services/libro/libro.service';

@Component({
  selector: 'app-librocontrol',
  templateUrl: './librocontrol.component.html',
  styleUrls: ['./librocontrol.component.css']
})
export class LibrocontrolComponent implements OnInit {
  //libro
  libro:any;
  libros:any;
  libroForm!: FormGroup;
  constructor(
    public fb: FormBuilder,
    public libroService:LibroService
  ) { }

  ngOnInit(): void {
    this.libroForm = this.fb.group({
      titulo : ['', Validators.required],      
      ano : ['', Validators.required],
      genero : ['', Validators.required],
      paginas : ['', Validators.required],
      my_autor : ['', Validators.required],
      my_editorial : ['', Validators.required],
    })
    this.libroService.getAllLibros().subscribe (resp => {
      this.libros=resp;
    
      console.log(resp);
    },
      error => { console.error(error) }
    );
  }
  guardar(): void {
      this.libroService.saveLibro(this.libroForm.value).subscribe(resp => {
      this.libroForm.reset();
     // this.personas=this.personas.filter(persona=> resp.id!==persona.id);
      this.libros.push(resp);
    },
      error => { console.error(error) }
    )
  }
  buscarLibro(): void {
    this.libroService.getsimilarLibro(this.libroForm.get("titulo")?.value).subscribe(resp => {
    this.libro=resp;
    console.log(this.libroForm.get("titulo")?.value);
    //this.autorForm.reset();
   // this.personas=this.personas.filter(persona=> resp.id!==persona.id);
    //this.personas.push(resp);
  },
    error => { console.error(error) }
  )
}

}

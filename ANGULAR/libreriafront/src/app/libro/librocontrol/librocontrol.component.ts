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
  }
  guardar(): void {
      this.libroService.saveLibro(this.libroForm.value).subscribe(resp => {
      //this.autorForm.reset();
     // this.personas=this.personas.filter(persona=> resp.id!==persona.id);
      //this.personas.push(resp);
    },
      error => { console.error(error) }
    )
  }
  buscarLibro(): void {
    this.libroService.getsimilarLibro(this.libroForm.value).subscribe(resp => {
    //this.autorForm.reset();
   // this.personas=this.personas.filter(persona=> resp.id!==persona.id);
    //this.personas.push(resp);
  },
    error => { console.error(error) }
  )
}

}

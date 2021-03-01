import { Component, OnInit } from '@angular/core';
import { AutorService } from 'src/app/services/autor/autor.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-librocontrol',
  templateUrl: './librocontrol.component.html',
  styleUrls: ['./librocontrol.component.css']
})
export class LibrocontrolComponent implements OnInit {
  autorForm!: FormGroup;
  constructor(
    public fb: FormBuilder,
    public autorService:AutorService
  ) { }

  ngOnInit(): void {
    this.autorForm = this.fb.group({
      d_identidad : ['', Validators.required],
      nombre : ['', Validators.required],
      fecha_nacimiento : ['', Validators.required],
      lugar_nacimiento : ['', Validators.required],
      correo : ['', Validators.required],
      pais : ['', Validators.required],
      libros_escritos : ['', Validators.required]
    })
  }
  guardar(): void {
      this.autorService.saveAutor(this.autorForm.value).subscribe(resp => {
      //this.autorForm.reset();
     // this.personas=this.personas.filter(persona=> resp.id!==persona.id);
      //this.personas.push(resp);
    },
      error => { console.error(error) }
    )
  }
  buscarAutor(): void {
    this.autorService.getsimilarAutor(this.autorForm.value).subscribe(resp => {
    //this.autorForm.reset();
   // this.personas=this.personas.filter(persona=> resp.id!==persona.id);
    //this.personas.push(resp);
  },
    error => { console.error(error) }
  )
}

}

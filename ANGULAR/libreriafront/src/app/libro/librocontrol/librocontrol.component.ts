import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';
//import { title } from 'process';
import { LibroService } from 'src/app/services/libro/libro.service';
import Swal from 'sweetalert2';
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

  mis_generos = [
    {name: ''},
    {name: 'Narrativa'},
    {name: 'Lirica'},
    {name: 'Teatro'},
    {name: 'Ensayo'},
    
  ];
 // const swal = require('sweetalert2');
  constructor(
    public fb: FormBuilder,
    public libroService:LibroService
  ) { }

  ngOnInit(): void {
    this.libroForm = this.fb.group({
      titulo : ['', [Validators.required,Validators.maxLength(100)]],      
      ano : ['', [Validators.required,Validators.maxLength(4),Validators.pattern("^[0-9]*$")]],
      genero : ['',[ Validators.required,Validators.pattern("[a-zA-Z]*")]],
      paginas : ['',[ Validators.required,Validators.maxLength(4),Validators.pattern("^[0-9]*$")]],
      my_autor : ['',[ Validators.required,Validators.maxLength(4),Validators.pattern("^[0-9]*$")]],
      my_editorial : ['',[ Validators.required,Validators.maxLength(4),Validators.pattern("^[0-9]*$")]]
    })
    this.libroService.getAllLibros().subscribe (resp => {
      this.libros=resp;
    
      console.log(resp);
    },
      error => { console.error(error) }
    );
  }
  guardar(): void {    
     if(this.libroForm.valid){ 
        this.libroService.saveLibro(this.libroForm.value).subscribe(resp => {
        this.libroForm.reset();
      // this.personas=this.personas.filter(persona=> resp.id!==persona.id);
        this.libros.push(resp);
      },
        error => { console.error(error) }
      )
    }else{
      console.log("no es valido");
      console.log(this.libroForm.value);
     
    }
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
    get titulo() { 
      return this.libroForm.get('titulo'); 
    }
    get ano() { 
      return this.libroForm.get('ano'); 
    }
    get genero() { 
      return this.libroForm.get('genero'); 
    }
    get paginas() { 
      return this.libroForm.get('paginas'); 
    }
    get my_autor() { 
      return this.libroForm.get('my_autor'); 
    }

    get my_editorial() { 
      return this.libroForm.get('my_editorial'); 
    }
    generos(){
      return this.mis_generos.values; 
    }

}

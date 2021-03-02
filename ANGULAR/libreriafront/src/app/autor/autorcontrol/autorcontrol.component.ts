import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AutorService } from 'src/app/services/autor/autor.service';

@Component({
  selector: 'app-autorcontrol',
  templateUrl: './autorcontrol.component.html',
  styleUrls: ['./autorcontrol.component.css']
})
export class AutorcontrolComponent implements OnInit {

  autorForm!: FormGroup;
  persona: any;
  personas: any;
  totalAngularPackages: any;
  constructor(
    public fb: FormBuilder,
    public autorService:AutorService
  ) { }

  ngOnInit(): void {
    this.autorForm = this.fb.group({
      id : ['', Validators.required],
      d_identidad : ['', Validators.required],
      nombre : ['', Validators.required],
      fecha_nacimiento : ['', Validators.required],
      lugar_nacimiento : ['', Validators.required],
      correo : ['', Validators.required],
      pais : ['', Validators.required],
      libros_escritos : ['', Validators.required]
    });
    this.autorService.getAllAutores().subscribe (resp => {
      this.personas=resp;
    
      console.log(resp);
    },
      error => { console.error(error) }
    );
    
    

  }
  guardar(): void {
      this.autorService.saveAutor(this.autorForm.value).subscribe(resp => {
      this.autorForm.reset();
      this.personas.push(resp);
     // this.personas=this.personas.filter(persona=> resp.id!==persona.id);
      //this.personas.push(resp);
    },
      error => { console.error(error) }
    )
  }
  buscarAutor(): void {
    //Headers:
    this.autorService.getsimilarAutor(this.autorForm.get("nombre")?.value).subscribe(resp => {
    this.persona=resp;
    //this.autorForm.reset();
   // this.personas=this.personas.filter(persona=> resp.id!==persona.id);
    //
    //this.totalAngularPackages = resp.total;
    console.log(resp);
  },
    error => { console.error(error) }
  )
}

}

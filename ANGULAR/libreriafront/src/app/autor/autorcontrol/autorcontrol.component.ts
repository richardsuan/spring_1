import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AutorService } from 'src/app/services/autor/autor.service';
@Component({
  selector: 'app-autorcontrol',
  templateUrl: './autorcontrol.component.html',
  styleUrls: ['./autorcontrol.component.css']
})
export class AutorcontrolComponent implements OnInit {
  private emailPattern: any = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  autorForm!: FormGroup;
  persona: any;
  personas: any;
  verSeleccion: any;
  opcionSeleccionado: any;
  busqueda = [
    {name: '', valor : '1'},
    {name: 'ID DB', valor : '2'},
    {name: '# de Documento', valor : '3'},
    {name: 'NOMBRE', valor : '4'},
    {name: 'CORREO', valor : 7},

  ];
  estados: any;
  constructor(
    public fb: FormBuilder,
    public autorService: AutorService
  ) {

   }

  ngOnInit(): void {
    this.autorForm = this.fb.group({
      id : [''],
      d_identidad : ['', [Validators.required, Validators.maxLength(12), Validators.pattern('^[0-9]*$')]],
      nombre : ['', [Validators.required, Validators.minLength(5), Validators.maxLength(400), Validators.pattern('[a-zA-Z ]*')]],
      // ,Validators.maxLength(400),Validators.pattern("[a-zA-Z ]*")
      fecha_nacimiento : ['', Validators.required],
      correo : ['', [Validators.required, Validators.pattern(this.emailPattern), Validators.maxLength(400)]] ,
      libros_escritos : ['' ]
    });
    this.autorService.getAllAutores().subscribe (res => {
      this.personas = res;
      console.log(res);
    },
      error => { console.error(error); }
    );

  }
  guardar(): void {
    if (this.autorForm.valid) {
        this.autorService.saveAutor(this.autorForm.value).subscribe(res => {
        this.autorForm.reset();
        this.personas.push(res);
      },
        error => { console.error(error); }
      );
    }else{
        console.log('error');
        console.log(this.autorForm.value);
    }
  }
  eliminar(persona: any): void {
    this.autorService.deletePersona(persona).subscribe(res => {
    console.log(res);
    if (res === true){
      this.personas.pop(persona);
    }
  },
    error => { console.error(error); }
  );
}
  buscarAutor(): void {

    this.autorService.getsimilarAutor(this.autorForm.get('nombre')?.value, this.verSeleccion).subscribe(res => {
    this.persona = res;

    console.log(res);
  },
    error => { console.error(error); }
  );
}
capturar() {
  this.verSeleccion = this.opcionSeleccionado.valor;
  console.log(this.opcionSeleccionado.valor);
}
  get nombre() {
    return this.autorForm.get('nombre');
  }
  get d_identidad() {
    return this.autorForm.get('d_identidad');
  }

  get correo() {
    return this.autorForm.get('correo');
  }
}

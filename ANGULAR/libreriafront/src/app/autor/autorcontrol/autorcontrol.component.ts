import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { AutorService } from 'src/app/services/autor/autor.service';
import { EstadosServiceService } from 'src/app/services/EstadosService/estados-service.service';
import { PaisesServiceService } from 'src/app/services/PaisesService/paises-service.service';

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
  totalAngularPackages: any;
  paises: any;
  verSeleccion: any;
  opcionSeleccionado: any;
  busqueda = [
    {name: '',valor :'1'},
    {name: 'ID DB',valor :'2'},
    {name: '# de Documento',valor :'3'},
    {name: 'NOMBRE',valor :'4'},
    {name: 'PAIS DE NACIMIENTO',valor :'5'},
    {name: 'CIUDAD DE NACIMIENTO',valor :'6'},
    {name: 'CORREO',valor :7},
    
  ];
  estados: any;
  constructor(
    public fb: FormBuilder,
    public estadosService: EstadosServiceService,
    public paisesService: PaisesServiceService,
    public autorService:AutorService
  ) {

   }

  ngOnInit(): void {
    this.autorForm = this.fb.group({
      id : [''],
      d_identidad : ['', [Validators.required,Validators.maxLength(12),Validators.pattern("^[0-9]*$")]],
      nombre : ['', [Validators.required, Validators.minLength(5),Validators.maxLength(400),Validators.pattern("[a-zA-Z ]*")]],
      //,Validators.maxLength(400),Validators.pattern("[a-zA-Z ]*")
      fecha_nacimiento : ['', Validators.required],
      lugar_nacimiento : ['', Validators.required],
      correo : ['', [Validators.required,Validators.pattern(this.emailPattern),Validators.maxLength(400)]] ,
      pais : ['', Validators.required],
      libros_escritos : ['' ]
    });
    this.autorService.getAllAutores().subscribe (resp => {
      this.personas=resp;
    
      console.log(resp);
    },
      error => { console.error(error) }
    );
    this.paisesService.getAllPaises().subscribe(resp => {
      console.log(resp);
      this.paises = resp;
    },
      error => { console.error(error) }
    );
    
    //
    this.autorForm.get('pais').valueChanges.subscribe(value => {
      this.estadosService.getAllEstadosByPais(value.id).subscribe(resp => {
        this.estados = resp;
      },
        error => { console.error(error) }
      );
    });
    //

  }
  guardar(): void {
    console.log("this.autorForm.get('d_identidad').value");
    console.log(this.autorForm.get('d_identidad').value);
    
    
    this.autorService.getsimilarAutor(this.autorForm.get('d_identidad')?.value,"3").subscribe(resp => {
      
      if(this.autorForm.valid && resp==null) { 
          this.autorForm.patchValue({
          pais: this.autorForm.get('pais').value["nombre"],
          lugar_nacimiento:this.autorForm.get('lugar_nacimiento').value["nombre"]
        });
        console.log(this.autorForm.value);
        this.autorService.saveAutor(this.autorForm.value).subscribe(resp => {
        this.autorForm.reset();
        this.personas.push(resp);
      
      },
        error => { console.error(error) }
      )
    }else{
        console.log('error ya existe');
        console.log(this.autorForm.value);
        alert("ya existe");
    }
     
  },
    error => { console.error(error) }
  )
    

    
    
  }
  eliminar(persona:any): void {
    this.autorService.deletePersona(persona).subscribe(resp => {
    console.log(resp);
    if(resp===true){
      this.personas.pop(persona);
    }
  },
    error => { console.error(error) }
  )
}
  buscarAutor(): void {
    
    this.autorService.getsimilarAutor(this.autorForm.get("nombre")?.value,this.verSeleccion).subscribe(resp => {
    this.persona=resp;
    
    console.log(resp);
    if(resp==null){
      console.log("holaaaaaaaaa");
    }
  },
    error => { console.error(error) }
  )
}
capturar() {
  // Pasamos el valor seleccionado a la variable verSeleccion
  this.verSeleccion = this.opcionSeleccionado["valor"];
 // console.log(type(this.opcionSeleccionado));
  console.log(this.opcionSeleccionado["valor"]);
  //console.log(this.opcionSeleccionado.get("valor"));
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
  get pais() { 
    return this.autorForm.get('pais'); 
  }
  get lugar_nacimiento(){
    return this.autorForm.get('lugar_nacimiento'); 
  }

}

import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LibroService } from 'src/app/services/libro/libro.service';
@Component({
  selector: 'app-librocontrol',
  templateUrl: './librocontrol.component.html',
  styleUrls: ['./librocontrol.component.css']
})
export class LibrocontrolComponent implements OnInit {
  // libro

  libro: any;
  libros: any;
  libroForm!: FormGroup;
  idAutores: any;
  idEditoriales: any;
  misGeneros = [
    {name: ''},
    {name: 'Narrativa'},
    {name: 'Lirica'},
    {name: 'Teatro'},
    {name: 'Ensayo'},

  ];
  constructor(
    public fb: FormBuilder,
    public libroService: LibroService
  ) { }
  // 78
  ngOnInit(): void {
    this.libroForm = this.fb.group({
      titulo : ['', [Validators.required, Validators.maxLength(100)]],
      ano : ['', [Validators.required, Validators.maxLength(4), Validators.pattern('^[0-9]*$')]],
      genero : ['', [ Validators.required, Validators.pattern('[a-zA-Z]*')]],
      paginas : ['', [ Validators.required, Validators.maxLength(4), Validators.pattern('^[0-9]*$')]],
      my_autor : ['', [ Validators.required, Validators.maxLength(4), Validators.pattern('^[0-9]*$')]]
    });
    this.libroService.getAllLibros().subscribe (res => {
      this.libros = res;

      console.log(res);
    },
      error => { console.error(error); }
    );
    this.libroService.getAllAutores().subscribe (res => {
      this.idAutores = res;
      console.log(res);
    },
      error => { console.error(error); }
    );
  }
  guardar(): void {
    console.log(this.libroForm.value);
     if (this.libroForm.valid){
        this.libroService.saveLibro(this.libroForm.value).subscribe(res => {
        this.libroForm.reset();
        this.libros.push(res);
      },
        error => { console.error(error); }
      );
    }else{
      console.log('no es valido');
      console.log(this.libroForm.value);
    }
  }
  buscarLibro(): void {
    this.libroService.getsimilarLibro(this.libroForm.get('titulo')?.value).subscribe(res => {
    this.libro = res;
    console.log(this.libroForm.get('titulo')?.value);
  },
    error => { console.error(error); }
  );
  }
  eliminar(libro: any): void {
    this.libroService.deleteLibro(libro).subscribe(res => {
    console.log(res);
    this.buscarLibro();
    if (res === true){
      this.libros.pop(libro);
    }
  },
    error => { console.error(error); }
  );
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
      return this.misGeneros.values;
    }
}

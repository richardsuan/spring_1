import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class LibroService {

  constructor(private httpClient: HttpClient) { }

  private API_SERVER = "http://localhost:8080/"; 
  public getAllAutores(): Observable<any>{//trae todos los autores 
    return this.httpClient.get(this.API_SERVER+"libros/");
  }

  public saveLibro (libro:any): Observable<any>{//guarda un autor
    console.log(libro);
    return this.httpClient.post(this.API_SERVER+"libro/agregar/",libro);
  }
  public getsimilarLibro (libro:any): Observable<any>{//guarda un autor
    console.log(libro);
    //var jsonString = JSON.stringify(autor)
    return this.httpClient.get(this.API_SERVER+"libro/buscar/",libro);
  }

}

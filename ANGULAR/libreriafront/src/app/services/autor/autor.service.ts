import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AutorService {

  

  constructor(private httpClient: HttpClient) { }

  private API_SERVER = "http://localhost:8080/"; 
  public getAllAutores(): Observable<any>{//trae todos los autores 
    return this.httpClient.get(this.API_SERVER+"autores/");
  }

  public saveAutor (autor:any): Observable<any>{//guarda un autor
    console.log(autor);
    return this.httpClient.post(this.API_SERVER+"autor/agregar/",autor);
  }
  public getsimilarAutor (autor:any): Observable<any>{//guarda un autor
    console.log(autor);
    //var jsonString = JSON.stringify(autor)
    return this.httpClient.get(this.API_SERVER+"autor/buscar/",autor);
  }
/*
  public deletePersona(id):Observable<any>{//borra un autor
    return this.httpClient.delete(this.API_SERVER + "autor/eliminar/"+id);
  }*/
}

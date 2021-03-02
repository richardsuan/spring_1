import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient,HttpParams } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class LibroService {

  constructor(private httpClient: HttpClient) { }

  private API_SERVER = "http://localhost:8080/"; 
  public getAllLibros(): Observable<any>{//trae todos los autores 
    return this.httpClient.get(this.API_SERVER+"libros/");
  }

  public saveLibro (libro:any): Observable<any>{//guarda un autor
    console.log(libro);
    return this.httpClient.post(this.API_SERVER+"libro/agregar/",libro);
  }
  public getsimilarLibro (libro:any): Observable<any>{//guarda un autor
    console.log(libro);
    let params = new HttpParams().set('titulo', libro);
    console.log(this.API_SERVER+"autor/buscar",{​​ params: params });
    return this.httpClient.get<any>(this.API_SERVER+"libro/buscar",{​​ params: params });
  }
  public deleteLibro(libro:any):Observable<any>{//borra un autor
    console.log(libro.id);
    return this.httpClient.delete(this.API_SERVER + "libro/eliminar/"+libro.id);
  }
}

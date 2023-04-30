import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AutorService {



  constructor(private httpClient: HttpClient) { }

  private API_SERVER = 'http://localhost:8181/';
  public getAllAutores(): Observable<any>{
    return this.httpClient.get(this.API_SERVER + 'autores/');
  }

  public saveAutor(autor: any): Observable<any>{
    console.log(autor);
    return this.httpClient.post(this.API_SERVER + 'autor/agregar/', autor);
  }
  public getsimilarAutor(autor: string, busqueda: string): Observable<any>{// guarda un autor
    console.log(autor, '  autor');
    console.log(busqueda + '  tipo');
    // console.log(autor..get('nombre').value);
    const params = new HttpParams().set('valor', autor).set('tipo', busqueda);
    // params.append
    console.log(this.API_SERVER + 'autor/buscar', { params });
    // var headers = JSON.stringify(autor)
    return this.httpClient.get<any>(this.API_SERVER + 'autor/buscar', { params });
  }



  public deletePersona(persona: any): Observable<any>{// borra un autor
    console.log(persona.id);
    return this.httpClient.delete(this.API_SERVER + 'autor/eliminar/' + persona.id);
  }
}

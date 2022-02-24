import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { EMPTY } from 'rxjs'

import { HttpClient,HttpHeaders,HttpParams } from '@angular/common/http';
import { NULL_EXPR } from '@angular/compiler/src/output/output_ast';
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
    //let params = new HttpParams().set('valor', autor).set('tipo','3');
    //this.httpClient.get<any>(this.API_SERVER+"autor/buscar",{​​ params: params }​​);
    return this.httpClient.post(this.API_SERVER+"autor/agregar/",autor);
  }
  public getsimilarAutor (autor:string,busqueda:string): Observable<any>{//guarda un autor
   
    //console.log(autor..get('nombre').value);
    
    let params = new HttpParams().set('valor', autor).set('tipo',busqueda);
    //params.append
    console.log(autor,"  autor");
    console.log(busqueda+"  tipo");
    //console.log( this.httpClient.get<any>(this.API_SERVER+"autor/buscar",{​​ params: params }​​)+"consulta");
    //var headers = JSON.stringify(autor)
    return this.httpClient.get<any>(this.API_SERVER+"autor/buscar",{​​ params: params }​​);
  }

  

  public deletePersona(persona:any):Observable<any>{//borra un autor
    console.log(persona.id);
    return this.httpClient.delete(this.API_SERVER + "autor/eliminar/"+persona.id);
  }
}

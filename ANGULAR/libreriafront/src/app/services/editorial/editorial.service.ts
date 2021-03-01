import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class EditorialService {
  constructor(private httpClient: HttpClient) { }

  private API_SERVER = "http://localhost:8080/"; 
  public getAllEditorial(): Observable<any>{//trae todos los autores 
    return this.httpClient.get(this.API_SERVER+"editoriales/");
  }

  public saveEditorial (editorial:any): Observable<any>{//guarda un autor
    console.log(editorial);
    return this.httpClient.post(this.API_SERVER+"editorial/agregar/",editorial);
  }
  public getsimilarEditorial (editorial:any): Observable<any>{//guarda un autor
    console.log(editorial);
    //var jsonString = JSON.stringify(autor)
    return this.httpClient.get(this.API_SERVER+"editorial/buscar/",editorial);
  }

 
}

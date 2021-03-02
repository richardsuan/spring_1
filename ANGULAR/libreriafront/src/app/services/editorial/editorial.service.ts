import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient,HttpParams } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class EditorialService {
  constructor(private httpClient: HttpClient) { }

  private API_SERVER = "http://localhost:8080/"; 
  public getAllEditorial(): Observable<any>{//trae todos los autores 
    return this.httpClient.get(this.API_SERVER+"editoriales/");
  }//

  public saveEditorial (editorial:any): Observable<any>{//guarda un autor
    console.log(editorial);
    return this.httpClient.post(this.API_SERVER+"editorial/agregar/",editorial);
  }

  public getsimilarEditorial (editorial:string): Observable<any>{//guarda un autor
    console.log(editorial);
    let params = new HttpParams().set('nombre', editorial);
   
    //var jsonString = JSON.stringify(autor)
    return this.httpClient.get(this.API_SERVER+"editorial/buscar",{​​ params: params });
  }

  public deleteEditorial(editorial:any):Observable<any>{//borra un autor
    console.log(editorial.id);
    return this.httpClient.delete(this.API_SERVER + "editorial/eliminar/"+editorial.id);
  }
}

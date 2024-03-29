import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class EstadosServiceService {

  private API_SERVER = "http://localhost:8080/estados/";

  constructor(private httpClient: HttpClient) { }


  public getAllEstadosByPais(idPais?:any): Observable<any>{
    console.log(idPais);
    return this.httpClient.get(this.API_SERVER+idPais);
  }
}

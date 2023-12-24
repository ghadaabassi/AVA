import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjetService {

  constructor(private http:HttpClient) { }

    private url='http://localhost:8081/api/'

    addclient(client:any){
      return this.http.post(this.url+'clients',client);
    }

    addAVA(project:any,file:any){
      return this.http.post(this.url+'avas', project,file);
    }
    
    /*
    addAVA(ava: any, file: FormData): Observable<any> {
    
      return this.http.post(this.url+'avas', file, { params: ava });
    }*/

    getAVAId(id:number){
      return this.http.get(this.url+'avas/'+id);
    }

    addFile(file:any){
      return this.http.post(this.url+'File/upload', file);
    }
  
    getallAvas(){
      return this.http.get(this.url+'avas');
    }
}

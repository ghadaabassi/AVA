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

    addAVA(project:any){
      return this.http.post(this.url+'avas',project);
    }
    
    getAVAId(id:number){
      return this.http.get(this.url+'avas/'+id);
    }

    addFile(file:any){
      return this.http.post(this.url+'File/upload', file);
    }
  
    getallAvas(){
      return this.http.get(this.url+'avas');
    }

    addAvaE(avae:any){
      return this.http.post(this.url+'avaes',avae)
    }

    getAllavasNotwaiting(){
      return this.http.get(this.url+'avas/notInAttente');
    }

    getAllavasWaiting(){
      return this.http.get(this.url+'avas/inAttente');
    }


    ActiverAVA(id:any  ){
      return this.http.put(this.url+'avas/activate/'+id,id);
    }
}

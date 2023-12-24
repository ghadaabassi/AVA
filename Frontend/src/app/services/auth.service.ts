import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient) {}
  private url='https://localhost:7266/api/'

login(username:string,password:string){
  return this.http.get(this.url+'Personnes/GetPersonneIdByEmailAndPassword?email='+username+'&password='+password)
}

signup(client: any){
  return this.http.post(this.url+'Clients',client);

  
}

getPersonByid(id:number){
    return this.http.get(this.url+'Personnes/id='+id);
}

}

import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient) {}
  private url='http://localhost:8081/api/agents'

  login(email: string, password: string): Observable<any> {
    const params = new HttpParams()
      .set('email', email)
      .set('password', password);
  
    return this.http.get<any>(this.url + '/emailAndPassword', { params });
  }
  

signup(agent: any){
  return this.http.post(this.url,agent);

}

getPersonByid(id:number){
    return this.http.get(this.url+'Personnes/id='+id);
}


}

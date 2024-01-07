import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  personne:any;
  id:any;
  nom:any;
  telephone:any;
  adresse:any;
  email:any;
  about:any;
  constructor(public serv:AuthService, private router:Router) { }

  ngOnInit(): void {
  }

  isLoggedIn(){
    let id=localStorage.getItem('id');
    if(id){
      return true;
    }
    else{
      return false;
    }
  }

  myaccount(){
    if(localStorage.getItem('typeagent')=='true'){
      this.router.navigate(['etranger']);
    }else{
      this.router.navigate(['agent']);
    }

  }


  logout() {
    localStorage.removeItem('id');
    localStorage.removeItem('typeagent');
    this.router.navigate(['/login']);
  }
  getidvalue(){
    return localStorage.getItem('id');
  }

  
  myhome(){
    if(localStorage.getItem('typeagent')=='true'){
      this.router.navigate(['/homeagentEtranger']);
      console.log("homeagentEtranger");
    }else{
      console.log(localStorage.getItem('typeagent'));
      this.router.navigate(['/homeAgent']);
      
    }
  }

}

import { Component, OnInit } from '@angular/core';
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
  constructor(public serv:AuthService) { }

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

  getid(){
    let storedIdString = localStorage.getItem('id');
    let storedIdNumber = storedIdString ? parseInt(storedIdString, 10) : 0;
    if (storedIdString !== null) {
    this.serv.getPersonByid(storedIdNumber).subscribe(
      data  => {
        this.personne=data;
        //this.id=this.personne.id;
        //this.adresse=this.personne.adresse;
        //this.nom=this.personne.nom;
        //this.telephone=this.personne.telephone;
        //this.email=this.personne.email;
        //this.about=this.personne.about;
  },
  err=>{
    console.log(err);
  });}
  }
  getidvalue(){
    //this.getid();
    return localStorage.getItem('id');
  }

}

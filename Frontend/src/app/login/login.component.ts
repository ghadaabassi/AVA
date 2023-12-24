import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  personne={
    mail:'',
    password:'',
  }
  constructor(private serv:AuthService,private router:Router) { }

  ngOnInit(): void {
  }

  pers:any;
  id:any;

  login(){

    this.serv.login(this.personne.mail, this.personne.password).subscribe(
      data  => {
        this.id=data;
        localStorage.setItem('id', this.id);
        console.log(localStorage.getItem('id'));
        this.router.navigate(['/homefreelance']);
  },
  err=>{
    console.log(err);
  });}



}

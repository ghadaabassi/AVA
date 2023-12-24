import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  client={
    nom:'',
    telephone:'',
    adresse:'',
    email:'',
    password:'',
    about:'',
  }
  constructor(private serv:AuthService, private router:Router) { }

  ngOnInit(): void {
  }

  signup(){
    this.serv.signup(this.client).
    subscribe(data => {
      this.router.navigate(['/login']);
    },
    err=>{
      console.log(err);
    }
    );
  }

}

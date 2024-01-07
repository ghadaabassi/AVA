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
  type:any;
  agent:any

  login(){

    this.serv.login(this.personne.mail, this.personne.password).subscribe(
      data  => {
        this.agent=data;
            localStorage.setItem('id', this.agent.email);
            localStorage.setItem('typeagent', this.agent.etranger);
            console.log('iddddddd :',this.agent)
            if (localStorage.getItem('typeagent') =='true'){
             
              this.router.navigate(['/homeagentEtranger']);
            }
            else{
             // console.log('condition:'+localStorage.getItem('type')=='false');
              this.router.navigate(['/homeAgent']);
            }
  },
  err=>{
    console.log(err);
  });
}




}

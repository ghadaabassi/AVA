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
            localStorage.setItem('id', this.agent.id);
            localStorage.setItem('typeagent', this.agent.etranger);
            console.log('Loged In')
            console.log('agent type:',localStorage.getItem('typeagent'))
            if (localStorage.getItem('type')=='false'){
              this.router.navigate(['/homeagentEtranger']);
            }
            else{
              this.router.navigate(['/homeAgent']);
            }
  },
  err=>{
    console.log(err);
  });
}




}

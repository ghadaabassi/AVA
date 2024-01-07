import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-signup-agent-etranger',
  templateUrl: './signup-agent-etranger.component.html',
  styleUrls: ['./signup-agent-etranger.component.css']
})
export class SignupAgentEtrangerComponent implements OnInit {
  agent={
    firstName:'',
    lastName:'',
    phoneNumber:'',
    email:'',
    password:'',
    etranger:true

  }
  constructor(private serv:AuthService, private router:Router) { }

  ngOnInit(): void {
  }

  signup(){
    this.serv.signup(this.agent).
    subscribe(data => {
      this.router.navigate(['/login']);
    },
    err=>{
      console.log(err);
    }
    );
  }


}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { ProjetService } from 'src/app/services/ava.service';

@Component({
  selector: 'app-freelance',
  templateUrl: './agent.component.html',
  styleUrls: ['./agent.component.css']
})
export class AgentComponent implements OnInit {

  agent:any
  id=localStorage.getItem('id');
  constructor(private serv:AuthService, public router:Router) { }

  ngOnInit(): void {

    this.serv.getAgentByEmail(this.id)
    .subscribe(agent => {this.agent = agent;
    console.log(this.agent);
    
    },
    err => { console.log(err);});
  }

}

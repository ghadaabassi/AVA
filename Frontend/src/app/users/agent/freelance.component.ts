import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { ProjetService } from 'src/app/services/projet.service';

@Component({
  selector: 'app-freelance',
  templateUrl: './freelance.component.html',
  styleUrls: ['./freelance.component.css']
})
export class FreelanceComponent implements OnInit {

  agent:any
  id=localStorage.getItem('id');
  constructor(private serv:AuthService, public router:Router) { }

  ngOnInit(): void {
    console.log("IDDDDDDDDDDDDDDDDDDDD:  "+this.id);
    this.serv.getAgentByEmail(this.id)
    .subscribe(agent => {this.agent = agent;
    console.log(this.agent);
    
    },
    err => { console.log(err);});
  }

}

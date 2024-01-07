import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  
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

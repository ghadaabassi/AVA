import { Component, OnInit } from '@angular/core';
import { ProjetService } from '../services/ava.service';

@Component({
  selector: 'app-home-agent-etranger',
  templateUrl: './home-agent-etranger.component.html',
  styleUrls: ['./home-agent-etranger.component.css']
})
export class HomeAgentEtrangerComponent implements OnInit {

  avas:any;
  avatype=["AVAA","AVAE",];
  constructor(private serv:ProjetService) { }

  ngOnInit(): void {

    this.serv.getAllavasWaiting().subscribe(
    res=>{
      this.avas = res;
    },
    err=>{
      console.log(err);
    });
  }
  
  autoriser(id:any){
    return this.serv.ActiverAVA(id).subscribe(
      ava=>{
        console.log("AVA Activated");
      },
      err=>{
        console.log(err);
      }
    );
  }

}

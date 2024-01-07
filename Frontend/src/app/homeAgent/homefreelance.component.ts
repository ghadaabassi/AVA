import { Component, OnInit } from '@angular/core';
import { ProjetService } from '../services/projet.service';

@Component({
  selector: 'app-homefreelance',
  templateUrl: './homefreelance.component.html',
  styleUrls: ['./homefreelance.component.css']
})
export class HomefreelanceComponent implements OnInit {

  avas:any;
  avatype=["AVAA","AVAE",];
  constructor(private serv:ProjetService) { }

  ngOnInit(): void {

    this.serv.getAllavasNotwaiting().subscribe(
      res=>{
        this.avas = res;
      },
      err=>{
        console.log(err);
      });

}

utiliser(id:any){
  
}

}

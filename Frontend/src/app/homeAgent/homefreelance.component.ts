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
  montantUtiliser: any;
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

utiliser(id:any,montantUtiliser:any){
  return this.serv.useAva(id,montantUtiliser).subscribe(res=>{
    console.log('Ava used !');
  });

}

isUtiliserAvaSectionVisible: boolean = false;


toggleUtiliserAvaSection() {
  this.isUtiliserAvaSectionVisible = !this.isUtiliserAvaSectionVisible;}

}

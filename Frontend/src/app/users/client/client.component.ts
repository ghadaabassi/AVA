import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  
  client={
    firstName:'',
    lastName:'',
    email:'',
    phoneNumber:'',
    secteur:0,
    residenceSecteur:'',
    agenceSecteur : ''
  }

  opt=''
  constructor() { }

  ngOnInit(): void {
  }

  ajouter() {}
  onSecteurChange() {
    this.client.secteur = parseInt(this.opt, 10);
    console.log('Selected Payment Method:', this.client.secteur);
  }
}

import { Component, OnInit } from '@angular/core';
import { ProjetService } from '../services/projet.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-createproject',
  templateUrl: './createproject.component.html',
  styleUrls: ['./createproject.component.css']
})
export class CreateprojectComponent implements OnInit {


  /*
  ava={
    type : 0,
    base:0,
    initial:0,
    date:"2023-01-01",
    solde:0,
    etat :0,
    client :null,
    file:null,}

client= {
  firstName: '',
  lastName: '',
  email: '',
  phoneNumber: '',
  secteur: '',
  residenceSecteur: '',
  agenceSecteur: '',
  
};
*/


ava=  {
  type: 0,
  base: 0,
  initial: 0,
  date: "2023-01-01",
  solde: 0,
  etat: 0,
  client: {
    firstName: '',
    lastName: '',
    email: '',
    phoneNumber: '',
    secteur: '',
    residenceSecteur: '',
    agenceSecteur: '',
  },
};

  /*
  client={
    firstName:'',
    lastName:'',
    email:'',
    phoneNumber:'',
    secteur:0,
    residenceSecteur:'',
    agenceSecteur : ''
  }
  */

  file:any

  select(e:any){
    //if (e.target.length > 0) {
    this.file=e.target.files[0];
  //}
  }

  constructor(private serv:ProjetService,private router:Router ) { }

  ngOnInit(): void {
  }


  
  addAvaWithFile(){

    if (!this.file) {
      console.error('No file selected!');
      return;
   }

      let fd= new FormData()
      fd.append('file',this.file);
      //fd.append('title',this.ava.client.email);
      console.log("fd.has('file'): ", fd.has('file'));  // Check if 'file' is present
      console.log("fd.has('title'): ", fd.has('title')); 
      console.log("fd.get('file'): ", fd.get('file'));  // Get value associated with 'file'
//console.log("fd.get('title'): ", fd.get('title')); 
    this.serv.addAVA(this.ava,fd)
    .subscribe((res:any) =>{
    
      this.router.navigate(['/home']);
    },
    err=>{
      console.log(err);
    });
  
}

onSecteurChange() {
  //this.client.secteur = parseInt(this.opt, 10);
  console.log('Selected Payment Method:', this.ava.client.secteur);
}

}
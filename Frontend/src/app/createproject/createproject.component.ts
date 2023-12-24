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
  file: null,
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
  
    if (e.target.length > 0) {
    this.file=e.target.files[0];}
  }

  constructor(private serv:ProjetService,private router:Router ) { }

  ngOnInit(): void {
  }


  addAvaWithFile(){
      
      let fd= new FormData()
      fd.append('file',this.file);
     // console.log(this.ava.date);

      //fd.append('type',this.ava.type.toString());
      //fd.append('base',this.ava.base.toString());
      //fd.append('initial',this.ava.initial.toString());
      //fd.append('date',this.ava.date.toString());
      //fd.append('solde',this.ava.solde.toString());
    this.serv.addFile(fd).
    subscribe((data:any) => {
     
    },
      err=>{
        console.log(err);
      });


    this.serv.addAVA(this.ava)
    .subscribe((res:any) =>{
      this.serv.getAVAId(res.id).subscribe(
        (res:any) =>{
          console.log("ava ",res)
          this.router.navigate(['/home']);
        },err=>{

        }
      )
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
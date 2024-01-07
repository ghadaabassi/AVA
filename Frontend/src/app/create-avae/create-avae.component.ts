import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { ProjetService } from '../services/projet.service';

@Component({
  selector: 'app-create-avae',
  templateUrl: './create-avae.component.html',
  styleUrls: ['./create-avae.component.css']
})
export class CreateAvaeComponent implements OnInit {
  avae=  {
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
    beneficiaire: {
      firstName: '',
      lastName: '',
      email: '',
      phoneNumber: '',
      function: '',
      dateInscr: "2023-01-01",
    },

  };


  constructor(private router:Router,private serv:ProjetService) { }

  showBeneficiaire: boolean = false;

  toggleBeneficiaire() {
    this.showBeneficiaire = !this.showBeneficiaire;

    
    if (this.showBeneficiaire) {
      this.clearFields();
    }
  }

  clearFields() {
    this.avae.client.firstName = '';
    this.avae.client.lastName = '';
    this.avae.client.phoneNumber = '';
    this.avae.client.residenceSecteur = '';
    this.avae.client.email = '';
    this.avae.client.agenceSecteur = '';
  }

  file:any



  ngOnInit(): void {
  }

  
    select(e:any){
      this.file=e.target.files[0];
    }
  


  addAvaE(){
    if (!this.file) {
      console.error('No file selected!');
      return;
   }
  
   let fd= new FormData()
   fd.append('file',this.file);
  this.serv.addFile(fd).subscribe(data=>{
   console.log("Added file")
 });
 console.log("BBBBBBBBBBBBBBBBBBBBBBBBBBB: "+this.avae.beneficiaire);

this.serv.addBeneficiare(this.avae.beneficiaire).subscribe(data=>{
  console.log("Beneficiaire Added");
},
err=>{
  console.log("ERRRRRRRRRRRRRRRRRRRRRRRR: "+err);
}
);

  //this.avae.beneficiaires = [];
    this.serv.addAvaE(this.avae).subscribe(a => {

      console.log('avae added');
      this.router.navigate(['/homeAgent']);
    });

  }

  
}

import { Component, OnInit } from '@angular/core';
import { ProjetService } from '../services/ava.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-createproject',
  templateUrl: './createAvaa.component.html',
  styleUrls: ['./createAvaa.component.css']
})
export class CreateAvaaComponent implements OnInit {

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


  file:any

  select(e:any){
    this.file=e.target.files[0];
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
     this.serv.addFile(fd).subscribe(data=>{
      console.log("Added file")
    });

    this.serv.addAVA(this.ava)
    
    .subscribe((res:any) =>{

      this.router.navigate(['/home']);
    },
    err=>{
      console.log(err);
    });
  
}





onSecteurChange() {
  
  console.log('Selected Payment Method:', this.ava.client.secteur);
}

}
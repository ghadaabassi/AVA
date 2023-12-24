import { Component, OnInit } from '@angular/core';
import { ProjetService } from '../services/projet.service';

@Component({
  selector: 'app-homefreelance',
  templateUrl: './homefreelance.component.html',
  styleUrls: ['./homefreelance.component.css']
})
export class HomefreelanceComponent implements OnInit {

  projects:any;
  payment=["CreditCard","BankTransfer","PayPal"];
  constructor(private serv:ProjetService) { }

  ngOnInit(): void {



}

}

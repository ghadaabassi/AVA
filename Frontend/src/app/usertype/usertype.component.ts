import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-usertype',
  templateUrl: './usertype.component.html',
  styleUrls: ['./usertype.component.css']
})
export class UsertypeComponent implements OnInit {

  constructor(public router:Router) { }

  ngOnInit(): void {
  }

}

import { NgModule,CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './layout/header/header.component';
import { FooterComponent } from './layout/footer/footer.component';
import { HomeComponent } from './home/home.component';

import {EtrangerComponent} from './users/etranger/etranger.component';
import { AgentComponent } from './users/agent/agent.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AboutComponent } from './about/about.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { PrivacyComponent } from './privacy/privacy.component';
import { CreateprojectComponent } from './createAvaa/createproject.component';
import { ContactComponent } from './contact/contact.component';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { UsertypeComponent } from './usertype/usertype.component';
import { HomefreelanceComponent } from './homeAgent/homefreelance.component';
import { ProjectdetailsComponent } from './projectdetails/projectdetails.component';
import { CreateAvaeComponent } from './create-avae/create-avae.component';
import { SignupAgentEtrangerComponent } from './signup-agent-etranger/signup-agent-etranger.component';
import { HomeAgentEtrangerComponent } from './home-agent-etranger/home-agent-etranger.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    EtrangerComponent,
    AgentComponent,
    LoginComponent,
    SignupComponent,
    AboutComponent,
    NotfoundComponent,
    PrivacyComponent,
    CreateprojectComponent,
    ContactComponent,
    UsertypeComponent,
    HomefreelanceComponent,
    ProjectdetailsComponent,
    CreateAvaeComponent,
    SignupAgentEtrangerComponent,
    HomeAgentEtrangerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
  //schemas: [CUSTOM_ELEMENTS_SCHEMA],

})
export class AppModule { }

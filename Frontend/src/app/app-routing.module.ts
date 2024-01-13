import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AboutComponent } from './about/about.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { PrivacyComponent } from './privacy/privacy.component';
import { CreateAvaaComponent } from './createAvaa/createAvaacomponent';
import { AgentComponent } from './users/agent/agent.component';
import { ContactComponent } from './contact/contact.component';
import { UsertypeComponent } from './usertype/usertype.component';
import { HomeAgentComponent } from './homeAgent/homeAgent.component';
import { EtrangerComponent } from './users/etranger/etranger.component';
import { CreateAvaeComponent } from './create-avae/create-avae.component';
import { SignupAgentEtrangerComponent } from './signup-agent-etranger/signup-agent-etranger.component';
import { HomeAgentEtrangerComponent } from './home-agent-etranger/home-agent-etranger.component';

const routes: Routes = [

  {path:'',redirectTo: '/home',pathMatch: 'full'},
  {path:'home', component: HomeComponent},
  {path:'login',component: LoginComponent},
  {path:'signup',component: SignupComponent},
  {path:'about',component: AboutComponent},
  {path:'privacy',component: PrivacyComponent},
  {path:'createavaa',component: CreateAvaaComponent},
  {path:'agent',component: AgentComponent},
  {path:'etranger',component: EtrangerComponent},
  {path:'contact',component: ContactComponent },
  {path:'usertype',component: UsertypeComponent },
  {path:'homeAgent',component: HomeAgentComponent },
  {path:'createavae', component: CreateAvaeComponent},
  {path:'signupetranger',component: SignupAgentEtrangerComponent },
  {path:'homeagentEtranger',component: HomeAgentEtrangerComponent},

  {path:'**',component: NotfoundComponent},
  
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

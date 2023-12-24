import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProjetComponent } from './projet/projet.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AboutComponent } from './about/about.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { PrivacyComponent } from './privacy/privacy.component';
import { CreateprojectComponent } from './createproject/createproject.component';
import { FreelanceComponent } from './users/freelance/freelance.component';
import { ContactComponent } from './contact/contact.component';
import { UsertypeComponent } from './usertype/usertype.component';
import { HomefreelanceComponent } from './homefreelance/homefreelance.component';
import { ProjectdetailsComponent } from './projectdetails/projectdetails.component';
import { ClientComponent } from './users/client/client.component';
import { AdminComponent } from './users/admin/admin.component';

const routes: Routes = [

  {path:'',redirectTo: '/home',pathMatch: 'full'},
  {path:'home', component: HomeComponent},
  {path:'projet', component: ProjetComponent},
  {path:'login',component: LoginComponent},
  {path:'signup',component: SignupComponent},
  {path:'about',component: AboutComponent},
  {path:'privacy',component: PrivacyComponent},
  {path:'createproject',component: CreateprojectComponent},
  {path:'freelance/:id',component: FreelanceComponent},
  {path:'client',component: ClientComponent},
  {path:'admin',component: AdminComponent},
  {path:'contact',component: ContactComponent },
  {path:'usertype',component: UsertypeComponent },
  {path:'homefreelance',component: HomefreelanceComponent },
  {path:'projectdetails',component: ProjectdetailsComponent},

  {path:'**',component: NotfoundComponent},
  
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

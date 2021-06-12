import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { TrainerRepComponent } from './trainer-rep/trainer-rep.component';
import { UserreportComponent } from './userreport/userreport.component';

export const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'login', component:LoginComponent},
  { path: 'signup', component: SignupComponent },
  { path: 'home' , component : HomeComponent},
  { path : 'admin' , component : AdminComponent},
  {path:'userrep',component:UserreportComponent},
  {path:'trainerrep',component:TrainerRepComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './_component/login/login.component';
import { HomeComponent } from './_component/home/home.component';
import { CreateDriverComponent } from './_component/create-driver/create-driver.component';
import { DriversComponent } from './_component/drivers/drivers.component';
import { EditDriverComponent } from './_component/edit-driver/edit-driver.component';
import { ContractComponent } from './_component/contract/contract.component';
import { EditContractComponent } from './_component/child/edit-contract/edit-contract.component';
import { AuthGuard } from './_guard/auth.guard';

const routes: Routes = [
  {
    path:'',
    pathMatch: 'full',
    redirectTo: 'login'
  }
  // {
  //   path:'',
  //   component:HomeComponent
  // }
  ,
  {
    path:'login',
    component:LoginComponent
  },
  {
    path:"drivers",
    component:DriversComponent,
    canActivate:[AuthGuard]
  },
  {
    path:"drivers/create",
    component:CreateDriverComponent,
    canActivate:[AuthGuard]
  },
  {
    path:"drivers/edit",
    component:EditDriverComponent,
    canActivate:[AuthGuard]
  },
  {
    path:"contract",
    component:ContractComponent,
    canActivate:[AuthGuard]
  },
  {
    path:"contract/:id",
    component:EditContractComponent,
    canActivate:[AuthGuard]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './_component/login/login.component';
import { LoginService } from './_service/login.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, NgForm } from '@angular/forms';  
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './_component/home/home.component';
import { DriverService } from './_service/driver.service';
import { CreateDriverComponent } from './_component/create-driver/create-driver.component';
import { DriversComponent } from './_component/drivers/drivers.component';
import { EditDriverComponent } from './_component/edit-driver/edit-driver.component';
import { NavbarComponent } from './_component/child/navbar/navbar.component';
import { ContractComponent } from './_component/contract/contract.component';
import { EditContractComponent } from './_component/child/edit-contract/edit-contract.component';
import { AuthGuard } from './_guard/auth.guard';





@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    CreateDriverComponent,
    DriversComponent,
    EditDriverComponent,
    NavbarComponent,
    ContractComponent,
    EditContractComponent,

    
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ToastrModule.forRoot({
      timeOut: 2000,
      positionClass: 'toast-top-right',
      preventDuplicates: true,
    }),
    BrowserAnimationsModule,
    
    
  ],
  providers: [
    LoginService,
    DriverService,
    AuthGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

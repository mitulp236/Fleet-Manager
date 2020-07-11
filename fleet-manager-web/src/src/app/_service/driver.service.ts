import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { DriverModel } from '../_model/driver-model';
import { Observable } from 'rxjs';
import { BudgetCategoryModel } from '../_model/budget-category-model';
import { DriverWebAccessModel } from '../_model/driver-web-access-model';
import { SettingsService } from './settings.service';

@Injectable({
  providedIn: 'root'
})
export class DriverService {

  constructor(private http: HttpClient,private settinngs:SettingsService) { }
  driver_url = `${this.settinngs.BASE_URL}fleet-manager-api/rest/driver/`;
  signup_url = `${this.settinngs.BASE_URL}fleet-manager-api/rest/driver/save`;
  budgetCat_url = `${this.settinngs.BASE_URL}fleet-manager-api/rest/budgetcat`;
  webAccess_url = `${this.settinngs.BASE_URL}fleet-manager-api/rest/webaccess`;
  budgetcatbydriver_url = `${this.settinngs.BASE_URL}fleet-manager-api/rest/budgetcatbydriver`;
  singleDriverDetails_url = `${this.settinngs.BASE_URL}fleet-manager-api/rest/driver/`;
  denyWebaccess_url = `${this.settinngs.BASE_URL}fleet-manager-api/rest/driver/denyWebAccess/`;
  setWebaccess_url = `${this.settinngs.BASE_URL}fleet-manager-api/rest/driver/setWebAccess/`;
  driverNames_ur = `${this.settinngs.BASE_URL}fleet-manager-api/rest/driver/driverNames`;


  // http options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':'application/json',
      'Authorization':'my-auth-token',
      'auth-token':localStorage.getItem('auth-token'),
      'session_key':localStorage.getItem('session_key')
    })
  };

  //get all driver result
  getDrivers(payload){
    
    return this.http.post(this.driver_url,payload,this.httpOptions);
  }

  //save driver
  saveDriver(driverPayload){
    return this.http.post(this.signup_url,driverPayload,this.httpOptions);
  }

  //get budget_cat data 
  getbudgetCat(){
    return this.http.get(this.budgetCat_url,this.httpOptions);
  }

  getDriverWeAccessDetails(){
    return this.http.get(this.webAccess_url,this.httpOptions);
  }

  updateDriverWebAccess(webAccess,driverId){
     let payload:DriverWebAccessModel = {driverId:driverId,webAccess:webAccess};
    //  payload.driverId=driverId;
    //  payload.webAccess=webAccess;
    return this.http.post(this.webAccess_url,JSON.stringify(payload),this.httpOptions);
  }

  denyWebAccess(id:Number){
    return this.http.get(`${this.denyWebaccess_url}${id}`,this.httpOptions);
  }

  setWebAccess(id:Number){
    return this.http.get(`${this.setWebaccess_url}${id}`,this.httpOptions);
  }

  budgetcatbydriver(){
    return this.http.get(this.budgetcatbydriver_url,this.httpOptions);
  }

  getSingleDriverDetails(id:number){
    console.log(`${this.singleDriverDetails_url}${id}`);
    return this.http.get(`${this.singleDriverDetails_url}${id}`,this.httpOptions);
  }

  deleteDriverById(id:number){
    console.log(`${this.driver_url}${id}`);
    return this.http.delete(`${this.driver_url}${id}`,this.httpOptions);
  }

  getDriverNames(){
    return this.http.get(this.driverNames_ur,this.httpOptions);
  }

  


  
}

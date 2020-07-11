import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { SettingsService } from './settings.service';

@Injectable({
  providedIn: 'root'
})
export class ContractService {

  constructor(private http: HttpClient,
    private settinngs:SettingsService) { }

     // http options
  httpOptions = {
      headers: new HttpHeaders({
      'Content-Type':'application/json',
      'Authorization':'my-auth-token',
      'auth-token':localStorage.getItem('auth-token'),
      'session_key':localStorage.getItem('session_key')
    })
  };

  contract_url = `${this.settinngs.BASE_URL}fleet-manager-api/rest/contract/`;
  saveContract_url = `${this.settinngs.BASE_URL}fleet-manager-api/rest/contract/save`;

  getContracts(payload){
    return this.http.post(this.contract_url,payload,this.httpOptions);
  }

  getContract(id:number){
    return this.http.get(`${this.contract_url}${id}`,this.httpOptions);
  }

  saveContract(payload){
    return this.http.post(this.saveContract_url,payload,this.httpOptions);
  }


}

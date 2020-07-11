import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SettingsService } from './settings.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient,private settinngs:SettingsService) { }

  login_url = `${this.settinngs.BASE_URL}fleet-manager-api/rest/user/login`;

  login(email,password){
    // define json payload
    const payload = {
      email:email,
      password:password
    };
    // define http post request
    return this.http.post(this.login_url,payload,{observe:'response'});  
  }

}

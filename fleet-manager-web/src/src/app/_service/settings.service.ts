import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SettingsService {

  constructor() { }

  // BASE_URL = "http://localhost:8080/";
  BASE_URL = "http://192.168.0.102:8080/";
}

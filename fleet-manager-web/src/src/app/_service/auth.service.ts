import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private router:Router) { }

  loggedIn(){
    return !!localStorage.getItem("auth-token");
  }
  logout(){
    localStorage.removeItem('auth-token');
    localStorage.removeItem('session-key');
    this.router.navigate(['/']);
  }
}

import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/_service/login.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService,private toastr: ToastrService,
    private router: Router,) { }

  ngOnInit(): void {
  
  }

  email : string;
  password : string;

  email_ctr($event : any){
    this.email = $event.target.value;
  }
  password_ctr($event : any){
    this.password = $event.target.value;
  }

  
  // login controller
  login(){
    this.loginService.login(this.email,this.password)
    .subscribe(res => {
        localStorage.setItem("auth-token",res.headers.get("auth-token"));
        localStorage.setItem("session_key",res.headers.get("session_key"));
        this.toastr.success("Login Successfully","login");
        this.router.navigateByUrl('drivers');
    },err =>{
        this.toastr.error(err.error.message, "Failed")
    });
  }

  //logged in method
  
  
}

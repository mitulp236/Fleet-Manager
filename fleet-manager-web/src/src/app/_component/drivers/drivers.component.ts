import {Component, OnInit} from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { ToastrService } from 'ngx-toastr';
import { DriverService } from 'src/app/_service/driver.service';
import { DriverModel } from 'src/app/_model/driver-model';
import { DriverWebAccessModel } from 'src/app/_model/driver-web-access-model';
import { BudgetCategoryModel } from 'src/app/_model/budget-category-model';
import { BudgetCatBydriverModel } from 'src/app/_model/budget-cat-bydriver-model';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-drivers',
  templateUrl: './drivers.component.html',
  styleUrls: ['./drivers.component.css']
})
export class DriversComponent implements OnInit {

  drivers : DriverModel[] = [];
  dirverWebAccessdetails:DriverWebAccessModel[] = [];
  budgetCatByDriverDetails:BudgetCatBydriverModel[] = [];
  // data = [];

  total_page = 0;
  initial_count = 0;
  page_size = 5;

  next_btn_status:boolean;
  last_btn_status:boolean;
  previous_btn_status:boolean;


  
 next_btn_click(){
    
  this.initial_count += 1;
  var start = this.initial_count*this.page_size;
  if(this.initial_count >= this.total_page - 1){
      this.next_btn_status = true;
      this.last_btn_status = true;

  }
  const payload = {
    "start":start,
    "sortBy":null,
    "serchBy":null,
    "serchString":null
   }
  this.getDrivers(payload);
}
 first_btn_click(){
  this.next_btn_status = false;
  this.last_btn_status = false;
  this.initial_count = 0;
  var start = 0;

  const payload = {
    "start":start,
    "sortBy":null,
    "serchBy":null,
    "serchString":null
   }
  this.getDrivers(payload);
}
 last_btn_click(){
  this.initial_count = this.total_page - 1;
  var start = this.initial_count*this.page_size;
  console.log(this.page_size);
  console.log(this.total_page);
  console.log(start);
  const payload = {
    "start":start,
    "sortBy":null,
    "serchBy":null,
    "serchString":null
   }
  this.getDrivers(payload);
  this.next_btn_status = true;
  this.last_btn_status = true;
}
 previous_btn_click(){
  this.next_btn_status = false;
  this.last_btn_status = false;
  if(this.initial_count > 0){
      this.initial_count -= 1;
  }else{
      this.initial_count  = 0;
  }
  var start = this.initial_count*this.page_size;
  const payload = {
    "start":start,
    "sortBy":null,
    "serchBy":null,
    "serchString":null
   }
  this.getDrivers(payload);
}

shortBy(column_name:string){
  const payload = {
    "start":null,
    "sortBy":column_name,
    "serchBy":null,
    "serchString":null
   }
   this.getDrivers(payload);
}

onSubmitSerchForm(searchForm:NgForm){
  this.initial_count = 0;
  const formPayload = searchForm.value;
  if(formPayload.serchString == ""){
    formPayload.serchString = null;
    formPayload.serchBy = null;
  }
  const payload = {
    "start":null,
    "sortBy":null,
    "serchBy":formPayload.serchBy,
    "serchString":formPayload.serchString
   }
   this.getDrivers(payload);
}

  //get all driver
  getDrivers(payload){
    this.driverService.getDrivers(payload)
        .subscribe(res =>{
          this.drivers = res as DriverModel[];
          this.total_page = res[0].pages;
          if(this.initial_count <= 0){
            this.previous_btn_status = true;
          }else{
            this.previous_btn_status = false;
          }
        },err =>{
          if(err.status == 401){
            this.router.navigateByUrl('/');
          }
          if(err.status == 406){
            this.toastr.info("Data not found ! ");
            this.drivers.length = 0;
          }
        });   
  }


  getBudgetCatByDriver(){
    this.driverService.budgetcatbydriver()
        .subscribe(res => {
          this.budgetCatByDriverDetails = res as BudgetCatBydriverModel[];
          console.log(this.budgetCatByDriverDetails);
        },err => {
          if(err.status == 401){
            this.router.navigateByUrl('/');
          }
          console.log(err);
        });
  }



  
  // variable for a refreshing component
  mySubscription: any;
  constructor(private driverService: DriverService,
    private router: Router,
    private http: HttpClient,
    private toastr: ToastrService,) { 

      // code for a refreshing component - start
      this.router.routeReuseStrategy.shouldReuseRoute = function () {
        return false;
      };
      this.mySubscription = this.router.events.subscribe((event) => {
        if (event instanceof NavigationEnd) {
          // Trick the Router into believing it's last link wasn't previously loaded
          this.router.navigated = false;
        }
      });
      // code for a refreshing component - end
    }

  ngOnInit(): void {
    const payload = {
      "start":null,
      "sortBy":null,
      "serchBy":null,
      "serchString":null
     }
    this.getDrivers(payload);
    // this.getDriverWebAccessDetails();
  }


  
  webAccessToggle(id:number){
    console.log(id);
    let driver = this.drivers.find(x => x.id === id);

    let webAccess:boolean;
    let driverId:number;

    if(driver.webAccess){


        this.driverService.setWebAccess(id).subscribe(res => {
          this.toastr.success("WebAcess Successfully updated !");
        },err => {
          if(err.status == 401){
            this.router.navigateByUrl('/');
          }
          this.toastr.error("webAccess Failed to update !");
        });
    }else{
      this.driverService.denyWebAccess(id).subscribe(res => {
        this.toastr.success("WebAcess Successfully updated !");
      },err => {
        if(err.status == 401){
          this.router.navigateByUrl('/');
        }
        this.toastr.error("webAccess Failed to update !");
      });
    }

  }

  //delete button clicked
  deleteBtnClicked(id){
    var result = confirm("Are you sure ?");
    if(result !== true){
      return 0;
    }
    this.deleteDriverById(id);
  }

  deleteDriverById(id:number){
    this.driverService.deleteDriverById(id)
        .subscribe(res =>{
            this.toastr.error("Driver Deleted Successfully ! ");
            this.router.navigateByUrl("/drivers");
        },err => {
          if(err.status == 401){
            this.router.navigateByUrl('/');
          }
          console.log(err);
        });
  }

  editDriver(id:number){
    window.localStorage.removeItem("editDriverId");
    window.localStorage.setItem("editDriverId", id.toString());
    this.router.navigateByUrl("drivers/edit");
  }
  
  
 
}

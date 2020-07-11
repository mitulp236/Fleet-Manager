import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { ToastrService } from 'ngx-toastr';
import { DriverService } from 'src/app/_service/driver.service';
import { BudgetCategoryModel } from 'src/app/_model/budget-category-model';
import { NgForm } from '@angular/forms';
import { DriverModel } from 'src/app/_model/driver-model';

@Component({
  selector: 'app-edit-driver',
  templateUrl: './edit-driver.component.html',
  styleUrls: ['./edit-driver.component.css']
})
export class EditDriverComponent implements OnInit {
  DriversAllDetails: any = {};

  getAllDriverDetails(id:number){
    this.driverService.getSingleDriverDetails(id)
        .subscribe(res => {
          console.log(res);
          this.DriversAllDetails = res[0];
        },err => {
          console.log(err);
        });
        
  }

  budget_cats:BudgetCategoryModel[] = []

  //get all budgetCat data
  getBudgetCat(){
    this.driverService.getbudgetCat().subscribe(res => {
      console.log(res);
      this.budget_cats = res as BudgetCategoryModel[];
    },err => {
      console.log("error");
    });
  } 

 

  constructor(private router: Router,
    private http: HttpClient,
    private toastr: ToastrService,
    private driverService: DriverService,) { }

  ngOnInit(): void {
    this.getAllDriverDetails(parseInt(window.localStorage.getItem("editDriverId")));
    this.getBudgetCat();
  }


  saveDriver(driverPayload){
    this.driverService.saveDriver(driverPayload).subscribe(res => {
        console.log(res);
        this.toastr.success("Driver Successfully Updated","Success");
        this.router.navigateByUrl('drivers');
    },
    err => {
        console.log(err);
        this.toastr.error(err.message,"Fail");
    });
  }

  onSubmit(driverForm:NgForm){
    driverForm.value.catId = Number(driverForm.value.catId);
    driverForm.value.id= Number(localStorage.getItem("editDriverId"));
    const driverPayload = JSON.stringify(driverForm.value);
    this.saveDriver(driverPayload);
    console.log(driverPayload);
  }

}

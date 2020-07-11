import { Component, OnInit } from '@angular/core';
import { DriverService } from 'src/app/_service/driver.service';
import { Router, RouterLink } from '@angular/router';
import { NgForm } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { DriverModel } from 'src/app/_model/driver-model';
import { ToastrService } from 'ngx-toastr';
import { BudgetCategoryModel } from 'src/app/_model/budget-category-model';


@Component({
  selector: 'app-create-driver',
  templateUrl: './create-driver.component.html',
  styleUrls: ['./create-driver.component.css']
})
export class CreateDriverComponent implements OnInit {
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

  constructor(private driverService: DriverService,
              private router: Router,
              private http: HttpClient,
              private toastr: ToastrService,
              
    ) {}

  ngOnInit(): void {
    this.getBudgetCat();
  }

  
  


  

  //save driver
  saveDriver(driverPayload){
    this.driverService.saveDriver(driverPayload).subscribe(res => {
        console.log(res);
        this.toastr.success("Driver Successfully Added","Success");
    },
    err => {
        console.log(err);
        this.toastr.error(err.message,"Fail");
    });
  }

  onSubmit(driverForm:NgForm){
    driverForm.value.catId == "0" ? driverForm.value.catId == null:console.log();
    const driverPayload = JSON.stringify(driverForm.value);
    console.log();
    this.saveDriver(driverPayload);
    console.log(driverPayload);
  }

}

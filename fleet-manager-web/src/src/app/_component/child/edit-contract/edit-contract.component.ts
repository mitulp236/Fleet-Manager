import { Component, OnInit } from '@angular/core';
import { ContractService } from 'src/app/_service/contract.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Contract } from 'src/app/_model/contract';
import { DriverService } from 'src/app/_service/driver.service';
import { NgForm } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-edit-contract',
  templateUrl: './edit-contract.component.html',
  styleUrls: ['./edit-contract.component.css']
})
export class EditContractComponent implements OnInit {

  constructor(private contractService:ContractService,
    private route: ActivatedRoute,
    private driverService: DriverService,
    private toastr: ToastrService,
    private router: Router) { }

  id: number;
  private parameter_sub: any;

  ngOnInit(): void {

    this.parameter_sub = this.route.params.subscribe(params => {
      this.id = params['id'] as number;
     });
     this.getDriverNames();
     this.getContract();
  }

  contract:Contract;

  getContract(){
    this.contractService.getContract(this.id).subscribe(res => {
      this.contract = res as Contract;
      console.log(this.contract);
    },err => {
      if(err.status == 401){
        this.router.navigateByUrl('/');
      }
      this.toastr.error(err.error.message,"Fail");
      this.router.navigateByUrl('contract');
    });
  }

  driverNames;
  getDriverNames(){
    this.driverService.getDriverNames().subscribe(res => {
      this.driverNames = res;
    },err =>{
      if(err.status == 401){
        this.router.navigateByUrl('/');
      }
    });
  }

  onSubmit(form:NgForm){
    form.value.driverId = Number(form.value.driverId);
    const contractPayload = JSON.stringify(form.value);
    this.saveContract(contractPayload);
    console.log(contractPayload);
  }

  saveContract(payload){
    this.contractService.saveContract(payload).subscribe(res => {
      this.toastr.success("Contract successfully updated !","Success");
      this.router.navigateByUrl('contract');
    },err => {
      if(err.status = 401){
        this.router.navigateByUrl('/');
      }
    });
  }

  ngOnDestroy() {
    this.parameter_sub.unsubscribe();
  }

}

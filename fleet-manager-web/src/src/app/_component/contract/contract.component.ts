import { Component, OnInit } from '@angular/core';
import { ContractService } from 'src/app/_service/contract.service';
import { Contract } from 'src/app/_model/contract';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-contract',
  templateUrl: './contract.component.html',
  styleUrls: ['./contract.component.css']
})
export class ContractComponent implements OnInit {

  constructor(private contractService:ContractService,
    private router:Router,
    private toastr: ToastrService) { }

  ngOnInit(): void {
    const payload = {
      "start":null,
      "sortBy":null,
      "serchBy":null,
      "serchString":null
     }
    this.getContracts(payload);
  }

  contracts:Contract[] = []

  getContracts(payload){
    this.contractService.getContracts(payload).subscribe(res => {
      this.contracts = res as Contract[];
      this.total_page = res[0].pages;
      if(this.initial_count <= 0){
        this.previous_btn_status = true;
      }else{
        this.previous_btn_status = false;
      }
    }, err => {
      if(err.status == 401){
        this.router.navigateByUrl('/');
      }
      if(err.status == 406){
        this.toastr.info("Data not found ! ");
        this.contracts.length = 0;
      }
    });
  }

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
  this.getContracts(payload);
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
  this.getContracts(payload);
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
  this.getContracts(payload);
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
  this.getContracts(payload);
}

shortBy(column_name:string){
  const payload = {
    "start":null,
    "sortBy":column_name,
    "serchBy":null,
    "serchString":null
   }
   this.getContracts(payload);
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
   this.getContracts(payload);
}


  edit_contract(id:number){

    this.router.navigateByUrl(`/contract/${id}`);

  }

}

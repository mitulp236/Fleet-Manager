export class DriverModel {
    constructor(
		public id:number,
		public title:string,
		public firstName:string,
		public middleName:string,
		public lastName:string,
		public dob:Date,
		public email:string,
		public telephone:string,
		public mobile:string,
		public jobTitle:string,
		public staffNumber:string,
		public address:string,
		public postcode:string,
		public city:string,
		public licenseNo:string,
		public licenseValidFrom:Date,
		public licenseValidTo:Date,
		public endDate:Date,
		public isActive:boolean,
		public webAccess:boolean,
		public catId:number
	){}
}
// customModel = new DriverModel(1,'a','a','a','a',new Date("Fri Dec 08 2019 07:44:57"),'a','a','a','a','a','a'
//   ,'a','a','a',new Date("Fri Dec 08 2019 07:44:57"),new Date("Fri Dec 08 2019 07:44:57"),new Date("Fri Dec 08 2019 07:44:57"),false);


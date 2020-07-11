import { DriverModel } from './driver-model';

export class Contract {
    id:number;
    vehicaleName:string;
    licensePlate:string;
    distance:number;
    duration:number;
    startDate:Date;
    endDate:Date;
    driverId:number;
    driver:DriverModel;
    userId:number;
}

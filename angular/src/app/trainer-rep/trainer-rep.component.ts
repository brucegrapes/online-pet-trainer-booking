import { HttpClient } from '@angular/common/http';
import { identifierModuleUrl } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';

export class Cards{
  constructor(
    public trainerId:string,
    public name:string,
    public email: string,
    public experience: number,
    public shopName: string,
    public password:string,
    public active: boolean

  ){}
}
export interface Client {
  mail: string;
  password: string;
  username: string;
  mobileNumber: string;
  active: boolean;
  role: string;
  id: number;
}
export class TrainerBooking
{
  constructor(
    public bookingId:	string,
    public emailTrainerDetail	: string,
    public emailClientDetail:string,
    public clientDetail :	Client,
    public lawFirmName:	string,
    public date	: Date,
    public time	: string,
    public amount:	number,
    public bookingStatus:	boolean,
    public trainerDetail : Cards
  ){}
}
@Component({
  selector: 'app-trainer-rep',
  templateUrl: './trainer-rep.component.html',
  styleUrls: ['./trainer-rep.component.css']
})
export class TrainerRepComponent implements OnInit {
  trainer!:TrainerBooking[];
  constructor(private httpClient : HttpClient) { }

  ngOnInit(): void {
    this.getTrainer();
    //this.getParticularTrainer();
  }

  tid = this.trainer;
  getTrainer()
  {
    this.httpClient.get<any>('https://8080-fcfbaeedfaabacedbefccaeeabbfbebdcacd.examlyiopb.examly.io/Trainer/booking').subscribe(
      response=>{
        this.trainer = response;
        console.log(this.trainer);
      }
      );
    }
     getParticularTrainer(tid: any)
     {
       this.httpClient.get<any>('https://8080-fcfbaeedfaabacedbefccaeeabbfbebdcacd.examlyiopb.examly.io/Trainer/booking').subscribe(
       res=>{
        this.trainer = res;
        console.log(this.trainer);
      }
      );
    }
}

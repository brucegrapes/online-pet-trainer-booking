import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';


export class Cards{
  constructor(
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
  selector: 'app-userreport',
  templateUrl: './userreport.component.html',
  styleUrls: ['./userreport.component.css']
})
export class UserreportComponent implements OnInit {

  user!:TrainerBooking[];
  constructor(private httpClient : HttpClient) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers()
  {
    this.httpClient.get<any>('https://8080-fcfbaeedfaabacedbefccaeeabbfbebdcacd.examlyiopb.examly.io/Trainer/booking').subscribe(
      response=>{
        this.user = response;
        console.log(this.user);
      }
      );
    }
}

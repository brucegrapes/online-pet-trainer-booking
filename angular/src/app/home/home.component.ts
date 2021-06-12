import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';


export class Trainer{
  constructor(

    public name:string,
    public experience:number,
    public shopName:string,
    public active:string
    ){}
}
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  trainers !: Trainer[];
  
  constructor(private http: HttpClient) { 
  }

  ngOnInit(): void {
    this.getTrainer();
  }
  
  getTrainer(){
    this.http.get<any>('https://8080-fcfbaeedfaabacedbefccaeeabbfbebdcacd.examlyiopb.examly.io/Trainer/').subscribe(
      response => {
        console.log(response);
        this.trainers = response;
      }
    );
  } 
  
}

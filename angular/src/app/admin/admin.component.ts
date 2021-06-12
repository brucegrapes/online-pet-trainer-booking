import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { TrainerService } from '../trainer.service';
import { Tuser } from '../tuser';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  user:Tuser =  new Tuser();
  trainers:Tuser[]=[];
  isEdit:boolean = false;
  constructor(private _service : TrainerService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll() {
    this._service.getTrainer().subscribe(
        resp => {console.log(resp),
        this.trainers = resp;
      });
  }
  
  addTrainer(myform:NgForm):void{
    if(!this.isEdit){
      const newLocal = this._service.registerTrainerFromRemote(this.user).subscribe(
        data => console.log(data),
        error => console.log(error)
      ) 
    }
    else{
        const newLocal = this._service.update(this.user,this.user.trainerId).subscribe(
        data => {console.log(data),
        this.isEdit=false},
        error => console.log(error)
      )
    }
    myform.resetForm();
    this.getAll();
    this.getAll();
  }

  edit(data:Tuser){
    console.log(data.trainerId)
    this.isEdit=true;
    this._service.getOneTrainer(data.trainerId).subscribe(
      resp => {console.log(resp),
      this.user = resp;
    });
  }
  delete(data:Tuser){
    const confirm = window.confirm("Are you sure want to delete?");
    if(confirm){
        this._service.delete(data.trainerId).subscribe(
          resp=>{
            this.getAll();
          }
        )
    }
  }
}

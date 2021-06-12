import { Component, OnInit } from '@angular/core';
import { User} from '../user';
import {SignupService} from '../signup.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2'
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  user = new User();
  constructor(private _service : SignupService,private router : Router) { }

  ngOnInit(): void {
  }
  
  registerUser(){
    const newLocal = this._service.registerUserFromRemote(this.user).subscribe(
      data => {console.log(data)
        if(!data.status){
         this.router.navigate(['/login']);
        }
        else{
          Swal.fire('Oops...', 'Account already registered!!!', 'error')
        }
      },
      error => console.log("exception occured")
    )
  }
}

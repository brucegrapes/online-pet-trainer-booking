import { Component, OnInit } from '@angular/core';
import { RouterLink,Router } from '@angular/router';
import { RegUser} from '../reg-user';
import {SigninService} from '../signin.service';
import Swal from 'sweetalert2'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user = new RegUser();
  constructor(private _service : SigninService,private router : Router) { }
  
  ngOnInit(): void {
  }
  loginUser(){
    const newLocal = this._service.loginUserFromRemote(this.user).subscribe(
      data => {console.log(data)
      if(data.role=="Admin" ){
        this.router.navigate(['/admin']);
      }
      else if(data.role=="Pet Owner"){
        this.router.navigate(['/home']);
      }
      else{
        Swal.fire('Oops...', 'Invalid username or password!', 'error')
      }
    },
      error => console.log("exception occured"),
    )
  }
}

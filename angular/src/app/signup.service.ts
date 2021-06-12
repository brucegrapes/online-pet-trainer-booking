import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User} from './user';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private _http : HttpClient) { }

  public registerUserFromRemote(user : User) : Observable<any>{
    return this._http.post("https://8080-fcfbaeedfaabacedbefccaeeabbfbebdcacd.examlyiopb.examly.io/signup",user);
 }
}

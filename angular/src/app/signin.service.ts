import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { RegUser } from './reg-user';
@Injectable({
  providedIn: 'root'
})
export class SigninService {

  constructor(private _http : HttpClient) { }

  public loginUserFromRemote(user : RegUser) : Observable<any>{
    return this._http.post("https://8080-fcfbaeedfaabacedbefccaeeabbfbebdcacd.examlyiopb.examly.io/login",user);
 }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tuser } from './tuser';

@Injectable({
  providedIn: 'root'
})
export class TrainerService {

  constructor(private _http : HttpClient) { }

 registerTrainerFromRemote(user : Tuser) : Observable<any>{
    return this._http.post("https://8080-fcfbaeedfaabacedbefccaeeabbfbebdcacd.examlyiopb.examly.io/Admin/add",user);
 }

 update(user:Tuser,trainerId:any) : Observable<any>{
  return this._http.put("https://8080-fcfbaeedfaabacedbefccaeeabbfbebdcacd.examlyiopb.examly.io/Admin/update"+"/"+ trainerId,user);
} 

 getTrainer():Observable<Tuser[]>{
  return this._http.get<Tuser[]>("https://8080-fcfbaeedfaabacedbefccaeeabbfbebdcacd.examlyiopb.examly.io/Trainer");
 }

 getOneTrainer(trainerId:any):Observable<Tuser>{
  return this._http.get<Tuser>("https://8080-fcfbaeedfaabacedbefccaeeabbfbebdcacd.examlyiopb.examly.io/Admin/get"+ "/" + trainerId);
 }
 delete(trainerId:any):Observable<Tuser>{
  return this._http.delete<Tuser>("https://8080-fcfbaeedfaabacedbefccaeeabbfbebdcacd.examlyiopb.examly.io/Admin/remove"+ "/" + trainerId);
 }
}

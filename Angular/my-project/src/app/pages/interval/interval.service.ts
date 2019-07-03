import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginService } from 'src/app/auth/login.service';
import { environment } from 'src/environments/environment';
import { catchError } from 'rxjs/operators';

export interface Interval {
    idInterval?: number;
    name: string;
    start: Date; 
    end: Date
    childrens: Interval[];
}
const API_URL =environment.apiEndpoint+"/api/intervals"

@Injectable()
export class IntervalService {
    constructor( private http: HttpClient,public loginService: LoginService,) {}

    getIntervals(): Observable<Interval[]>{
        return this.http.get<Interval[]>(API_URL+"/", { withCredentials: false }).pipe(catchError((error) => this.handleError(error)));
    }
    deleteInterval(elem: Interval):Observable<Interval>{
        return this.http.delete<Interval>(API_URL + "/delete/"+elem.idInterval,{ withCredentials: false }) .pipe(catchError((error) => this.handleError(error)));
    }
    createInterval(elem: Interval): Observable<Interval> {
        const body = JSON.stringify(elem);
        const headers = new HttpHeaders({
            'Content-Type': 'application/json',
        });
        return this.http.post<Interval>(API_URL + "/create", body, { headers }).pipe(catchError((error) => this.handleError(error)));
    }
    private handleError(error: any) {
        console.error(error);
        return Observable.throw('Server error (' + error.status + '): ' + error);
      }
}

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { LoginService } from 'src/app/auth/login.service';
import { environment } from 'src/environments/environment';
import { catchError } from 'rxjs/operators';

export interface Event {
    id?: number;
    nombre: string;
}
const API_URL =environment.apiEndpoint+"/api/events"

@Injectable()
export class EventService {
    constructor( private http: HttpClient,public loginService: LoginService,) {}

    getIntervals(): Observable<Event[]>{
        return this.http.get<Event[]>(API_URL+"/", { withCredentials: true }).pipe(catchError((error) => this.handleError(error)));
    }
    private handleError(error: any) {
        console.error(error);
        return Observable.throw('Server error (' + error.status + '): ' + error);
      }
}

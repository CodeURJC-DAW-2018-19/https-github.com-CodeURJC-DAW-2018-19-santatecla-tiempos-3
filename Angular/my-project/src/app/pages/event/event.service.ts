import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { LoginService } from 'src/app/auth/login.service';
import { environment } from 'src/environments/environment';
import { catchError } from 'rxjs/operators';

export interface Event {
    idEvent?: number;
    name: string;
    eventPhoto: string;
    eventWiki: string;
    eventDate: string;

}
const API_URL = environment.apiEndpoint + "/api/events"

@Injectable()
export class EventService {
    constructor(private http: HttpClient, public loginService: LoginService, ) { }

    getEvents(): Observable<Event[]> {
        return this.http.get<Event[]>(API_URL + "/", { withCredentials: false }).pipe(catchError((error) => this.handleError(error)));
    }
    deleteEvent(elem: Event): Observable<Event> {
        return this.http.delete<Event>(API_URL + "/delete/" + elem.idEvent, { withCredentials: false }).pipe(catchError((error) => this.handleError(error)));
    }
    createEvent(elem: Event): Observable<Event> {
        const body = JSON.stringify(elem);
        const headers = new HttpHeaders({
            'Content-Type': 'application/json',
        });
        return this.http.post<Event>(API_URL + "/create", body, { headers }).pipe(catchError((error) => this.handleError(error)));
    }
    setEvent(id: number, elem: Event): Observable<Event> {
        const body = JSON.stringify(elem);
        const headers = new HttpHeaders({
            'Content-Type': 'application/json',
        });
        return this.http.post<Event>(API_URL + "/set/"+id, body, { headers }).pipe(catchError((error) => this.handleError(error)));
    }
    private handleError(error: any) {
        console.error(error);
        return Observable.throw('Server error (' + error.status + '): ' + error);
    }
}

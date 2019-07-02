import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { LoginService } from '../../auth/login.service';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

export interface Category {
    idCategory?: number;
    name: string;
    events: Event[];
}
const API_URL = environment.apiEndpoint + "/api/categories"
@Injectable()
export class CategoryService {
    constructor(private http: HttpClient, public loginService: LoginService, ) { }
    
    getCategories(): Observable<Category[]> {
        return this.http.get<Category[]>(API_URL + "/", { withCredentials: false }).pipe(catchError((error) => this.handleError(error)));
    }
    deleteCategory(elem: Category):Observable<Category>{
        return this.http.delete<Category>(API_URL + "/delete/"+elem.idCategory,{ withCredentials: false }) .pipe(catchError((error) => this.handleError(error)));
    }

    private handleError(error: any) {
        console.error(error);
        return Observable.throw('Server error (' + error.status + '): ' + error);
    }

}

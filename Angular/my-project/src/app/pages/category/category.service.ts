import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

export interface Category {
    id?: number;
    nombre: string;
}
const API_URL ="https://localhost:8443/api/categories"
@Injectable()
export class CategoryService {
    constructor( private http: HttpClient) {}

    getCategories(): Observable<any>{
        return this.http.get(API_URL+"/");
    }
}

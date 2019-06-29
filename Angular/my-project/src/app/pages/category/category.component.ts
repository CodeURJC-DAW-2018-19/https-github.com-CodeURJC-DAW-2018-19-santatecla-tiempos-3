import { Component, OnInit} from '@angular/core';
import { Category, CategoryService } from './category.service';
import { Router } from '@angular/router';
import { TdDialogService } from '@covalent/core';
import { LoginService } from 'src/app/auth/login.service';

@Component({
    selector: 'category-view',
    templateUrl: './category.component.html',
    styleUrls: ['./category.component.css'],
})

export class CategoryComponent{
/* 
    constructor(private router: Router, private service: CategoryService,private _dialogService: TdDialogService,
        public loginService: LoginService) { }
    
      ngOnInit() {
       this.service.getAuthorsPageable(0).subscribe(
          authors => this.authors = authors,
          error => console.log(error)
        );
      }*/
}

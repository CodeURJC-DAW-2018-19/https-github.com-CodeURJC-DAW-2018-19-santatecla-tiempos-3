import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material';
import { CategoryService, Category } from './category.service';

/**
 * CATEGORY VIEW
 */
@Component({
    selector: 'category-view',
    templateUrl: './category.component.html',
    styleUrls: ['./category.component.css'],
})


export class CategoryComponent implements OnInit {
    constructor(public dialog: MatDialog, private service: CategoryService) { }
    categories: Category[];
    name: string;
    headers = ["#id", "Nombre"];
    ngOnInit(): void {
        this.service.getCategories().subscribe(
            result => {
                this.categories = result;
                console.log(result);
            },
            error => {
                console.log(<any>error);
            }
        )
    }
    openDialogAddCategory(): void {
        this.dialog.open(DialogAddCategory, {

        });
    }
    openDialogShowCategory(elem: Category): void {
        console.log(elem);
        this.dialog.open(DialogShowCategory, {
            width: '250px',
            data: elem
        });
    }
}

/**
 * DIALOG ADD CATEGORY
 */
@Component({
    selector: 'dialog-add-category',
    templateUrl: 'dialog-add-category.html',
})
export class DialogAddCategory {
    constructor(@Inject(MAT_DIALOG_DATA) public data: Category) { }
}

/**
 * DIALOG SHOW CATEGORY
 */
@Component({
    selector: 'dialog-show-category',
    templateUrl: 'dialog-show-category.html',
})
export class DialogShowCategory{
    constructor(@Inject(MAT_DIALOG_DATA) public data: Category) { }
}
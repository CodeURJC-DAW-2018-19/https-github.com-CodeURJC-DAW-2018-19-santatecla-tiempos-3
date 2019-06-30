import { Component, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { CategoryService } from './category.service';

export interface DialogData {
    name: string;
}
/**
 * CATEGORY VIEW
 */
@Component({
    selector: 'category-view',
    templateUrl: './category.component.html',
    styleUrls: ['./category.component.css'],
})


export class CategoryComponent {
    constructor(public dialog: MatDialog, private service: CategoryService) { }
   elements = [
        { i: 1, name: 'Categoría 1' },
        { i: 2, name: 'Categoría 2' },
        { i: 3, name: 'Categoría 3' },
        { i: 4, name: 'Categoría 4' },
        { i: 5, name: 'Categoría 5' },
        { i: 6, name: 'Categoría 6' },
        { i: 7, name: 'Categoría 7' },
        { i: 8, name: 'Categoría 8' },
        { i: 9, name: 'Categoría 9' },
        { i: 10, name: 'Categoría 10' },
    ];

    prueba(){
        
        this.service.getCategories().subscribe(
            result => {
                console.log (result);
            },
            error => {
                console.log(<any>error);
            }
  
        )
    }
    name: string;
    openDialog(): void {
        this.dialog.open(DialogAddCategory, {

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
    constructor(@Inject(MAT_DIALOG_DATA) public data: DialogData) { }
}
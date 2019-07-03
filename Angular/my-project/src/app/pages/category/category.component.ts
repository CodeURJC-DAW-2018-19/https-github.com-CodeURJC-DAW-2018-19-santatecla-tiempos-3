import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { CategoryService, Category } from './category.service';
import { LoginService } from 'src/app/auth/login.service';

/**
 * CATEGORY VIEW
 */
@Component({
    selector: 'category-view',
    templateUrl: './category.component.html',
    styleUrls: ['./category.component.css'],
})


export class CategoryComponent implements OnInit {
    constructor(public dialog: MatDialog, private service: CategoryService, public loginService: LoginService) { }
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
        const dialogRef = this.dialog.open(DialogAddCategory, {
            width: '250px',
            data: { name: this.name }
        });
        dialogRef.afterClosed().subscribe(result => {
            this.service.createCategory(result).subscribe(
                result => {
                    this.ngOnInit();
                },
                error => {
                    console.log(<any>error);
                }
            )
        })
    }
    openDialogSetCategory(id: number): void {
        const dialogRef = this.dialog.open(DialogAddCategory, {
            width: '250px',
            data: { name: this.name }
        });
        dialogRef.afterClosed().subscribe(result => {
            this.service.setCategory(id, result).subscribe(
                result => {
                    this.ngOnInit();
                },
                error => {
                    console.log(<any>error);
                }
            )
        })
    }
    deleteCategory(elem: Category): void {
        this.service.deleteCategory(elem).subscribe(
            result => {
                console.log("Se ha borrado una categoría");
                this.ngOnInit();
            },
            error => {
                console.log(<any>error);
            }
        )
    }
    openDialogShowCategory(elem: Category): void {
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
    constructor(public dialogRef: MatDialogRef<DialogAddCategory>, @Inject(MAT_DIALOG_DATA) public data: Category) { }
}

/**
 * DIALOG SHOW CATEGORY
 */
@Component({
    selector: 'dialog-show-category',
    templateUrl: 'dialog-show-category.html',
})
export class DialogShowCategory {
    constructor(@Inject(MAT_DIALOG_DATA) public data: Category) { }
}
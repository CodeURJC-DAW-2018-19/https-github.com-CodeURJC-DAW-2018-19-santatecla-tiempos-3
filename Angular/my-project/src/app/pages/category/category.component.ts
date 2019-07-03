import { Component, Inject, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef, PageEvent, MatTableDataSource } from '@angular/material';
import { CategoryService, Category } from './category.service';
import { LoginService } from 'src/app/auth/login.service';
import { TdPagingBarComponent, IPageChangeEvent } from '@covalent/core';
import { PagerService } from '../pager.service';

/**
 * CATEGORY VIEW
 */
@Component({
    selector: 'category-view',
    templateUrl: './category.component.html',
    styleUrls: ['./category.component.css'],
})


export class CategoryComponent implements OnInit {
    constructor(public dialog: MatDialog, private service: CategoryService, public loginService: LoginService,private pagerService: PagerService) { }
    pageEvent: PageEvent;
    name: string;
    headers = ["#id", "Nombre"];
    categories: Category[];
    pager: any = {};
    pagedItems: any[];

   
  

    ngOnInit(): void {
        this.service.getCategories().subscribe(
            result => {
                this.categories = result;
                this.setPage(1);

            },
            error => {
                console.log(<any>error);
            }
        )
     
    }
    setPage(page: number) {
        if (page < 1 || page > this.pager.totalPages) {
            return;
        }

        // get pager object from service
        this.pager = this.pagerService.getPager(this.categories.length, page);

        // get current page of items
        this.pagedItems = this.categories.slice(this.pager.startIndex, this.pager.endIndex + 1);
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
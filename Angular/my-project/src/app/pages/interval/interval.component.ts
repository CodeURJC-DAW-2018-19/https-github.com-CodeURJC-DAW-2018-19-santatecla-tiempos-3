import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef, PageEvent } from '@angular/material';
import { IntervalService, Interval } from './interval.service';
import { LoginService } from 'src/app/auth/login.service';
import { PagerService } from '../pager.service';

@Component({
    selector: 'interval-view',
    templateUrl: './interval.component.html',
    styleUrls: ['./interval.component.css'],
})

export class IntervalComponent implements OnInit {
    constructor(public dialog: MatDialog, private service: IntervalService, public loginService: LoginService,private pagerService: PagerService) { }
    headers = ["#id", "Nombre", "Fecha de Inicio", "Fecha de Fin"];
    pageEvent: PageEvent;

    intervals: any[];
    name: string;
    start: Date;
    end: Date;
    pager: any = {};
    pagedItems: any[];
    ngOnInit(): void {
        this.service.getIntervals().subscribe(
            result => {
                this.intervals = result;
                this.setPage(1);

                console.log(result);
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
        this.pager = this.pagerService.getPager(this.intervals.length, page);

        // get current page of items
        this.pagedItems = this.intervals.slice(this.pager.startIndex, this.pager.endIndex + 1);
    }
    openDialogAddInterval(): void {
        const dialogRef = this.dialog.open(DialogAddInterval, {
            width: '250px',
            data: { name: this.name, startdate: this.start, enddate: this.end }
        });
        dialogRef.afterClosed().subscribe(result => {
            result.startdate = result.startdate.toLocaleString();
            result.enddate = result.enddate.toLocaleString();
            console.log(result);
            this.service.createInterval(result).subscribe(
                result => {
                    this.ngOnInit();
                },
                error => {
                    console.log(<any>error);
                }
            )
        })
    }
    openDialogSetInterval(id: number): void {
        const dialogRef = this.dialog.open(DialogAddInterval, {
            width: '250px',
            data: { name: this.name }
        });
        dialogRef.afterClosed().subscribe(result => {
            this.service.setInterval(id, result).subscribe(
                result => {
                    this.ngOnInit();
                },
                error => {
                    console.log(<any>error);
                }
            )
        })
    }
    deleteInterval(elem: Interval): void {
        this.service.deleteInterval(elem).subscribe(
            result => {
                console.log("Se ha borrado un intervalo");
                this.ngOnInit();
            },
            error => {
                console.log(<any>error);
            }
        )
    }
    openDialogShowInterval(elem: Interval): void {
        console.log(elem);
        this.dialog.open(DialogShowInterval, {
            width: '250px',
            data: elem
        });
    }
}

/**
 * DIALOG ADD INTERVAL
 */
@Component({
    selector: 'dialog-add-interval',
    templateUrl: 'dialog-add-interval.html',
})
export class DialogAddInterval {
    constructor(public dialogRef: MatDialogRef<DialogAddInterval>, @Inject(MAT_DIALOG_DATA) public data: Interval) { }
}

/**
 * DIALOG SHOW INTERVAL
 */
@Component({
    selector: 'dialog-show-interval',
    templateUrl: 'dialog-show-interval.html',
})
export class DialogShowInterval {
    constructor(@Inject(MAT_DIALOG_DATA) public data: Interval) { }
}
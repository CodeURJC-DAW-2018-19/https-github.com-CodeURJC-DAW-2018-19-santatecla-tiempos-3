import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material';
import { IntervalService, Interval } from './interval.service';

@Component({
    selector: 'interval-view',
    templateUrl: './interval.component.html',
    styleUrls: ['./interval.component.css'],
})

export class IntervalComponent implements OnInit {
    constructor(public dialog: MatDialog, private service: IntervalService) { }
    headers = ["#id", "Nombre", "Fecha de Inicio", "Fecha de Fin"]
    intervals: any [];
    name: string;
    ini: string;
    fin: string;

    ngOnInit(): void {
        this.service.getIntervals().subscribe(
            result => {
                this.intervals = result;
                console.log(result);
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
    constructor(@Inject(MAT_DIALOG_DATA) public data: Interval) { }
}   

/**
 * DIALOG SHOW INTERVAL
 */
@Component({
    selector: 'dialog-show-interval',
    templateUrl: 'dialog-show-interval.html',
})
export class DialogShowInterval{
    constructor(@Inject(MAT_DIALOG_DATA) public data: Interval) { }
}
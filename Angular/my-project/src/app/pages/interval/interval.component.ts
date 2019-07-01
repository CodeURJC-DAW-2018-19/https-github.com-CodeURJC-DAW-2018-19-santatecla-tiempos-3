import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material';
import { IntervalService } from './interval.service';
export interface DialogData {
    name: string;
    ini: string;
    fin: string;
}
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
    openDialog(): void {
        this.dialog.open(DialogAddInterval, {

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
    constructor(@Inject(MAT_DIALOG_DATA) public data: DialogData) { }
}   
import { Component, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
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

export class IntervalComponent{
    headers = ["#", "Nombre", "Fecha de Inicio", "Fecha de Fin"]
    elements = [
        { i: 1, name: 'Intervalo 1',ini:"FechaInicio",fin:"FechaFin" },
        { i: 2, name: 'Intervalo 2',ini:"FechaInicio",fin:"FechaFin" },
        { i: 3, name: 'Intervalo 3',ini:"FechaInicio",fin:"FechaFin" },
        { i: 4, name: 'Intervalo 4',ini:"FechaInicio",fin:"FechaFin" },
        { i: 5, name: 'Intervalo 5',ini:"FechaInicio",fin:"FechaFin" },
        { i: 6, name: 'Intervalo 6',ini:"FechaInicio",fin:"FechaFin" },
        { i: 7, name: 'Intervalo 7',ini:"FechaInicio",fin:"FechaFin" },
        { i: 8, name: 'Intervalo 8',ini:"FechaInicio",fin:"FechaFin" },
        { i: 9, name: 'Intervalo 9' ,ini:"FechaInicio",fin:"FechaFin"},
        { i: 10, name: 'Intervalo 10',ini:"FechaInicio",fin:"FechaFin" },
    ];
    name: string;
    ini: string;
    fin: string;

    constructor(public dialog: MatDialog) { }
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
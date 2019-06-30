import { Component, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
export interface DialogData {
    name: string;
}
/**
 * EVENT VIEW
 */
@Component({
    selector: 'event-view',
    templateUrl: './event.component.html',
    styleUrls: ['./event.component.css'],
})

export class EventComponent{
    headers = ["#", "Nombre"]
    elements = [
        { i: 1, name: 'Evento 1' },
        { i: 2, name: 'Evento 2' },
        { i: 3, name: 'Evento 3' },
        { i: 4, name: 'Evento 4' },
        { i: 5, name: 'Evento 5' },
        { i: 6, name: 'Evento 6' },
        { i: 7, name: 'Evento 7' },
        { i: 8, name: 'Evento 8' },
        { i: 9, name: 'Evento 9' },
        { i: 10, name: 'Evento 10' },
    ];
    name: string;
    constructor(public dialog: MatDialog) { }
    openDialog(): void {
        this.dialog.open(DialogAddEvent, {

        });
    }
}
/**
 * DIALOG ADD EVENT
 */
@Component({
    selector: 'dialog-add-event',
    templateUrl: 'dialog-add-event.html',
})
export class DialogAddEvent {
    constructor(@Inject(MAT_DIALOG_DATA) public data: DialogData) { }
}   
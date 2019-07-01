import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material';
import { EventService } from './event.service';

/**
 * EVENT VIEW
 */
@Component({
    selector: 'event-view',
    templateUrl: './event.component.html',
    styleUrls: ['./event.component.css'],
})

export class EventComponent implements OnInit {
    constructor(public dialog: MatDialog, private service: EventService) { }
    events: any[];
    headers = ["#id", "Nombre"];
    name: string;
    ngOnInit(): void {
        this.service.getEvents().subscribe(
            result => {
                this.events = result;
                console.log(this.events);
            },
            error => {
                console.log(<any>error);
            }
        )
    }

    openDialog(): void {
        this.dialog.open(DialogAddEvent, {

        });
       
    }
    openDialogShowEvent(elem: Event): void {
        this.dialog.open(DialogShowEvent, {
            width: '250px',
            data: elem
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
    constructor(@Inject(MAT_DIALOG_DATA) public data: Event) { }
}

/**
 * DIALOG SHOW EVENT
 */
@Component({
    selector: 'dialog-show-event',
    templateUrl: 'dialog-show-event.html',
})
export class DialogShowEvent {
    constructor(@Inject(MAT_DIALOG_DATA) public data: Event) { }
}
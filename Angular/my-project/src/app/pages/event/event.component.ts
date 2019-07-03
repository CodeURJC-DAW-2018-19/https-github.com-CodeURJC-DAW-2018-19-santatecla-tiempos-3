import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { EventService, Event } from './event.service';
import { LoginService } from 'src/app/auth/login.service';

/**
 * EVENT VIEW
 */
@Component({
    selector: 'event-view',
    templateUrl: './event.component.html',
    styleUrls: ['./event.component.css'],
})

export class EventComponent implements OnInit {
    constructor(public dialog: MatDialog, private service: EventService, public loginService: LoginService) { }
    events: any[];
    headers = ["#id", "Nombre"];
    name: String;
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

    openDialogAddEvent(): void {
        const dialogRef = this.dialog.open(DialogAddEvent, {
            width: '250px',
            data: { name: this.name }
        });
        dialogRef.afterClosed().subscribe(result => {
            console.log(result);

            this.service.createEvent(result).subscribe(
                result => {
                    this.ngOnInit();
                },
                error => {
                    console.log(<any>error);
                }
            )
        })
    }
    openDialogSetEvent(id: number): void {
        const dialogRef = this.dialog.open(DialogAddEvent, {
            width: '250px',
            data: { name: this.name }
        });
        dialogRef.afterClosed().subscribe(result => {
            this.service.setEvent(id, result).subscribe(
                result => {
                    this.ngOnInit();
                },
                error => {
                    console.log(<any>error);
                }
            )
        })
    }
    deleteEvent(elem: Event): void {
        this.service.deleteEvent(elem).subscribe(
            result => {
                console.log("Se ha borrado un evento");
                this.ngOnInit();
            },
            error => {
                console.log(<any>error);
            }
        )
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
    constructor(public dialogRef: MatDialogRef<DialogAddEvent>, @Inject(MAT_DIALOG_DATA) public data: Event) { }
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
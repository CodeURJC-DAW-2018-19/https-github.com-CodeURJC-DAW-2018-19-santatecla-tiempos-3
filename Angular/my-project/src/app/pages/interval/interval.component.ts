import { Component} from '@angular/core';

@Component({
    selector: 'interval-view',
    templateUrl: './interval.component.html',
    styleUrls: ['./interval.component.css'],
})

export class IntervalComponent{
    headers = ["#", "Nombre", "Fecha de Inicio", "Fecha de Fin"]
    elements = [
        { i: 1, name: 'Categoría 1',ini:"FechaInicio",fin:"FechaFin" },
        { i: 2, name: 'Categoría 2',ini:"FechaInicio",fin:"FechaFin" },
        { i: 3, name: 'Categoría 3',ini:"FechaInicio",fin:"FechaFin" },
        { i: 4, name: 'Categoría 4',ini:"FechaInicio",fin:"FechaFin" },
        { i: 5, name: 'Categoría 5',ini:"FechaInicio",fin:"FechaFin" },
        { i: 6, name: 'Categoría 6',ini:"FechaInicio",fin:"FechaFin" },
        { i: 7, name: 'Categoría 7',ini:"FechaInicio",fin:"FechaFin" },
        { i: 8, name: 'Categoría 8',ini:"FechaInicio",fin:"FechaFin" },
        { i: 9, name: 'Categoría 9' ,ini:"FechaInicio",fin:"FechaFin"},
        { i: 10, name: 'Categoría 10',ini:"FechaInicio",fin:"FechaFin" },
    ];
}
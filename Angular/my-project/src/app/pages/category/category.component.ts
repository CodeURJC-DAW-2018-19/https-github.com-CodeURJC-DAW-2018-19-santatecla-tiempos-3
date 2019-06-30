import { Component } from '@angular/core';



@Component({
    selector: 'category-view',
    templateUrl: './category.component.html',
    styleUrls: ['./category.component.css'],
})

export class CategoryComponent {
    headers = ["#", "Nombre"]
    elements = [
        { i: 1, name: 'Categoría 1' },
        { i: 2, name: 'Categoría 2' },
        { i: 3, name: 'Categoría 3' },
        { i: 4, name: 'Categoría 4' },
        { i: 5, name: 'Categoría 5' },
        { i: 6, name: 'Categoría 6' },
        { i: 7, name: 'Categoría 7' },
        { i: 8, name: 'Categoría 8' },
        { i: 9, name: 'Categoría 9' },
        { i: 10, name: 'Categoría 10' },
    ];
}


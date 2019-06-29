import { RouterModule } from '@angular/router';

import { CategoryComponent } from "./pages/category/category.component";


const appRoutes = [
 {path: '', component: CategoryComponent, useAsDefault:true},
];

export const routing = RouterModule.forRoot(appRoutes);
 
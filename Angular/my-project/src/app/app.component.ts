import { Component, ChangeDetectorRef, AfterViewInit, ViewChild, TemplateRef } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { MatIconRegistry, MatDialog } from '@angular/material';
import { TdMediaService, TdLayoutManageListComponent } from '@covalent/core';


@Component({
    selector: 'my-app',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css'],
})
export class AppComponent implements AfterViewInit {

    @ViewChild('manageList') manageList: TdLayoutManageListComponent;
    @ViewChild('dialogContent') template: TemplateRef<any>;
  
    // Dialog
    config = {
      width: '50%',
      height: '50%',
    };
  
    constructor(public media: TdMediaService,
                public dialog: MatDialog,
                private _changeDetectorRef: ChangeDetectorRef,
                private _iconRegistry: MatIconRegistry,
                private _domSanitizer: DomSanitizer) {
                  
                this._iconRegistry.addSvgIconInNamespace('assets', 'covalent',
                this._domSanitizer.bypassSecurityTrustResourceUrl
            ('https://raw.githubusercontent.com/Teradata/covalent-quickstart/develop/src/assets/icons/covalent.svg'));
    } 

    changeView(view){
      document.getElementById("category_view").style.display = "none";
      document.getElementById("event_view").style.display = "none";
      document.getElementById("interval_view").style.display = "none";
      document.getElementById(view+"_view").style.display = "block";
    }



    ngAfterViewInit(): void {
      // broadcast to all listener observables when loading the page
      this.media.broadcast();
      this._changeDetectorRef.detectChanges();
    }

  
    openTemplate() {
      this.dialog.open(this.template, this.config);
    }
  
    

}

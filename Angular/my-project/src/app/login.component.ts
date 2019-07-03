import { Component, Inject } from "@angular/core";
import { LoginService } from "./auth/login.service";
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material';
import { Router } from '@angular/router';

export interface DialogData {
  email: string;
  password: string;
}
@Component({
  selector: 'login',
  templateUrl: './login.component.html',
})
export class LoginComponent {
  constructor(public dialog: MatDialog, public router: Router, public loginService: LoginService) { }
  loginDialogFormat={
    email:String,
    password: String
  }
  nameLogged :string; 
 // email: string;
 // password: string;
  openLoginDialog(): void {
    const dialogRef = this.dialog.open(DialogLoginComponent, {
      width: '250px',
      data: { email: this.loginDialogFormat.email, password: this.loginDialogFormat.password }
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.login(result.email, result.password);
    });
  }

  login(email: string, password: string) {
    this.loginService.logIn(email, password).subscribe(
      (response) => {
        console.log(response);
        this.nameLogged = response.name; 
      },
      (error) => alert('Invalid user or password'),
    );
  }

  logout() {
    this.loginService.logOut().subscribe(
      (response) => {
        this.router.navigate(['/']);
      },
      (error) => console.log("Error en el logout" + error),
    );
  }

}


/**
 * DIALOG LOGIN/REGISTER
 */
@Component({
  selector: 'dialog-login',
  templateUrl: './dialog-login.html',
})
export class DialogLoginComponent {
  constructor(public dialogRef: MatDialogRef<DialogLoginComponent>, @Inject(MAT_DIALOG_DATA) public data: DialogData,public loginService: LoginService ) { }
}
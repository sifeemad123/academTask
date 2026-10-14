import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import {
  FormBuilder,
  FormGroup,
  Validators,
  ReactiveFormsModule
} from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterLink],
 templateUrl: './login.html',
styleUrl: './login.css'
})
export class LoginComponent {
  loginForm: FormGroup;
  submitted = false;
  loading = false;
  errorMessage = '';
  successMessage = '';
 

  constructor(
    private fb: FormBuilder, private router: Router
  )
   {
    this.loginForm = this.fb.group({
      email: [
        '',
        [
          Validators.required,
          Validators.email
        ]
      ],
      password: [
        '',
        [
          Validators.required,
          Validators.minLength(8)
        ]
      ],
      rememberMe: [false]
    });
  }


get f() {
  return this.loginForm.controls;
}

login(): void {
  this.errorMessage = '';
  this.successMessage = '';

  if (this.loginForm.invalid) {
    this.loginForm.markAllAsTouched();
    return;
  }

   this.router.navigate(['/StudentsComponent']);

  const { email, password, rememberMe } =
    this.loginForm.getRawValue();

  console.log({ email, rememberMe });

  // Connect to your authentication API here.

  this.loading = false;
}

}

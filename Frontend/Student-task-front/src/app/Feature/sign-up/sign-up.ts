import { Component, inject, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { SignUpService } from '../../core/Service/sign-up';

@Component({
  imports: [RouterLink,FormsModule,CommonModule],
  selector: 'app-sign-up',
  styleUrl: './sign-up.css',
  templateUrl: './sign-up.html',
})
export class SignUp implements OnInit{

constructor(private router: Router) {}
  private service =inject(SignUpService);
  public signUpData = {
    name:'',
    email:'',
    password:'',
  };
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  confirmPassword:string='';
  loading = false;
  createAccount() {
  if (
    !this.signUpData.name ||
    !this.signUpData.email ||
    !this.signUpData.password ||
    !this.confirmPassword
  ) {
    return;
  }

  if (this.signUpData.name.length < 3) {
    return;
  }

  if (this.signUpData.password.length < 8) {
    return;
  }

  if (this.signUpData.password !== this.confirmPassword) {
    return;
  }else{
    this.router.navigate(['/StudentsComponent']);
  }
    this.loading = true;
    this.service.CreateAccount(this.signUpData).subscribe({
next:()=>{
  this.loading = false;
  alert('Account created successfully');
},  
error:(err)=>{
        console.error(err);
        this.loading=false;
      },
      complete:()=>{
        this.loading=false;
      },
})
  }
  
}
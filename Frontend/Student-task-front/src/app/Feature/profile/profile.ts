import { Component, inject, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { StudentProfile } from '../../core/Service/student-profile';
import { Observable } from 'rxjs/internal/Observable';
import { StudentprofileResponse } from '../../core/Model/StudentInterface/studentprofile-response';

@Component({
  imports: [RouterLink],
  selector: 'app-profile',
  styleUrl: './profile.css',
  templateUrl: './profile.html',
})
export class Profile implements OnInit {
  private service = inject(StudentProfile);
  profile:StudentprofileResponse[] = [];
  ngOnInit(): void {
    this.loadProfile();
  }
  
  loadProfile() {
    this.service.LoadProfile({}).subscribe({
      next: (response) => {
        this.profile = response;
      }
    });
  }
  deleteAccount(id: number): Observable<void> {
    return this.service.deleteAccount(id);
  }
}

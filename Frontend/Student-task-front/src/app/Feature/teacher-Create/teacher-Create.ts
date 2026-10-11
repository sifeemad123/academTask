import { Component, inject, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TeacherService } from '../../core/Service/teacher-service';
import { TeacherResponse } from '../../core/Model/teacherInterface/teacherResponse';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-teacher-Create',
  imports: [FormsModule, RouterLink],
  templateUrl: './teacher-Create.html',
  styleUrl: './teacher-Create.css',
})
export class TeacherProfile implements OnInit {
  private service = inject(TeacherService);

  Teachers: TeacherResponse[] = [];

  public teacherData = {
    firstName: '',
    lastName: '',
    email: '',
    phone: '',
  };

  loading = false;

  ngOnInit(): void {
    this.loadTeachers();
  }

  CreateTeacher() {
    this.loading = true;

    console.log(this.teacherData);

    this.service.createTeacher(this.teacherData).subscribe({
      next: (data) => {
        alert('User creation complete');
        console.log(data + 'from method ');
        this.loadTeachers();
      },

      error: (err) => {
        console.error(err);
        this.loading = false;
      },

      complete: () => {
        this.loading = false;
      },
    });
  }

  loadTeachers() {
    this.loading = true;

    this.service.loadTeachers().subscribe({
      next: (data) => {
        this.Teachers = data;
      },

      error: (err) => {
        console.error(err);
        this.loading = false;
      },

      complete: () => {
        this.loading = false;
      },
    });
  }

  deleteTeacher(id: number) {
    this.service.deleteTeacher(id).subscribe({
      next: () => {
        this.loadTeachers();
      },

      error: (err) => {
        console.error(err);
      },
    });
  }
}

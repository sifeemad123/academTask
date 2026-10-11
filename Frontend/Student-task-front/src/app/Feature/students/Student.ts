import { Component, inject, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { StudentService } from '../../core/Service/student-service';
import { StudentResponse } from '../../core/Model/StudentInterface/studentsResponse';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-Student',
  imports: [FormsModule,RouterLink],
  templateUrl: './Student.html',
  styleUrl: './Student.css',
})
export class StudentsComponent implements OnInit {

  private service = inject(StudentService);

  Students: StudentResponse[] = [];

  public studentData = {
    firstName: '',
    lastName: '',
    email: '',
    password: '',
  };

  loading = false;

  ngOnInit(): void {
    this.loadStudents();
  }

  CreateStudent() {
    this.loading = true;

    console.log(this.studentData);

    this.service.createStudent(this.studentData).subscribe({
      next: (data) => {
        alert('User creation complete');
        console.log(data + "from method ")
        this.loadStudents();
      },

      error: (err) => {
        console.error(err);
        this.loading = false;
      },

      complete: () => {
        this.loading = false;
      }
    });
  }

  loadStudents() {
    this.loading = true;

    this.service.loadStudents().subscribe({
      next: (data) => {
        this.Students = data;
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

  deleteStudent(id: number) {
    this.service.deleteStudent(id).subscribe({
      next: () => {
        this.loadStudents();
      },

      error: (err) => {
        console.error(err);
      }
    });
  }
}
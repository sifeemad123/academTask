import { Component, inject, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

import { StudentService } from '../../core/Service/student-service';
import { StudentResponse } from '../../core/Model/StudentInterface/studentsResponse';

@Component({
  selector: 'app-Student',
  standalone: true,
  imports: [FormsModule, RouterLink],
  templateUrl: './Student.html',
  styleUrl: './Student.css',
})
export class StudentsComponent implements OnInit {

  private service = inject(StudentService);

  Students: StudentResponse[] = [];

  studentData = {
    firstName: '',
    lastName: '',
    email: '',
    password: '',
  };

  loading = false;

  ngOnInit(): void {
    this.loadStudents();
  }

  // Load all students
  loadStudents(): void {
    this.loading = true;

    this.service.loadStudents().subscribe({
      next: (data) => {
        this.Students = data;
      },
      error: (err) => {
        console.error('Error loading students:', err);
        this.loading = false;
      },
      complete: () => {
        this.loading = false;
      },
    });
  }

  // Create a new student
  CreateStudent(): void {
    this.loading = true;

    this.service.createStudent(this.studentData).subscribe({
      next: (data) => {
        console.log('Student created:', data);
        alert('User creation complete');

        this.studentData = {
          firstName: '',
          lastName: '',
          email: '',
          password: '',
        };

        this.loadStudents();
      },
      error: (err) => {
        console.error('Error creating student:', err);
        this.loading = false;
      },
      complete: () => {
        this.loading = false;
      },
    });
  }

  // Delete a student
  deleteStudent(id: number): void {
    this.service.deleteStudent(id).subscribe({
      next: () => {
        this.loadStudents();
      },
      error: (err) => {
        console.error('Error deleting student:', err);
      },
    });
  }
}
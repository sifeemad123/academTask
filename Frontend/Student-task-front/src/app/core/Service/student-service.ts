import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { StudentResponse } from '../Model/StudentInterface/studentsResponse';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl = 'http://localhost:8081/API/V1/Students';

  private http = inject(HttpClient);

  loadStudents(): Observable<StudentResponse[]> {
    return this.http.get<StudentResponse[]>(this.baseUrl);
  }

  deleteStudent(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  createStudent(data: any): Observable<StudentResponse> {
    return this.http.post<StudentResponse>(this.baseUrl, data);
  }
}

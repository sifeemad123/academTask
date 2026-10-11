import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { TeacherResponse } from '../Model/teacherInterface/teacherResponse';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {
  private baseUrl = 'http://localhost:8081/API/V1/Teacher';
  private http = inject(HttpClient);

  loadTeachers() {
    return this.http.get<TeacherResponse[]>(this.baseUrl);
  }

  deleteTeacher(id: number) {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  createTeacher(data: any) {
    return this.http.post<TeacherResponse>(this.baseUrl, data);
  }



}

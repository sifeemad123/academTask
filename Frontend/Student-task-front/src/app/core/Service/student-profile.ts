import { HttpClient } from '@angular/common/http';
import { inject, Service } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { StudentprofileResponse } from '../Model/StudentInterface/studentprofile-response';

@Service()
export class StudentProfile {
      private baseUrl = 'http://localhost:8081/API/V1/Students';

  private http = inject(HttpClient);

LoadProfile(data: any): Observable<StudentprofileResponse[]> {
     return this.http.get<StudentprofileResponse[]>(this.baseUrl);
  }

  deleteAccount(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}

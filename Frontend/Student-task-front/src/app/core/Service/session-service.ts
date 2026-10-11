import { inject, Service } from '@angular/core';
import { Session } from '../Model/SessionInterface/session-Interface';
import { HttpClient } from '@angular/common/http';
@Service()
export class SessionService {
  private baseUrl = 'http://localhost:8081/API/V1/Sessions';
  private http = inject(HttpClient);

  loadSessions(){
    return this.http.get<Session[]>(this.baseUrl);
  }

  deleteSession(id: number){
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  createSession(data: any){
    return this.http.post<Session>(this.baseUrl, data);
  }
  

}

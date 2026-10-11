import { HttpClient } from '@angular/common/http';
import { inject, Injectable, Service } from '@angular/core';
import { TeamResponse } from '../Model/TeamInterface/team-response';

@Injectable({
  providedIn: 'root'
})
export class TeamService {
    private baseUrl ='http://localhost:8081/API/V1/Teams';
    private http = inject(HttpClient);
    
    loadTeams() {
        return this.http.get<TeamResponse[]>(this.baseUrl)
    }
    createTeam(data: any) {
        return this.http.post<TeamResponse>(this.baseUrl,data)
    }
    deleteTeam(id: number) {
        return this.http.delete<void>(`${this.baseUrl}/${id}`)
    }
}

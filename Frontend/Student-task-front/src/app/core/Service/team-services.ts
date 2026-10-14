
import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TeamResponse } from '../Model/TeamInterface/team-response';
import { TeamRequst } from '../Model/TeamInterface/team-requst';
@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private http = inject(HttpClient);

  private apiUrl = 'http://localhost:8081/API/V1/Team';



createTeam(team: any) {
  return this.http.post(this.apiUrl, team);
}

loadTeams() {
  return this.http.get<TeamResponse[]>(this.apiUrl);
}

deleteTeam(id: number) {
  return this.http.delete(`${this.apiUrl}/${id}`);
}

}

import { Component, inject, OnInit, signal } from '@angular/core';
import { Session } from '../../core/Model/SessionInterface/session-Interface';
import { SessionService } from '../../core/Service/session-service';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { TeamResponse } from '../../core/Model/TeamInterface/team-response';
import { TeamService } from '../../core/Service/team-services';
@Component({
  imports: [RouterLink,FormsModule],
  selector: 'app-create-session',
  styleUrl: './create-session.css',
  templateUrl: './create-session.html',
})
export class CreateSession implements OnInit{
    private service = inject(SessionService);

    today: string = this.getTodayDate();

getTodayDate(): string {
  const date = new Date();
  const year = date.getFullYear();
  const month = String(date.getMonth() + 1).padStart(2, '0');
  const day = String(date.getDate()).padStart(2, '0');

  return `${year}-${month}-${day}`;
}

    Sessions = signal<Session[]>([]);

    public sessionData = {
    startDate: '',
    endDate: '',
    isActive: '',
    teams: '',
    }

    loading = false;

    ngOnInit(): void {
      this.loadSession();
      this.loadTeams();
    }

    CreateSession(){
      this.loading = true;

      console.log(this.sessionData);
       if (!this.sessionData.startDate || this.sessionData.startDate < this.today) {
    alert('Start date cannot be before today!');
    return;
  }


      this.service.createSession(this.sessionData).subscribe({
        next: (data) =>{
          alert('Session create complete');
          console.log(data + 'from method');
          this.loadSession();
        },
        error: (err) =>{
          console.error(err);
          this.loading = false;
        },
        complete: ()=>{
          this.loading = false;
        },

      });
    }

      loadSession() {
        this.loading = true;

        this.service.loadSessions().subscribe({
          next:(data) => {
            this.Sessions.set(data);
          },
          error: (err) =>{
            console.error(err);
            this.loading = false;
          },
          complete: () => {
            this.loading = false;
          },
        });
      }

      deleteSession(id: number){
        this.service.deleteSession(id).subscribe({
          next: () => {
            this.loadSession();
          },
          error: (err) => {
            console.error(err);
          },
        });

      }


      Teams: TeamResponse[] = [];

  constructor(private teamService: TeamService) {}

  loadTeams(): void {
    this.teamService.getTeams().subscribe({
      next: (data) => {
        this.Teams = data;
        console.log('Teams loaded:', data);
      },
      error: (err) => {
        console.error('Error loading teams:', err);
      }
    });
  }
    }




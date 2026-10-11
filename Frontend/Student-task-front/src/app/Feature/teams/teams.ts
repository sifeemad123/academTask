import { Component, inject, OnInit } from '@angular/core';
import { TeamResponse } from '../../core/Model/TeamInterface/team-response';
import { TeamService } from '../../core/Service/team-service';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [FormsModule,RouterLink],
  selector: 'app-teams',
  templateUrl: './teams.html',
  styleUrl: './teams.css',
})
export class Teams implements OnInit {
  teams:TeamResponse[]=[];
  private service =inject(TeamService);
  public teamData = {
    id:'',
    name: '',
    students: [],
  };
  ngOnInit(): void {
    this.loadTeams();
  }
loading = false;
  CreateTeam() {
    this.loading = true;
    this.service.createTeam(this.teamData).subscribe({
      next:(data)=>{
        alert('Team cration complete');
        console.log(data + 'from method');
        this.loadTeams();
      },
      error:(err)=>{
        console.error(err);
        this.loading=false;
      },
      complete:()=>{
        this.loading=false;
      },
    });
  }
loadTeams() {
    this.loading = true;
    this.service.loadTeams().subscribe({
      next:(data)=>{
        this.teams=data;
      },
      error:(err)=>{
        console.error(err);
    this.loading=false;
      },
      complete:()=>{
        this.loading=false;
      },
    })
}
deleteTeam(id:number){
  this.loading=true;
  this.service.deleteTeam(id).subscribe({
    next:(data)=>{
      this.loadTeams();
    },
    error:(err)=>{
      console.error(err); 
    }
  })
}
}
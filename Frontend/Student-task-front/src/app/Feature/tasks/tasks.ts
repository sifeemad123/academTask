import { Component, inject } from '@angular/core';
import { TasksResponse } from '../../core/Model/Tasks/tasks-response';
import { TasksRequst } from '../../core/Model/Tasks/tasks-requst';
import { TaskService } from '../../core/Service/task-service';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  imports: [FormsModule,RouterLink],
  selector: 'app-tasks',
  styleUrl: './tasks.css',
  templateUrl: './tasks.html',
})
export class Tasks {
    tasks:TasksResponse[]=[];
  private service =inject(TaskService);
  public taskData = {
      id:'',
    task:Map<string,TasksRequst>,
  };
  ngOnInit(): void {
    this.loadTasks();
  }
loading = false;
  CreateTasks() {
    this.loading = true;
    this.service.createTasks(this.taskData).subscribe({
      next:(data)=>{
        alert('Team cration complete');
        console.log(data + 'from method');
        this.loadTasks();
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
loadTasks() {
    this.loading = true;
    this.service.loadTasks().subscribe({
      next:(data)=>{
        this.tasks=data;
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
deleteTasks(id:number){
  this.loading=true;
  this.service.deleteTasks(id).subscribe({
    next:(data)=>{
      this.loadTasks();
    },
    error:(err)=>{
      console.error(err); 
    }
  })
}
}

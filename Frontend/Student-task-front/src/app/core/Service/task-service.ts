import { inject, Injectable, Service } from '@angular/core';
import { TasksResponse } from '../Model/Tasks/tasks-response';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
        private baseUrl ='http://localhost:8081/API/V1/Team';
    private http = inject(HttpClient);

    loadTasks() {
        return this.http.get<TasksResponse[]>(this.baseUrl)
    }
    createTasks(data: any) {
        return this.http.post<TasksResponse>(this.baseUrl,data)
    }
    deleteTasks(id: number) {
        return this.http.delete<void>(`${this.baseUrl}/${id}`)
    }

}

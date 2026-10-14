import { TasksRequst } from "./tasks-requst";

export interface TasksResponse {
name: any;
    id:number;
    task:Map<string,TasksRequst>;
}
    
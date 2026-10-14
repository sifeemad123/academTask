import { TasksRequst } from "./tasks-requst";

export interface TasksResponse {
    id:number;
    task:Map<string,TasksRequst>;
}
    
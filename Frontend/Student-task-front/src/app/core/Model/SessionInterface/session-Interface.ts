import { TeamResponse } from "../TeamInterface/team-response";

export interface Session {
    id: number,
    startDate: Date,
    endDate: Date,
    isActive: boolean,
    teams: [TeamResponse];
}

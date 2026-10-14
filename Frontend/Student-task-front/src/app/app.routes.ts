import { Routes } from '@angular/router';
import { StudentsComponent } from './Feature/students/Student';
import { TeacherProfile } from './Feature/teacher-Create/teacher-Create';
import { Teams } from './Feature/teams/teams';
import { CreateSession } from './Feature/create-session/create-session';
export const routes: Routes = [
    {path:"",
        component:StudentsComponent
    },
    {
      path:"CreateSession",
      component:CreateSession
    },
    {
      path:"TeacherCreate",
      component:TeacherProfile
    },
    {
        path:"Teams",
        component:Teams
    },

];

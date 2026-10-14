import { Routes } from '@angular/router';
import { StudentsComponent } from './Feature/students/Student';
import { TeacherProfile } from './Feature/teacher-Create/teacher-Create';
import { Teams } from './Feature/teams/teams';
import { CreateSession } from './Feature/create-session/create-session';
import { SignUp } from './Feature/sign-up/sign-up';
import { LoginComponent } from './Feature/login/login';
export const routes: Routes = [
  
    {path:"",
        component:LoginComponent
    },
    {path:"SignUp",
        component:SignUp
    },
      {path:"StudentsComponent",
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

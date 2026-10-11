import { Routes } from '@angular/router';
import { StudentsComponent } from './Feature/students/Student';
import { TeacherProfile } from './Feature/teacher-Create/teacher-Create';
import { Teams } from './Feature/teams/teams';
export const routes: Routes = [
    {path:"",
        component:StudentsComponent
    },
    {
        path:"StudentsComponent",
        component:StudentsComponent
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

import { Routes } from '@angular/router';
import { StudentsComponent } from './Feature/students/Student';
import { Profile } from './Feature/profile/profile';
import { TeacherProfile } from './Feature/teacher-Create/teacher-Create';

export const routes: Routes = [
    {path:"",
        component:StudentsComponent
    },{
        path:"profile",
        component:Profile
    },
    {
        path:"StudentsComponent",
        component:StudentsComponent
    },
    {
      path:"TeacherCreate",
      component:TeacherProfile
    }

];

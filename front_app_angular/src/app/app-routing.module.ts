import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ReservationComponent} from "./components/reservation/reservation.component";
import {ResourceComponent} from "./components/resource/resource.component";
import {PersonComponent} from "./components/person/person.component";
import {AuthGuard} from "./guards/authentication.guard";

const routes: Routes = [
  {path:"reservation",component:ReservationComponent,canActivate:[AuthGuard]},
  {path:"resource",component:ResourceComponent,canActivate:[AuthGuard]},
  {path:"person",component:PersonComponent,canActivate:[AuthGuard]},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

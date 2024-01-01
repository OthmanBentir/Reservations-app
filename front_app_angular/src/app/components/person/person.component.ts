import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent {
  persons:any
  page:number = 1;
  constructor(private httpClient: HttpClient){

  }
  ngOnInit(): void {
    this.httpClient
      .get("http://localhost:8000/reservation-service/Personnes")
      .subscribe(
        {
          next: value => {
            this.persons = value
          },
          error: err => {
            console.log(err)
          }
        }
      )
  }

  deletePerson(id:number) {

  }

  editPerson(p: any) {

  }
}

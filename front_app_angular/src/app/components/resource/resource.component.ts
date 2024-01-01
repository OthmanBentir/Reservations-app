import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-resource',
  templateUrl: './resource.component.html',
  styleUrls: ['./resource.component.css']
})
export class ResourceComponent {

  resources:any
  page:number = 1;
  constructor(private http:HttpClient) {
    this.http
      .get("http://localhost:8000/resources-service/Resources")
      .subscribe(
        {
          next: value => {
            console.log(value)
            this.resources = value
          },
          error: err => {
            console.log(err)
          }
        }
      )
  }

  deleteResource(idResource:number) {
    this.http.delete("http://localhost:9090/resource-service/delete/"+idResource)
      .subscribe(
        {
          next: value => {
            window.location.reload()
          },
          error: err => {
            console.log(err)
          }
        }
      )

  }

  editResource(resource: any) {

  }
}

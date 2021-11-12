import { Component, OnInit } from '@angular/core';
import { Plate } from '../../models/Plate';
import { ApiService } from '../../services/api.service'
// import { HttpClient } from "@angular/common/http";

@Component({
  selector: 'app-plates',
  templateUrl: './plates.component.html',
  styleUrls: ['./plates.component.css']
})

export class PlatesComponent implements OnInit  {
  plates: Plate[] = [];

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.apiService.getPlates()
    .subscribe(
      (plates) => (this.plates = plates)
    )
  }


  addPlate(plate: Plate) {
    this.apiService.addPlate(plate)
      .subscribe(
        (plate) => (  this.plates.push(plate) )
      );
  }

  deletePlate(plate: Plate) {
    this.apiService.deletePlate(plate)
      .subscribe(
      () => ( this.plates = this.plates.filter( t => t.id !== plate.id ) )
  );
  }

}

import { Component, OnInit } from '@angular/core';
// import { userInfo } from 'os';
import { User } from 'src/app/models/User';
import { Plate } from '../../models/Plate';
import { ApiService } from '../../services/api.service'
// import { HttpClient } from "@angular/common/http";

@Component({
  selector: 'app-plates',
  templateUrl: './plates.component.html',
  styleUrls: ['./plates.component.css']
})

export class PlatesComponent implements OnInit {
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
        (plate) => (this.plates.push(plate))
      );
  }

  deletePlate(plate: Plate) {
    this.apiService.deletePlate(plate)
      .subscribe(
        () => (this.plates = this.plates.filter(p => p.id !== plate.id))
      );
  }

  takeAPlate(plate: Plate) {

    if (plate.portionsavailable > 0) {
      // if (user.id != null) {
        plate.portionsavailable -= 1;
        // temp hardcoded, need a function in apiservice to return to current user (id)
        plate.pickupuser.push(1);
        this.apiService.updatePlate(plate);
      // }
    }
  }

}

import { Component, OnInit } from '@angular/core';
// import { userInfo } from 'os';
import { User } from 'src/app/models/User';
import { Plate } from '../../models/Plate';
import { Pageable } from '../../models/Pageable';
import { ApiService } from '../../services/api.service'
// import { HttpClient } from "@angular/common/http";

@Component({
  selector: 'app-plates',
  templateUrl: './plates.component.html',
  styleUrls: ['./plates.component.css']
})

export class PlatesComponent implements OnInit {
  plates: Plate[] = [];
  pageable: Pageable = {
    content: this.plates
  }
  


  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.apiService.getPlates()
      .subscribe(
        (pageable) => {
          this.pageable = pageable;
          this.plates = pageable.content;
          console.log(pageable.content)
        })
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
    if (plate.portionsAvailable > 0) {
      // if (user.id != null) {
        plate.portionsAvailable -= 1;
        // notifySharingUser()  // to do
        // temp hardcoded, need a function in apiservice to return to current user (id)
        // plate.pickupuser.push(1);
        console.log(plate.portionsAvailable)
        this.apiService.updatePlate(plate).subscribe(
        // (plate) => (this.plates.push(plate))
        () => (this.plates = this.plates)
        );
      // }
    }
  }

        // notifySharingUser(){}
        // to do


}

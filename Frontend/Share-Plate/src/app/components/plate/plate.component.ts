import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Plate } from 'src/app/models/Plate';
import { User } from 'src/app/models/User';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-plate',
  templateUrl: './plate.component.html',
  styleUrls: ['./plate.component.css']
})
export class PlateComponent implements OnInit {
  user!: User | null;
  
  @Input()
  plate!: Plate;

  // @Input()
  // user!: User;

  @Output()
  onTakeAPlate: EventEmitter<Plate> = new EventEmitter();

  @Output()
  onDeletePlate: EventEmitter<Plate> = new EventEmitter();

  constructor(private authService: AuthService) {
  }

  ngOnInit(): void {
    this.authService.onUserChange.subscribe((user) => this.user = user);
    this.user = this.authService.user;
    console.log(this.plate)
    //this.plate.pickupusers = [];
  }

  onToggle(plate: Plate) {
    this.onTakeAPlate.emit(plate);
  }

  onToggleDelete(plate: Plate) {
    this.onDeletePlate.emit(plate);
  }

}

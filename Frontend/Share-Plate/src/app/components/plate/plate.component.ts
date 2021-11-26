import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Plate } from 'src/app/models/Plate';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-plate',
  templateUrl: './plate.component.html',
  styleUrls: ['./plate.component.css']
})
export class PlateComponent implements OnInit {
  @Input()
  plate!: Plate;

  @Input()
  user!: User;

  @Output()
  onTakeAPlate: EventEmitter<Plate> = new EventEmitter();

  @Output()
  onDeletePlate: EventEmitter<Plate> = new EventEmitter();

  constructor() {
  }

  ngOnInit(): void {
    this.plate.pickupusers = [];
  }

  onToggle(plate: Plate) {
    this.onTakeAPlate.emit(plate);
  }

  onToggleDelete(plate: Plate) {
    this.onDeletePlate.emit(plate);
  }

}

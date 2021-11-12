import { Component, Input, OnInit } from '@angular/core';
import { Plate } from 'src/app/models/Plate';

@Component({
  selector: 'app-plate',
  templateUrl: './plate.component.html',
  styleUrls: ['./plate.component.css']
})
export class PlateComponent implements OnInit {
  @Input()
  plate!: Plate;

  constructor() { }

  ngOnInit(): void {
  }

}

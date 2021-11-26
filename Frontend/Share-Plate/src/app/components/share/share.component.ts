import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { User } from '../../models/User';
import { Plate } from '../../models/Plate';
import { ApiService } from 'src/app/services/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-share',
  templateUrl: './share.component.html',
  styleUrls: ['./share.component.css']
})
export class ShareComponent implements OnInit {

  @Output() onShare: EventEmitter<Plate> = new EventEmitter();
  title! : string;
  description!: string;
  startpickuptime!: Date;
  endpickuptime!: Date;
  portionsavailable!: string;
  createdby!: number;
  pickupusers!: number[];

  constructor(private apiService: ApiService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    if (!this.title) {
      alert('Please enter a title.');
      return;
    }
    if (!this.startpickuptime) {
      alert('Please enter a time when your plate is ready for pick-up.');
      return;
    }if (!this.endpickuptime) {
      alert('Please enter end hour for pick-up.');
      return;
    }if (!this.portionsavailable) {
      alert('Please enter the number of portions available.');
      return;
    }

    const newPlate: Plate = {
      title: this.title,
      description: this.description,
      startpickuptime: (this.startpickuptime),
      endpickuptime: this.endpickuptime,
      portionsavailable: Number(this.portionsavailable),
      createdby : this.createdby,
      pickupusers: [],
      createdat: new Date(Date.now()),
      modifiedat: new Date(Date.now())
    }

    this.onShare.emit(newPlate);

    this.apiService.addPlate(newPlate).subscribe();

    this.router.navigate(['/plates']);
  }


}

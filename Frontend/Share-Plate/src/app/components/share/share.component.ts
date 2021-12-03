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
  startPickupTime!: Date;
  endPickupTime!: Date;
  portionsAvailable!: string;
  createdUser!: User;
  pickupusers!: number[];

  constructor(private apiService: ApiService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    if (!this.title) {
      alert('Please enter a title.');
      return;
    }
    if (!this.startPickupTime) {
      alert('Please enter a time when your plate is ready for pick-up.');
      return;
    }if (!this.endPickupTime) {
      alert('Please enter end hour for pick-up.');
      return;
    }if (!this.portionsAvailable) {
      alert('Please enter the number of portions available.');
      return;
    }

    const newPlate: Plate = {
      title: this.title,
      description: this.description,
      startPickupTime: (this.startPickupTime),
      endPickupTime: this.endPickupTime,
      portionsAvailable: Number(this.portionsAvailable),
      createdUser : this.createdUser,
      pickupusers: []
    }

    this.onShare.emit(newPlate);

    this.apiService.addPlate(newPlate).subscribe();

    this.router.navigate(['/plates']);
  }


}

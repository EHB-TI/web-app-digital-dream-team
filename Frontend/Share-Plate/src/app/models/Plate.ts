import { User } from "./User";

export interface Plate {
  id?: number;
  title: string;
  description: string;
  startPickupTime: Date;
  endPickupTime: Date;
  portionsAvailable: number;
  createdUser: User;
  pickupusers: number[];
}

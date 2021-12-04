import { User } from "./User";

export interface Plate {
  id?: number;
  title: string;
  description: string;
  startPickupTime: string;
  endPickupTime: string;
  portionsAvailable: number;
  createdUser: User;
  pickupusers: number[];
}

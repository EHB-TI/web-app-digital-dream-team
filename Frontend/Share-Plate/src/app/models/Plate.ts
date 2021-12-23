import { User } from "./User";

export interface Plate {
  id?: number;
  title: string;
  description: string;
  startpickuptime: Date;
  endpickuptime: Date;
  portionsavailable: number;
  createdby: number;
  pickupusers: number[];
  createdat: Date;
  modifiedat: Date;
}

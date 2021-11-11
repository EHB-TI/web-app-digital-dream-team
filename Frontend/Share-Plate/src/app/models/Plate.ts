import { User } from "./User";

export interface Plate {
  id?: number;
  title: string;
  description: string;
  pickuptime: string;
  endpickuptime: string;
  portionsavailable: number;
  createduser: number;
  pickupuser: number[];
}

import { IUser } from "./IUser";

export interface ILoginResult {
  accessToken: string;
  user: IUser;
}

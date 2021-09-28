import { ProductStatus } from "enums";
import { ICategory } from "models";
import { IReview } from "./IReview";

export interface IProduct {
  category: ICategory;
  created: Date;
  description: string;
  id: number;
  name: string;
  price: number;
  quantity: number;
  reviews: IReview[];
  salesCounter: number;
  status: ProductStatus;
}

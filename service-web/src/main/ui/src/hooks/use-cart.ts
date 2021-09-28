import { CartContext } from "context";
import { useContext } from "react";

export function useCart() {
  return useContext(CartContext);
}

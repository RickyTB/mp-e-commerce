import { IProduct } from "models";
import React, { useCallback, useMemo, useReducer } from "react";

export interface CartValue {
  [key: number]: {
    product: IProduct;
    quantity: number;
  };
}

export interface CartContextValue {
  cart: CartValue;
  addProduct: (product: IProduct) => void;
  removeProduct: (product: IProduct) => void;
  addQuantity: (product: IProduct) => void;
  reduceQuantity: (product: IProduct) => void;
}

export const CartContext = React.createContext<CartContextValue>({
  cart: {},
  addProduct: () => {},
  removeProduct: () => {},
  addQuantity: () => {},
  reduceQuantity: () => {},
});

const { Consumer, Provider } = CartContext;

enum CartAction {
  ADD_PRODUCT,
  REMOVE_PRODUCT,
  ADD_QTY,
  REDUCE_QTY,
}

interface ICartAction {
  type: CartAction;
  payload: any;
}

const reducer = (state: CartValue, action: ICartAction): CartValue => {
  switch (action.type) {
    case CartAction.ADD_PRODUCT:
      return {
        ...state,
        [action.payload.id]: {
          product: action.payload,
          quantity: 1,
        },
      };
    case CartAction.REMOVE_PRODUCT: {
      const newState = { ...state };
      delete newState[action.payload.id];
      return newState;
    }
    case CartAction.ADD_QTY:
      return {
        ...state,
        [action.payload.id]: {
          ...state[action.payload.id],
          quantity: state[action.payload.id].quantity + 1,
        },
      };
    case CartAction.REDUCE_QTY:
      return {
        ...state,
        [action.payload.id]: {
          ...state[action.payload.id],
          quantity: state[action.payload.id].quantity - 1,
        },
      };
  }
};

const initialState: CartValue = {};

export const CartProvider: React.FC = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState);

  const addProduct = useCallback((product: IProduct) => {
    dispatch({ type: CartAction.ADD_PRODUCT, payload: product });
  }, []);

  const removeProduct = useCallback((product: IProduct) => {
    dispatch({ type: CartAction.REMOVE_PRODUCT, payload: product });
  }, []);

  const addQuantity = useCallback((product: IProduct) => {
    dispatch({ type: CartAction.ADD_QTY, payload: product });
  }, []);

  const reduceQuantity = useCallback((product: IProduct) => {
    dispatch({ type: CartAction.REDUCE_QTY, payload: product });
  }, []);

  const value = useMemo(
    () => ({
      cart: state,
      addProduct,
      removeProduct,
      addQuantity,
      reduceQuantity,
    }),
    [state, addProduct, removeProduct, addQuantity, reduceQuantity]
  );

  return <Provider value={value}>{children}</Provider>;
};

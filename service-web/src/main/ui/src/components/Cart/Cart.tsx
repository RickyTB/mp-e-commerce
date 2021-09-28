import {
  Box,
  Divider,
  Drawer,
  IconButton,
  styled,
  Typography,
  useTheme,
} from "@mui/material";
import ChevronLeftIcon from "@mui/icons-material/ChevronLeft";
import ChevronRightIcon from "@mui/icons-material/ChevronRight";
import React from "react";
import { ResponseState, useCart, useRequest } from "hooks";
import { CartItem } from "components/CartItem";
import { LoadingButton } from "@mui/lab";
import { IProduct } from "models";

const DrawerHeader = styled("div")(({ theme }) => ({
  display: "flex",
  alignItems: "center",
  padding: theme.spacing(0, 1),
  // necessary for content to be below app bar
  ...theme.mixins.toolbar,
  justifyContent: "flex-end",
}));

export interface CartProps {
  open: boolean;
  onClose: () => void;
}

export const Cart: React.FC<CartProps> = ({ open, onClose }) => {
  const theme = useTheme();
  const { cart } = useCart();
  const { post, state, data } = useRequest();

  const cartList = Object.values(cart);

  const handlePurchase = () => {
    post("/sales/orders", {
      totalPrice: cartList.reduce(
        (sum, item: { product: IProduct; quantity: number }) =>
          sum + item.product.price * item.quantity,
        0
      ),
      listOrder: cartList.map((item) => ({
        productId: item.product.id,
        quantity: item.quantity,
      })),
    });
  };

  return (
    <Drawer
      anchor="right"
      variant="temporary"
      open={open}
      onClose={onClose}
      PaperProps={{ sx: { width: "380px" } }}
    >
      <DrawerHeader>
        <IconButton onClick={onClose}>
          {theme.direction === "ltr" ? (
            <ChevronLeftIcon />
          ) : (
            <ChevronRightIcon />
          )}
        </IconButton>
      </DrawerHeader>
      <Divider />
      <Box p={2}>
        <Typography mb={2} variant="h5">
          Carrito de compras
        </Typography>
        {cartList.map((cartItem) => (
          <CartItem
            key={cartItem.product.id}
            product={cartItem.product}
            quantity={cartItem.quantity}
          />
        ))}
        {cartList.length === 0 && (
          <Typography mb={2}>
            No tienes productos agregados al carrito de compras.
          </Typography>
        )}
        <LoadingButton
          loading={state === ResponseState.Loading}
          variant="contained"
          fullWidth
          onClick={handlePurchase}
          disabled={!cartList.length}
        >
          Realizar compra
        </LoadingButton>
      </Box>
    </Drawer>
  );
};

import {
  Button,
  ButtonGroup,
  Card,
  CardContent,
  Typography,
} from "@mui/material";
import { useCart } from "hooks";
import { IProduct } from "models";
import React from "react";

export interface CartItemProps {
  product: IProduct;
  quantity: number;
}

export const CartItem: React.FC<CartItemProps> = ({ product, quantity }) => {
  const { addQuantity, reduceQuantity } = useCart();

  const handleAdd = () => addQuantity(product);
  const handleReduce = () => reduceQuantity(product);

  return (
    <Card variant="outlined" sx={{ marginBottom: 2 }}>
      <CardContent>
        <Typography variant="h6" mb={2}>
          {quantity}x {product.name}
        </Typography>
        <Typography variant="body2" color="text.secondary" mb={2}>
          Total: ${(product.price * quantity).toFixed(2)}
        </Typography>
        <ButtonGroup
          variant="outlined"
          aria-label="outlined primary button group"
        >
          <Button onClick={handleAdd} disabled={quantity >= product.quantity}>
            +
          </Button>
          <Button onClick={handleReduce} disabled={quantity < 2}>
            -
          </Button>
        </ButtonGroup>
      </CardContent>
    </Card>
  );
};

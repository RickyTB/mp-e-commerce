import AddShoppingCartIcon from "@mui/icons-material/AddShoppingCart";
import {
  Button,
  Card,
  CardActionArea,
  CardActions,
  CardContent,
  Chip,
  Typography,
} from "@mui/material";
import { ProductStatus } from "enums";
import { IProduct } from "models";
import Link from "next/link";
import React from "react";

export interface ProductCardProps {
  product: IProduct;
}

export const ProductCard: React.FC<ProductCardProps> = ({ product }) => {
  return (
    <Card>
      <Link href={{ pathname: "/product", query: { id: product.id } }} passHref>
        <CardActionArea>
          <CardContent>
            <Chip label={product.category.name} sx={{ marginBottom: 1 }} />
            <Typography variant="h5" mb={1}>
              {product.name}
            </Typography>
            <Typography color="text.secondary" mb={1}>
              ${product.price.toFixed(2)}
            </Typography>
            {product.status === ProductStatus.IN_STOCK ? (
              <Typography variant="body2">
                {product.quantity} disponible{product.quantity === 1 ? "" : "s"}
              </Typography>
            ) : (
              <Typography variant="body1" color="error">
                No disponible
              </Typography>
            )}
          </CardContent>
        </CardActionArea>
      </Link>
      {product.status === ProductStatus.IN_STOCK && (
        <CardActions>
          <Button color="success" startIcon={<AddShoppingCartIcon />}>
            Agregar al carrito
          </Button>
        </CardActions>
      )}
    </Card>
  );
};

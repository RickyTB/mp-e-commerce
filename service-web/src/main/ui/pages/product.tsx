import {
  Box,
  Button,
  Card,
  CardContent,
  CardMedia,
  Chip,
  Container,
  Typography,
} from "@mui/material";
import Head from "next/head";
import AddShoppingCartIcon from "@mui/icons-material/AddShoppingCart";
import React, { useEffect } from "react";
import { IProduct } from "models";
import { useRequest } from "hooks";
import { useRouter } from "next/router";
import { ProductStatus } from "enums";
import { ReviewList } from "components";

export interface ProductPageProps {}

const ProductPage: React.FC<ProductPageProps> = () => {
  const { get, state, data: product, error } = useRequest<IProduct>();
  const { query } = useRouter();

  useEffect(() => {
    if (!query.id) return;
    get(`/product/products/${query.id}`);
  }, [query]);

  if (!product) {
    return (
      <>
        <Head>
          <title>Producto no encontrado | E-commerce</title>
        </Head>
        <Container maxWidth="lg" sx={{ marginTop: "72px", paddingTop: 2 }}>
          <Typography>El producto no se encontró</Typography>
        </Container>
      </>
    );
  }
  return (
    <>
      <Head>
        <title>Producto | E-commerce</title>
      </Head>
      <Container maxWidth="lg" sx={{ marginTop: "72px", paddingTop: 2 }}>
        <Card sx={{ display: "flex", marginBottom: 3 }}>
          <CardMedia
            component="img"
            sx={{ width: 300 }}
            image="/placeholder_2.jpg"
            alt="Producto"
          />
          <Box sx={{ display: "flex", flexDirection: "column" }}>
            <CardContent sx={{ flex: "1 0 auto" }}>
              <Chip label={product.category.name} sx={{ marginBottom: 1 }} />
              <Typography variant="h3" component="h1" mb={2}>
                {product.name}
              </Typography>
              <Typography
                variant="subtitle1"
                color="text.secondary"
                component="p"
                mb={1}
                style={{ whiteSpace: "pre-wrap" }}
              >
                {product.description}
              </Typography>
              <Typography color="text.secondary" mb={1}>
                ${product.price.toFixed(2)}
              </Typography>
              {product.status === ProductStatus.IN_STOCK ? (
                <Typography variant="body2">
                  {product.quantity} disponible
                  {product.quantity === 1 ? "" : "s"}
                </Typography>
              ) : (
                <Typography variant="body1" color="error">
                  No disponible
                </Typography>
              )}
            </CardContent>
            {product.status === ProductStatus.IN_STOCK && (
              <Box sx={{ display: "flex", alignItems: "center", pl: 1, pb: 1 }}>
                <Button color="success" startIcon={<AddShoppingCartIcon />}>
                  Agregar al carrito
                </Button>
              </Box>
            )}
          </Box>
        </Card>
        <ReviewList productId={product.id} />
      </Container>
    </>
  );
};

export default ProductPage;

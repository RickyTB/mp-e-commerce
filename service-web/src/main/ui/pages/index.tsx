import { Container, Grid, Typography } from "@mui/material";
import { ProductCard } from "components";
import { useRequest } from "hooks";
import { IProduct } from "models";
import Head from "next/head";
import { useEffect } from "react";

export default function Home() {
  const { get, state, data: products, error } = useRequest<IProduct[]>();

  useEffect(() => {
    get("/product/products");
  }, []);

  return (
    <>
      <Head>
        <title>E-commerce</title>
      </Head>
      <Container maxWidth="lg" sx={{ marginTop: "72px" }}>
        <Typography variant="h1" mb={3}>
          Productos
        </Typography>
        <Grid container item spacing={4} mb={3}>
          {products?.map((product) => (
            <Grid key={product.id} item xs={4}>
              <ProductCard product={product} />
            </Grid>
          ))}
        </Grid>
      </Container>
    </>
  );
}

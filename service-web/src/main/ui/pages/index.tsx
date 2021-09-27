import { Container, Grid, Typography } from "@mui/material";
import { Box } from "@mui/system";
import Head from "next/head";

export default function Home() {
  return (
    <>
      <Head>
        <title>E-commerce</title>
      </Head>
      <Container maxWidth="lg" sx={{ marginTop: "72px" }}>
        <Typography variant="h1" mb={3}>
          Productos
        </Typography>
        <Grid container item spacing={4}>
          <Grid item xs={4}>
            <Box
              component="img"
              src={
                "https://es.creativiu.com/wp-content/uploads/2016/10/cocinero-principiante.jpg"
              }
              width="100%"
              height="100%"
            />
          </Grid>

          <Grid item xs={4}>
            <Box
              component="img"
              src={
                "https://i.blogs.es/d58a5c/reposteria-saludable0/1366_2000.jpg"
              }
              width="100%"
              height="100%"
            />
          </Grid>
          <Grid item xs={4}>
            <Box
              component="img"
              src={
                "https://assets.entrepreneur.com/content/3x2/2000/chef_casa.jpg?auto=webp&quality=95&crop=16:9&width=675"
              }
              width="100%"
              height="100%"
            />
          </Grid>
        </Grid>
      </Container>
    </>
  );
}

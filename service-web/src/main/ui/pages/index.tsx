import { Container, Grid, Link, Typography } from "@mui/material";
import { Box } from "@mui/system";
import Head from "next/head";
import styles from "../styles/Home.module.css";

export default function Home() {
  return (
    <div className={styles.container}>
      <Head>
        <title>E-commerce</title>
      </Head>
      <Grid component="main" sx={{ height: "100vh" }}>
        <Box component="img" src={"/logo.jpg"} width="100%" />
        <Container fixed>
          <Grid container item spacing={2} padding="30px 0px 0px 0px">
            <Grid item xs={8}>
              <Box
                component="img"
                src={"https://i.blogs.es/ee8d66/solo12/1366_2000.jpg"}
                width="100%"
                height="90%"
              />
            </Grid>
            <Grid item xs={4}>
              <Box
                component="img"
                src={"/concepto.jpg"}
                width="100%"
                height="90%"
              />
            </Grid>
          </Grid>
          <Box padding="10px 0px 0px 0px">
            <Typography fontSize="1.4rem" paragraph={true}>
              <strong> Kitchen Helper </strong> es una plataforma social que te
              servirá de guía para poderte encaminar en el arte de la cocina. No
              es necesario que seas un experto en la cocina lo importante es
              tener las ganas de aprender, con el paso del tiempo podrás llegar
              a conquistar paladares y subir tus propias recetas.
              <br />
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
          </Box>
          <Link href="/categories">
            <Typography
              variant="h3"
              textAlign="center"
              paddingTop="20px"
              sx={{
                color: "black",
              }}
            >
              Categorias
            </Typography>
          </Link>
          <Typography
            fontSize="1.4rem"
            padding="20px 0px 0px 0px"
            height="100%"
            textAlign="justify"
            paragraph={true}
          >
            Las <strong>Categorias</strong> nos permiten buscar recetas
            facilmente, puedes ingresar a una de ellas y ver lo que los usuarios
            han preparado para esa categoria, de igual manera encontraras
            pequeñas reseñas de las preparaciones en cada una de las categorias
          </Typography>
          <Box
            padding="20px 0px 0px 0px"
            component="img"
            src={"/categorias.jpg"}
            width="100%"
          />
          <Typography
            variant="h3"
            textAlign="center"
            paddingTop="20px"
            sx={{
              color: "black",
            }}
          >
            Recetas Nuevas
          </Typography>
          <Typography
            fontSize="1.4rem"
            padding="20px 0px 0px 0px"
            height="100%"
            textAlign="justify"
            paragraph={true}
          >
            Puedes crear tu <strong>nuevas recetas</strong> y publicarlas para
            que los usuarios puedan seguirla, comentarla y reaccionar a ellas
            proponiendo mejorar o agradecimientos por imaprtir tus conocimientos
          </Typography>
          <Typography
            variant="h3"
            textAlign="center"
            paddingTop="20px"
            sx={{
              color: "black",
            }}
          >
            Incrementa tu Nivel
          </Typography>
          <Typography
            fontSize="1.4rem"
            padding="20px 0px 0px 0px"
            height="100%"
            textAlign="justify"
            paragraph={true}
          >
            <strong>Incrementa tu nivel</strong>. Puedes incrementar tu nivel de
            cocinero, desde principiante hasta chef Master, esto te permitirá
            avanzar en tu estudio del arte culinaria.
          </Typography>
          <Box
            padding="20px 0px 0px 0px"
            component="img"
            src={"/categorias.jpg"}
            width="100%"
          />
          <Typography variant="h3" textAlign="center">
            Frases
          </Typography>
          <Box textAlign="center" padding="2rem 10rem">
            <Typography fontSize="1.4rem" paragraph={true}>
              "La cocina es un lenguaje mediante el cual se puede expresar
              armonía, felicidad, belleza, poesía, complejidad, magia, humor,
              provocación, cultura"
              <td />
              <em>Ferran Adrià</em>
            </Typography>
          </Box>
          <Box textAlign="center" padding="2rem 10rem">
            <Typography fontSize="1.4rem" paragraph={true}>
              "La gastronomía es el arte de usar los alimentos para crear
              felicidad"
              <td />
              <em>Theodore Zeldin</em>
            </Typography>
          </Box>
        </Container>
      </Grid>
    </div>
  );
}

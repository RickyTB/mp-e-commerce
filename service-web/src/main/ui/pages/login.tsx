import * as React from "react";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import FormControlLabel from "@mui/material/FormControlLabel";
import Checkbox from "@mui/material/Checkbox";
import {
  Link,
  InputAdornment,
  Alert,
  AlertTitle,
  CircularProgress,
} from "@mui/material";
import Paper from "@mui/material/Paper";
import Box from "@mui/material/Box";
import Grid from "@mui/material/Grid";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import { useForm } from "react-hook-form";
import Head from "next/head";
import { FormTextField } from "components";
import { useRouter } from "next/router";
import { useSession, useRequest, useUpdateEffect, ResponseState } from "hooks";
import { ILoginResult } from "models";
import { useEffect } from "react";
import { yupResolver } from "@hookform/resolvers/yup";
import * as yup from "yup";
import { default as NextLink } from "next/link";

interface ILoginForm {
  login: string;
  password: string;
}

const schema = yup.object().shape({
  login: yup.string().required("Debes ingresar tu apodo (nombre de usuario)"),
  password: yup
    .string()
    .min(6, "Mínimo 6 caracteres.")
    .max(16, "Máximo 16 caracteres.")
    .required("Debes ingresar una contraseña."),
});

export default function SignInSide() {
  const { control, handleSubmit } = useForm<ILoginForm>({
    resolver: yupResolver(schema) as any,
  });
  const { accessToken, setSession } = useSession();
  const { post, state, data, error } = useRequest<ILoginResult>();
  const router = useRouter();

  const handleLogin = handleSubmit((data) => {
    post("/auth/login", data);
  });

  useUpdateEffect(() => {
    if (!data) return;
    setSession(data);
  }, [data]);

  useEffect(() => {
    if (accessToken) {
      router.push("/");
    }
  }, [accessToken]);

  return (
    <>
      <Head>
        <title>Iniciar sesión | E-commerce</title>
      </Head>
      <Grid container component="main" sx={{ height: "100vh" }}>
        <Grid
          item
          xs={false}
          sm={4}
          md={7}
          sx={{
            backgroundImage:
              "url(https://source.unsplash.com/random?technology)",
            backgroundRepeat: "no-repeat",
            backgroundColor: (t) =>
              t.palette.mode === "light"
                ? t.palette.grey[50]
                : t.palette.grey[900],
            backgroundSize: "cover",
            backgroundPosition: "center",
          }}
        />
        <Grid
          item
          xs={12}
          sm={8}
          md={5}
          component={Paper}
          elevation={6}
          square
          pt={5}
        >
          <Box
            sx={{
              my: 8,
              mx: 4,
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
            }}
          >
            <Avatar sx={{ m: 1, bgcolor: "secondary.main" }}>
              <LockOutlinedIcon />
            </Avatar>
            <Typography component="h1" variant="h5">
              Inicia sesión
            </Typography>
            <Box
              component="form"
              noValidate
              onSubmit={handleLogin}
              sx={{ mt: 3 }}
            >
              <Grid container spacing={2}>
                <Grid item xs={12}>
                  <FormTextField
                    control={control}
                    required
                    fullWidth
                    id="login"
                    label="Nombre de usuario"
                    name="login"
                    autoComplete="username"
                  />
                </Grid>
                <Grid item xs={12}>
                  <FormTextField
                    control={control}
                    required
                    fullWidth
                    name="password"
                    label="Contraseña"
                    type="password"
                    id="password"
                    autoComplete="current-password"
                  />
                </Grid>
                <Grid item xs={12}>
                  <FormControlLabel
                    control={<Checkbox value="remember" color="primary" />}
                    label="Recordarme"
                  />
                </Grid>
              </Grid>
              {state === ResponseState.Error && (
                <Alert severity="error" sx={{ mt: 3 }}>
                  <AlertTitle>Error</AlertTitle>
                  Ocurrió un error al crear tu cuenta: {error?.message}
                </Alert>
              )}
              {state === ResponseState.Loading ? (
                <CircularProgress sx={{ mt: 3, mb: 2 }} />
              ) : (
                <Button
                  type="submit"
                  fullWidth
                  variant="contained"
                  sx={{ mt: 3, mb: 2 }}
                >
                  Iniciar sesión
                </Button>
              )}
              <Grid container justifyContent="flex-end">
                <Grid item>
                  <NextLink href="/signup" passHref>
                    <Link color="secondary">
                      {"¿No tienes una cuenta? Regístrate"}
                    </Link>
                  </NextLink>
                </Grid>
              </Grid>
            </Box>
          </Box>
        </Grid>
      </Grid>
    </>
  );
}

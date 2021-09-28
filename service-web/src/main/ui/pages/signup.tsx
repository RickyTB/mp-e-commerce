import * as React from "react";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import Link from "@mui/material/Link";
import Paper from "@mui/material/Paper";
import Box from "@mui/material/Box";
import Grid from "@mui/material/Grid";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import { Controller, useForm } from "react-hook-form";
import Head from "next/head";
import { default as NextLink } from "next/link";
import { LocalizationProvider, DatePicker } from "@mui/lab";
import AdapterDateFns from "@mui/lab/AdapterDateFns";
import { FormTextField } from "components";
import {
  Alert,
  AlertTitle,
  CircularProgress,
  InputAdornment,
} from "@mui/material";
import { yupResolver } from "@hookform/resolvers/yup";
import * as yup from "yup";
import { ResponseState, useRequest, useSession, useUpdateEffect } from "hooks";
import { ILoginResult } from "models";
import { useRouter } from "next/router";
import { useEffect } from "react";

interface ISignUpForm {
  login: string;
  email: string;
  password: string;
  address: string;
  phone: string;
}

const schema = yup.object().shape({
  login: yup.string().required("Debes ingresar tu apodo (nombre de usuario)"),
  email: yup
    .string()
    .email("Debes ingresar un correo válido.")
    .required("Debes ingresar tu correo electrónico."),
  password: yup
    .string()
    .min(6, "Mínimo 6 caracteres.")
    .max(16, "Máximo 16 caracteres.")
    .required("Debes ingresar una contraseña."),
  address: yup.string().required("Debes ingresar tu dirección"),
  phone: yup.string().required("Debes ingresar tu número de teléfono"),
});

export default function SignUp() {
  const { control, handleSubmit } = useForm<ISignUpForm>({
    resolver: yupResolver(schema) as any,
  });
  const { accessToken, setSession } = useSession();
  const { post, state, data, error } = useRequest<ILoginResult>();
  const router = useRouter();

  const handleSignup = handleSubmit((data) => {
    post("/auth/signup", data);
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
        <title>Registro | E-commerce</title>
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
              Regístrate
            </Typography>
            <Box
              component="form"
              noValidate
              onSubmit={handleSignup}
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
                  <FormTextField
                    control={control}
                    required
                    fullWidth
                    id="address"
                    label="Dirección"
                    name="address"
                    autoComplete="address"
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <FormTextField
                    control={control}
                    required
                    fullWidth
                    id="email"
                    label="Correo electrónico"
                    name="email"
                    autoComplete="email"
                  />
                </Grid>
                <Grid item xs={12} sm={6}>
                  <FormTextField
                    control={control}
                    autoComplete="phone"
                    name="phone"
                    required
                    fullWidth
                    id="phone"
                    label="Teléfono"
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
                  Crear cuenta
                </Button>
              )}
              <Grid container justifyContent="flex-end">
                <Grid item>
                  <NextLink href="/login" passHref>
                    <Link color="secondary">
                      ¿Ya tienes una cuenta? Inicia sesión
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

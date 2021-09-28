import { CacheProvider, EmotionCache } from "@emotion/react";
import { ThemeProvider } from "@mui/material/styles";
import CssBaseline from "@mui/material/CssBaseline";
import createEmotionCache from "lib/emotion-cache";
import type { AppProps } from "next/app";
import Head from "next/head";
import React, { useEffect } from "react";
import { Layout } from "../src/components";
import theme from "../src/theme";
import { CartProvider, SessionProvider } from "context";

const clientSideEmotionCache = createEmotionCache();

interface MyAppProps extends AppProps {
  emotionCache?: EmotionCache;
}

function MyApp({
  Component,
  pageProps,
  emotionCache = clientSideEmotionCache,
}: MyAppProps) {
  useEffect(() => {
    // Remove the server-side injected CSS.
    const jssStyles = document.querySelector("#jss-server-side");
    if (jssStyles) {
      jssStyles.parentElement?.removeChild(jssStyles);
    }
  }, []);

  return (
    <CacheProvider value={emotionCache}>
      <Head>
        <title>Ecommerce Proyecto Programación Distribuida</title>
        <meta name="description" content="Programación distribuida" />
        <link rel="icon" href="/icono.ico" />
        <meta
          name="viewport"
          content="minimum-scale=1, initial-scale=1, width=device-width"
        />
      </Head>
      <SessionProvider>
        <CartProvider>
          <ThemeProvider theme={theme}>
            {/* CssBaseline kickstart an elegant, consistent, and simple baseline to build upon. */}
            <CssBaseline />
            <Layout>
              <Component {...pageProps} />
            </Layout>
          </ThemeProvider>
        </CartProvider>
      </SessionProvider>
    </CacheProvider>
  );
}

export default MyApp;

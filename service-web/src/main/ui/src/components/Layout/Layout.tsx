import { AppBar, Toolbar, Button, Badge } from "@mui/material";
import { Box } from "@mui/system";
import LogoutIcon from "@mui/icons-material/Logout";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import React from "react";
import { useCart, useSession } from "hooks";
import Link from "next/link";
import { Cart } from "components/Cart";

export interface LayoutProps {
  children: any;
}

export const Layout: React.FC<LayoutProps> = ({ children }) => {
  const { user, setSession } = useSession();
  const { cart } = useCart();
  const [open, setOpen] = React.useState(false);
  const handleDrawerOpen = () => {
    setOpen(true);
  };
  const handleDrawerClose = () => {
    setOpen(false);
  };

  const handleLogout = () => {
    setSession(null);
  };

  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="fixed">
        <Toolbar>
          <Link href="/" passHref>
            <Button color="inherit" size="large">
              E-commerce
            </Button>
          </Link>
          <Box sx={{ flexGrow: 1 }} />
          <Box sx={{ display: "flex" }}>
            {user ? (
              <>
                <Button
                  size="large"
                  color="inherit"
                  startIcon={
                    <Badge
                      badgeContent={Object.keys(cart).length}
                      color="error"
                    >
                      <ShoppingCartIcon />
                    </Badge>
                  }
                  aria-label="open drawer"
                  onClick={handleDrawerOpen}
                  sx={{ mr: 2 }}
                >
                  Ver carrito
                </Button>
                <Button
                  startIcon={<LogoutIcon />}
                  size="large"
                  color="inherit"
                  onClick={handleLogout}
                >
                  Cerrar sesión
                </Button>
              </>
            ) : (
              <>
                <Link href="/signup" passHref>
                  <Button size="large" color="inherit">
                    Registrarse
                  </Button>
                </Link>
                <Link href="/login" passHref>
                  <Button size="large" color="inherit">
                    Iniciar sesión
                  </Button>
                </Link>
              </>
            )}
          </Box>
        </Toolbar>
      </AppBar>
      <Cart open={open} onClose={handleDrawerClose} />
      <main>{children}</main>
    </Box>
  );
};

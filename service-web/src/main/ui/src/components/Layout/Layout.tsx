import {
  AppBar,
  Divider,
  Drawer,
  IconButton,
  Typography,
  Toolbar,
  List,
  styled,
  useTheme,
  Button,
} from "@mui/material";
import { Box } from "@mui/system";
import MenuIcon from "@mui/icons-material/Menu";
import LogoutIcon from "@mui/icons-material/Logout";
import ChevronLeftIcon from "@mui/icons-material/ChevronLeft";
import ChevronRightIcon from "@mui/icons-material/ChevronRight";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import React from "react";
import { useSession } from "hooks";
import Link from "next/link";

import { mainListItems } from "./listitems";

const DrawerHeader = styled("div")(({ theme }) => ({
  display: "flex",
  alignItems: "center",
  padding: theme.spacing(0, 1),
  // necessary for content to be below app bar
  ...theme.mixins.toolbar,
  justifyContent: "flex-end",
}));

export interface LayoutProps {
  children: any;
}

export const Layout: React.FC<LayoutProps> = ({ children }) => {
  const theme = useTheme();
  const { user, setSession } = useSession();
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
                  startIcon={<ShoppingCartIcon />}
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
      <Drawer
        anchor="right"
        variant="temporary"
        open={open}
        onClose={handleDrawerClose}
        PaperProps={{ sx: { width: "380px" } }}
      >
        <DrawerHeader>
          <IconButton onClick={handleDrawerClose}>
            {theme.direction === "ltr" ? (
              <ChevronLeftIcon />
            ) : (
              <ChevronRightIcon />
            )}
          </IconButton>
        </DrawerHeader>
        <Divider />
        <List>{mainListItems}</List>
      </Drawer>
      <main>{children}</main>
    </Box>
  );
};

import React from "react";
import { ListItemButton, ListItemIcon, ListItemText } from "@mui/material";
import HomeIcon from "@mui/icons-material/Home";
import CategoryIcon from "@mui/icons-material/Category";
import PublishIcon from "@mui/icons-material/Publish";
import KitchenIcon from "@mui/icons-material/Kitchen";
import FoodBankIcon from "@mui/icons-material/FoodBank";
import DateRangeIcon from "@mui/icons-material/DateRange";
import Link from "next/link";

export const mainListItems = (
  <div>
    <Link href="/" passHref>
      <ListItemButton component="a">
        <ListItemIcon>
          <HomeIcon />
        </ListItemIcon>
        <ListItemText primary="Inicio" />
      </ListItemButton>
    </Link>
    <ListItemButton component="a">
      <ListItemIcon>
        <DateRangeIcon />
      </ListItemIcon>
      <ListItemText primary="Plan semanal" />
    </ListItemButton>
    <ListItemButton component="a">
      <ListItemIcon>
        <KitchenIcon />
      </ListItemIcon>
      <ListItemText primary="Generador" />
    </ListItemButton>
    <Link href="/categories" passHref>
      <ListItemButton component="a">
        <ListItemIcon>
          <CategoryIcon />
        </ListItemIcon>
        <ListItemText primary="Categorías" />
      </ListItemButton>
    </Link>
    <ListItemButton component="a">
      <ListItemIcon>
        <FoodBankIcon />
      </ListItemIcon>
      <ListItemText primary="Dietas" />
    </ListItemButton>
    <ListItemButton component="a">
      <ListItemIcon>
        <PublishIcon />
      </ListItemIcon>
      <ListItemText primary="Sube tu receta" />
    </ListItemButton>
  </div>
);

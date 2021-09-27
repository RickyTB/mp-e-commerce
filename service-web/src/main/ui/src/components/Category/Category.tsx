import { Box, Typography } from "@mui/material";
import { styled } from "@mui/system";
import { ICategory } from "models";
import Link from "next/link";
import React from "react";

export interface CategoryProps {
  category: ICategory;
}

const CategoryBackground = styled(Box)({
  display: "flex",
  width: "100%",
  height: "240px",
  borderRadius: "8px",
  backgroundSize: "cover",
  backgroundPosition: "center",
  overflow: "hidden",
  textDecoration: "none",
});

const Filter = styled("div")({
  backgroundColor: "rgba(0, 0, 0, 0.5)",
  flexGrow: 1,
  display: "flex",
  alignItems: "center",
  justifyContent: "center",
});

export const Category: React.FC<CategoryProps> = ({ category }) => {
  return (
    <Link href="/recipes" passHref>
      <CategoryBackground
        boxShadow={3}
        component="a"
        sx={{ backgroundImage: `url(${category.imageUrl})` }}
      >
        <Filter>
          <Typography sx={{ textAlign: "center" }} variant="h3" color="white">
            {category.name}
          </Typography>
        </Filter>
      </CategoryBackground>
    </Link>
  );
};

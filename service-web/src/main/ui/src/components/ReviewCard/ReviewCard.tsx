import { Card, CardContent, Rating, Typography } from "@mui/material";
import { IReview } from "models";
import React from "react";

export interface ReviewCardProps {
  review: IReview;
}

export const ReviewCard: React.FC<ReviewCardProps> = ({ review }) => {
  return (
    <Card variant="outlined" sx={{ marginBottom: 2 }}>
      <CardContent>
        <Rating
          precision={1}
          value={review.rating}
          sx={{ marginBottom: 2 }}
          readOnly
        />
        <Typography variant="body1" mb={2}>
          {review.text}
        </Typography>
        <Typography variant="body2" color="text.secondary">
          {new Date(review.created).toLocaleString()}
        </Typography>
      </CardContent>
    </Card>
  );
};

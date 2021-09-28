import { Typography } from "@mui/material";
import { ReviewCard } from "components";
import { ReviewForm } from "components/ReviewForm";
import { useRequest } from "hooks";
import { IReview } from "models";
import React, { useEffect, useState } from "react";

export interface ReviewListProps {
  productId: number;
}

export const ReviewList: React.FC<ReviewListProps> = ({ productId }) => {
  const [reviews, setReviews] = useState<IReview[]>([]);
  const { get } = useRequest<IReview[]>();

  useEffect(() => {
    get(`/product/products/${productId}/reviews`).then(setReviews as any);
  }, []);

  const handleReviewAdded = (review: IReview) => {
    setReviews((r) => [review, ...r]);
  };

  return (
    <>
      <ReviewForm productId={productId} onReviewAdded={handleReviewAdded} />
      <Typography variant="h4" mb={2}>
        Reseñas
      </Typography>
      {reviews?.map((review) => (
        <ReviewCard review={review} key={review.id} />
      ))}
      {reviews?.length === 0 && (
        <Typography color="text.secondary">Todavía no hay reseñas.</Typography>
      )}
    </>
  );
};

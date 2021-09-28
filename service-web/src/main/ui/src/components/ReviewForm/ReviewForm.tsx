import {
  Card,
  CardContent,
  Typography,
  Rating,
  Button,
  Alert,
  AlertTitle,
  CircularProgress,
  Dialog,
  DialogTitle,
  DialogContent,
  DialogContentText,
  DialogActions,
} from "@mui/material";
import { FormTextField } from "components/FormTextField";
import React from "react";
import { Controller, useForm } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";
import * as yup from "yup";
import { ResponseState, useRequest } from "hooks";
import { IReview } from "models";

export interface ReviewFormProps {
  productId: number;
  onReviewAdded: (review: IReview) => void;
}

interface IReviewForm {
  rating: number;
  text: string;
}

const schema = yup.object().shape({
  rating: yup.number().required("Ingresa la puntuación"),
  text: yup.string().required("Ingresa la reseña."),
});

export const ReviewForm: React.FC<ReviewFormProps> = ({
  productId,
  onReviewAdded,
}) => {
  const { control, handleSubmit } = useForm<IReviewForm>({
    resolver: yupResolver(schema) as any,
  });
  const { post, state, data: review, error, reset } = useRequest<IReview>();

  const handleReviewSubmit = handleSubmit((values) => {
    post(`/product/products/${productId}/reviews`, values).then((review) => {
      if (review) {
        onReviewAdded(review);
      }
    });
  });

  return (
    <Card variant="outlined" sx={{ marginBottom: 2 }}>
      <CardContent>
        <Typography variant="h5" mb={2}>
          Deja tu reseña
        </Typography>
        <form onSubmit={handleReviewSubmit}>
          <Typography component="legend">Calificación</Typography>
          <Controller
            name="rating"
            control={control}
            render={({ field: { onChange, value, name } }) => (
              <Rating
                name={name}
                precision={1}
                value={value}
                sx={{ marginBottom: 2 }}
                onChange={(event, newValue) => {
                  onChange(newValue);
                }}
              />
            )}
          />
          <FormTextField
            id="text"
            label="Reseña"
            multiline
            control={control}
            name="text"
            fullWidth
            maxRows={8}
          />
          {state === ResponseState.Error && (
            <Alert severity="error" sx={{ mt: 3 }}>
              <AlertTitle>Error</AlertTitle>
              Ocurrió un error al agregar tu reseña: {error?.message}
            </Alert>
          )}
          {state === ResponseState.Loading ? (
            <CircularProgress sx={{ mt: 3, mb: 2 }} />
          ) : (
            <Button variant="contained" type="submit" sx={{ mt: 3, mb: 2 }}>
              Enviar
            </Button>
          )}
        </form>
      </CardContent>
      <Dialog
        open={!!review}
        onClose={reset}
        aria-labelledby="alert-dialog-title"
        aria-describedby="alert-dialog-description"
      >
        <DialogTitle id="alert-dialog-title">Reseña agregada</DialogTitle>
        <DialogContent>
          <DialogContentText id="alert-dialog-description">
            ¡Tu reseña se agregó correctamente!
          </DialogContentText>
        </DialogContent>
        <DialogActions>
          <Button onClick={reset} autoFocus>
            Ok
          </Button>
        </DialogActions>
      </Dialog>
    </Card>
  );
};

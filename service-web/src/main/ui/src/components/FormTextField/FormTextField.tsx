import { TextField, TextFieldProps } from "@mui/material";
import React from "react";
import {
  useController,
  Control,
  RegisterOptions,
  FieldPath,
} from "react-hook-form";

export interface IReactHookFormFieldProps<T> {
  name: FieldPath<T>;
  control: Control<T>;
  rules?: RegisterOptions<T>;
}

export type FormTextFieldProps<T> = IReactHookFormFieldProps<T> &
  TextFieldProps;

export function FormTextField<T>({
  control,
  name,
  defaultValue,
  rules,
  ...props
}: FormTextFieldProps<T>) {
  const {
    field: { onChange, onBlur, value },
    fieldState: { invalid, isTouched, isDirty, error },
  } = useController({
    name,
    control,
    rules,
    defaultValue: defaultValue as any,
  });

  return (
    <TextField
      {...props}
      onChange={onChange}
      onBlur={onBlur}
      value={value}
      name={name}
      error={!!error}
      helperText={(error as any)?.message}
    />
  );
}

import { useCallback, useEffect, useReducer, useRef } from "react";
import AxiosStatic, { CancelTokenSource } from "axios";
import { axios } from "lib/axios";

type ReducerFn = <T>(
  state: RequestReducerState<T>,
  action: RequestAction<T>
) => RequestReducerState<T>;

type RequestAction<T> = {
  type: RequestState;
  data?: T;
  error?: Error;
};

type ResponseMapper<T> = (resData: any) => T;

enum RequestState {
  Start = "START",
  Success = "SUCCESS",
  Fail = "FAIL",
  Reset = "RESET",
}

export enum ResponseState {
  Idle = "IDLE",
  Loading = "LOADING",
  Error = "ERROR",
  Success = "SUCCESS",
}

export interface RequestReducerState<T> {
  data?: T;
  state: ResponseState;
  error?: Error;
}

const initialState = <T>({
  data,
  loading,
}: {
  data?: T;
  loading?: boolean;
}) => ({
  data: data || undefined,
  state: loading ? ResponseState.Loading : ResponseState.Idle,
  error: undefined,
});

const reducerFns: Record<RequestState, ReducerFn> = {
  [RequestState.Start]: (state) => ({
    ...state,
    state: ResponseState.Loading,
    error: undefined,
  }),
  [RequestState.Success]: (state, action) => ({
    ...state,
    data: action.data,
    state: ResponseState.Success,
  }),
  [RequestState.Fail]: (state, action) => ({
    ...state,
    state: ResponseState.Error,
    error: action.error,
  }),
  [RequestState.Reset]: (_, action) => initialState({ data: action.data }),
};

const createReducer =
  <T>() =>
  (state: RequestReducerState<T>, action: RequestAction<T>) =>
    reducerFns[action.type]?.(state, action) || state;

export const useRequest = <T>(
  defaultValue?: T,
  defaultLoading: boolean = false
) => {
  const initialAction = {
    type: RequestState.Reset,
    data: defaultValue,
    loading: defaultLoading,
  };
  const reducer = createReducer<T>();
  const [{ data, state, error }, dispatch] = useReducer(
    reducer,
    initialAction,
    initialState
  );

  const tokenRef = useRef<CancelTokenSource>();

  useEffect(() => {
    tokenRef.current = AxiosStatic.CancelToken.source();
    return () => tokenRef.current?.cancel?.();
  }, []);

  const get = useCallback(
    async (url: string, options = {}, map?: ResponseMapper<T>) => {
      dispatch({ type: RequestState.Start });
      try {
        const { data: origData } = await axios.get<T>(url, {
          cancelToken: tokenRef.current?.token,
          ...options,
        });
        const data = map?.(origData) || origData;
        dispatch({ type: RequestState.Success, data });
        return data;
      } catch (e) {
        dispatch({ type: RequestState.Fail, error: e });
        return defaultValue;
      }
    },
    []
  );

  const post = useCallback(
    async (url: string, body, options = {}, map?: ResponseMapper<T>) => {
      dispatch({ type: RequestState.Start });
      try {
        const { data: origData } = await axios.post<T>(url, body, {
          cancelToken: tokenRef.current?.token,
          ...options,
        });
        const data = map?.(origData) || origData;
        dispatch({ type: RequestState.Success, data });
        return data;
      } catch (e) {
        dispatch({ type: RequestState.Fail, error: e });
        return defaultValue;
      }
    },
    []
  );

  const put = useCallback(
    async (url: string, body, options = {}, map?: ResponseMapper<T>) => {
      dispatch({ type: RequestState.Start });
      try {
        const { data: origData } = await axios.put<T>(url, body, {
          cancelToken: tokenRef.current?.token,
          ...options,
        });
        const data = map?.(origData) || origData;
        dispatch({ type: RequestState.Success, data });
        return data;
      } catch (e) {
        dispatch({ type: RequestState.Fail, error: e });
        return defaultValue;
      }
    },
    []
  );

  const patch = useCallback(
    async (url: string, body, options = {}, map?: ResponseMapper<T>) => {
      dispatch({ type: RequestState.Start });
      try {
        const { data: origData } = await axios.patch<T>(url, body, {
          cancelToken: tokenRef.current?.token,
          ...options,
        });
        const data = map?.(origData) || origData;
        dispatch({ type: RequestState.Success, data });
        return data;
      } catch (e) {
        dispatch({ type: RequestState.Fail, error: e });
        return defaultValue;
      }
    },
    []
  );

  const del = useCallback(
    async (url: string, options = {}, map?: ResponseMapper<T>) => {
      dispatch({ type: RequestState.Start });
      try {
        const { data: origData } = await axios.delete<T>(url, {
          cancelToken: tokenRef.current?.token,
          ...options,
        });
        const data = map?.(origData) || origData;
        dispatch({ type: RequestState.Success, data });
        return data;
      } catch (e) {
        dispatch({ type: RequestState.Fail, error: e });
        return defaultValue;
      }
    },
    []
  );

  const reset = () =>
    dispatch({ type: RequestState.Reset, data: defaultValue });

  return {
    get,
    data,
    state,
    error,
    post,
    patch,
    del,
    put,
    reset,
  };
};

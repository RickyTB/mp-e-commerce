import { ILoginResult, IUser } from "models";
import React, { useCallback, useMemo, useState } from "react";

export type SessionValue = {
  accessToken?: string;
  user?: IUser;
  setSession: (session: ILoginResult | null) => void;
};

export const SessionContext = React.createContext<SessionValue>({
  accessToken: undefined,
  user: undefined,
  setSession: () => {},
});

const { Provider, Consumer } = SessionContext;

const STORAGE_KEY = "AUTH_TOKEN";

export const SessionProvider: React.FC = ({ children }) => {
  const [session, setSession] = useState<ILoginResult | null>(() => {
    if (typeof window === "undefined") return null;

    const storageValue = localStorage.getItem(STORAGE_KEY);
    if (storageValue) {
      return JSON.parse(storageValue);
    }
    return null;
  });

  const updateSession = useCallback(
    (session: ILoginResult | null) => {
      if (session) {
        localStorage.setItem(STORAGE_KEY, JSON.stringify(session));
      } else {
        localStorage.removeItem(STORAGE_KEY);
      }
      setSession(session);
    },
    [setSession]
  );

  const contextValue = useMemo<SessionValue>(
    () => ({
      accessToken: session?.accessToken,
      user: session?.user,
      setSession: updateSession,
    }),
    [session, updateSession]
  );

  return <Provider value={contextValue}>{children}</Provider>;
};

export const SessionConsumer = Consumer;

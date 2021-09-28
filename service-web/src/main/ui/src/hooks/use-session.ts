import { SessionContext } from "context";
import { useContext } from "react";

export function useSession() {
  const sessionContext = useContext(SessionContext);
  return sessionContext;
}

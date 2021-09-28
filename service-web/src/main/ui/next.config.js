const { PHASE_DEVELOPMENT_SERVER } = require("next/constants");

module.exports = (phase, { defaultConfig }) => {
  if (phase === PHASE_DEVELOPMENT_SERVER) {
    return {
      reactStrictMode: true,
      async rewrites() {
        return [
          {
            source: "/auth/:path*",
            destination: "http://localhost:8001/:path*", // Proxy to Backend
          },
          {
            source: "/product/:path*",
            destination: "http://localhost:8002/:path*", // Proxy to Backend
          },
        ];
      },
      /* development only config options here */
    };
  }

  return {
    reactStrictMode: true,
    /* config options for all phases except development here */
  };
};

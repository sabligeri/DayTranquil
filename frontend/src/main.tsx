import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import { RouterProvider, createBrowserRouter } from "react-router-dom";
import Login from "./components/Login.js";
import App from "./App.js";
import Settings from "./components/Settings.js";
import NotePage from "./components/note/NotePage.js";
import ShoppingList from "./components/note/ShoppingList.js";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Login />,
  },
  {
    path: "/",
    element: <App />,
    children: [
      {
        path: "/main",
        element: <NotePage />,
      },
      {
        path: "/shoppinglist",
        element: <ShoppingList />,
      },
      {
        path: "/settings",
        element: <Settings />,
      },
    ],
  },
]);

ReactDOM.createRoot(document.getElementById("main") as HTMLDivElement).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);

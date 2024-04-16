import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import Login from './components/Login.js';
import Register from './components/Register.js';
import App from './App.js';
import NoteList from './components/note/NoteList.js';
import Settings from './components/Settings.js';
import NotePage from './components/note/NotePage.js';


const router = createBrowserRouter([
  {
    path: "/",
    element: <App/>,
    children: [
      {
        path: "/login",
        element: <Login />
      },
      {
        path: "/register",
        element: <Register />
      },
      {
        path: "/main",
        element: <NotePage/>
      },
      {
        path: "/settings",
        element: <Settings/>
      }
    ]
  },
]);

ReactDOM.createRoot(document.getElementById('root') as HTMLDivElement).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)

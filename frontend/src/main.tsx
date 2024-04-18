import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import Login from './components/Login.js';
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

ReactDOM.createRoot(document.getElementById('main') as HTMLDivElement).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)

import './App.css';
import { Outlet, useNavigate } from "react-router-dom";
import DevelopmentHeadBar from './DevelopmentHeadBar';
import { useEffect } from 'react';

function App() {
  const nav = useNavigate()

  useEffect(() => {
    nav("/login")
  })

  return (

    <div className="root-layout">
      {/* endpoints to: login, register, main page, settings */}
      <DevelopmentHeadBar />
      <main>
        <Outlet />
      </main>
    </div>
  );
}

export default App

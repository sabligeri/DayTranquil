import './App.css';
import { Outlet, useNavigate } from "react-router-dom";
import DevelopmentHeadBar from './DevelopmentHeadBar';
import { useEffect } from 'react';

function App() {
   const nav = useNavigate()


  return (
    <div className="root-layout">
      <DevelopmentHeadBar />
      <main>
        <Outlet />
      </main>
    </div>
  );
}

export default App

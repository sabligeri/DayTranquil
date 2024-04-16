import './App.css';
import { NavLink, Outlet } from "react-router-dom";

function App() {

  return (

    <div className="root-layout">
      <header id="header">
        <nav id="navbar">
          <NavLink to="/login">
            Login
          </NavLink>
        </nav>
      </header>
      <main>
        <Outlet />
      </main>
    </div>
  );
}

export default App

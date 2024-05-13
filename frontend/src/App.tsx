
import "./App.css";
import { NavLink, Outlet } from "react-router-dom";
import DevelopmentHeadBar from "./DevelopmentHeadBar";

function App() {
  return (
    <>
      <label className="hamburger-menu">
        <input type="checkbox" />
      </label>
      <aside className="sidebar">
        <nav id="sidenav">
          <NavLink to="/login" className="nav-link"> LOGIN </NavLink>
          <NavLink to="/main" className="nav-link"> NOTES</NavLink>
          <NavLink to="/shoppinglist" className="nav-link"> SHOPPING</NavLink>
          <NavLink to="/settings" className="nav-link-settings"> SETTINGS</NavLink>
        </nav>
      </aside>
      <div className="root-layout">
        {/* endpoints to: login, register, main page, settings */}
        {/*  <DevelopmentHeadBar/>  */}
       
        <main>

          <Outlet />
        </main>
      </div>
    </>

  );
}

export default App;

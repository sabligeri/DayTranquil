import { NavLink } from "react-router-dom";

export default function DevelopmentHeadBar() {
  return (
    <header id="development-header">
      
        <NavLink to="/login">  Login </NavLink>
        <NavLink to="/register" > Register</NavLink>
        <NavLink to="/main" > MainPage</NavLink>
        <NavLink to="/settings" > Settings</NavLink>
      
    </header>
  );
}

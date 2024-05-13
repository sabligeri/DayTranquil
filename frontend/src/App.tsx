import './App.css';
import { Outlet } from "react-router-dom";
import DevelopmentHeadBar from './DevelopmentHeadBar';

function App() {
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

import "./App.css";
import { Routes, Route, BrowserRouter } from "react-router-dom";
import Aurora from "./components/Aurora";
import Forest from "./components/Forest";
import Prueba from "./components/Prueba";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Aurora/>} />
        <Route path="/Forests" element={<Forest/>} />
        <Route path="/Prueba" element={<Prueba/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;

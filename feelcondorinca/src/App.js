import logo from './logo.svg';
import './App.css';
import {BrowserRouter,Routes,Route} from 'react-router-dom';
import React, { useState } from 'react';
import Dashboard from './Componentes/Dashboard.js';
import Login from './Componentes/login.js';
import NavigateBar from './Componentes/NavigateBar.js';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import CrearUnidad from './Componentes/crearunidad.js';
import CrearEmpleado from './Componentes/CrearEmpleado.js';

function App() {
  return (
    <BrowserRouter>
     <Routes>
      <Route path="/" element={<Login/>}></Route>
      <Route path="/NavigateBar" element={<NavigateBar/>}>
      <Route index element={<Dashboard />} />
        <Route  path="Crearunidad" element ={<CrearUnidad/>}/>
        <Route  path="AdministrarU" element ={<Login/>}/>
        <Route  path="CrearE" element ={<CrearEmpleado/>}/>
      </Route>
      
     </Routes>
    </BrowserRouter>
  );
}

export default App;

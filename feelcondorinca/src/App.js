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
import AdministrarU from './Componentes/ComponentesAdmin/AdministrarU.js';
import CrearRecurso from './Componentes/crearRecurso.js';
import AdministrarR from './Componentes/ComponentesAdmin/AdministrarR.js';

function App() {
  return (
    <BrowserRouter>
     <Routes>
      <Route path="/" element={<Login/>}></Route>
      <Route path="/NavigateBar" element={<NavigateBar/>}>
      <Route index element={<Dashboard />} />
        <Route  path="Crearunidad" element ={<CrearUnidad/>}/>
        <Route  path="AdministrarU" element ={<AdministrarU/>}/>
        <Route  path="CrearE" element ={<CrearEmpleado/>}/>
        <Route  path="CrearR" element ={<CrearRecurso/>}/>
        <Route  path="AdministrarR" element ={<AdministrarR/>}/>
      </Route>
      
     </Routes>
    </BrowserRouter>
  );
}

export default App;

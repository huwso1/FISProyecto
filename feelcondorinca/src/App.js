import logo from './logo.svg';
import './App.css';
import React, { useState } from 'react';

function Login() {
  return(
      <div className="contenedor-login">
        <h1>Usuario</h1>
        <input type="text" name="Usuario"/>
        <h1>Contraseña</h1>
        <input type="text" name="Contrasena"/>
      </div>
  );
}

function App() {
  return (
    <div>
      <header>Esto es el login</header>
      <Login />
      <img src={require("../src/Imagenes/Facilito.png")}/>
    </div>
  );
}

export default App;

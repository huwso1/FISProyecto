import React from "react";
import {Outlet} from 'react-router-dom';

function Dashboard() {
    return(
        <div style={{display: 'flex',alignItems: 'center',justifyContent:'center'}}>
      <h1 > Bienvenido <br/>{window.sessionStorage.getItem("nombre")} <br/>{window.sessionStorage.getItem("apellido")}</h1>
      <Outlet/>
      </div>
    );
}
export default Dashboard;
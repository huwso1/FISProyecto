import React from "react";
import {Outlet} from 'react-router-dom';

function Dashboard() {
    return(
        <div>
      <h1>Aqui se listaran las unidades, y los planes de holman para erradicar a los gatos del mundo</h1>
      <Outlet/>
      </div>
    );
}
export default Dashboard;
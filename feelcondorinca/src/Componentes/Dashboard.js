import React from "react";
import {Outlet} from 'react-router-dom';

function Dashboard() {
    return(
        <div>
      <h1>Soy holman y odio a los gatos del mundo</h1>
      <Outlet/>
      </div>
    );
}
export default Dashboard;
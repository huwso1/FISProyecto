import React from 'react';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Container from 'react-bootstrap/Container';
import {Outlet} from 'react-router-dom';
import './css/Navbar.css';

 function NavigateBar() {
  return (
    <div>
<Navbar  bg="primary" variant="dark" expand="lg">
      <Container>
        <Nav classname="me-auto">
        <Navbar.Brand href="/NavigateBar/Crearunidad">Crear Unidad</Navbar.Brand>
        <Navbar.Brand href="/NavigateBar/AdministrarU">Administrar unidad</Navbar.Brand>
        <Navbar.Brand href="/NavigateBar/CrearE">Crear Empleado</Navbar.Brand>
        </Nav>
        </Container>
        
    </Navbar>
    <Outlet/>
    </div>
    
  );
  
}
export default NavigateBar;
import React from 'react';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Container from 'react-bootstrap/Container';
import {Outlet} from 'react-router-dom';
import './css/Navbar.css';
import {useEffect} from 'react';
import {useNavigate} from 'react-router-dom';

 function NavigateBar() {
  const navigate=useNavigate();
  useEffect(()=>{
    if(window.sessionStorage.getItem("rol")!="ADMIN"){
      window.sessionStorage.clear();
      navigate("/");
    }
  },[])
  return (
    <div style={{paddingBottom:"50rem"}}>
<Navbar  bg="primary" variant="dark" expand="lg">
      <Container>
        <Nav classname="me-auto">
        <Navbar.Brand href="/NavigateBar/Crearunidad">Crear Unidad</Navbar.Brand>
        <Navbar.Brand href="/NavigateBar/AdministrarU">Administrar unidad</Navbar.Brand>
        <Navbar.Brand href="/NavigateBar/CrearE">Crear Empleado</Navbar.Brand>
        <Navbar.Brand href="/NavigateBar/CrearR">Crear Recurso</Navbar.Brand>
        <Navbar.Brand href="/NavigateBar/AdministrarR">Administrar recurso</Navbar.Brand>
        </Nav>
      </Container>

</Navbar>
    <Outlet/>
    </div>
    
  );
  
}
export default NavigateBar;
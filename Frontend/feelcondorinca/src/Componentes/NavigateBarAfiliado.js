import React from 'react';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Container from 'react-bootstrap/Container';
import {Outlet} from 'react-router-dom';
import './css/Navbar.css';
import {useEffect} from 'react';
import {useNavigate} from 'react-router-dom';

function NavigateBarAfiliado() {
    const navigate=useNavigate();
    useEffect(()=>{
      if(window.sessionStorage.getItem("rol")!="AFILIADO"){
        window.sessionStorage.clear();
        navigate("/");
      }
    },[])
    return (
        <div>
            <Navbar bg="primary" variant="dark" expand="lg">
                <Container>
                    <Nav classname="me-auto">
                        <Navbar.Brand href="/NavigateBarAfiliado/Consultarrecursos"><img src={require("./Imagenes/iconolupa.png")} alt="icon"/>Buscar
                            recursos</Navbar.Brand>
                        <Navbar.Brand href="/NavigateBarAfiliado/MisReservas"><img src={require("./Imagenes/calendar (1).png")} alt="icon"/>Consultar
                            reservas</Navbar.Brand>
                    </Nav>
                </Container>

            </Navbar>
            <Outlet/>
        </div>
    )
}

export default NavigateBarAfiliado;
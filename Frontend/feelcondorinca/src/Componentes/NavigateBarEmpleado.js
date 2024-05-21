import React from 'react';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Container from 'react-bootstrap/Container';
import {Outlet} from 'react-router-dom';
import './css/Navbar.css';

function NavigateBarEmpleado() {

    return (
        <div>
            <Navbar bg="primary" variant="dark" expand="lg">
                <Container>
                    <Nav classname="me-auto">
                        <Navbar.Brand href="/NavigateBarEmpleado/ConsultarReservasUnidad"><img src={require("./Imagenes/iconolupa.png")} alt="icon"/>Consultar Reservas de Unidad</Navbar.Brand>
                    </Nav>
                </Container>

            </Navbar>
            <Outlet/>
        </div>
    )
}

export default NavigateBarEmpleado;
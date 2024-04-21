import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import './css/Unidad.css';
function crearUnidad (){

return(
<div className="center-card">

<Card style={{border:'none'}} >

<h2> Ingrese los datos de la nueva unidad</h2>

</Card>

<Card style={{  width:'40rem', marginTop:'7rem' }}>
<CardBody>
<Form>
      <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
        <Form.Label>Nombre Unidad</Form.Label>
        <Form.Control type="text" placeholder="name@example.com" />
      </Form.Group>
      <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
        <Form.Label>Intervalo minimo de prestamo(En minutos)</Form.Label>
        <Form.Control as="textarea" rows={3} />
        <Form.Label>Horarios</Form.Label>
        <Form.Control type="range" min="0000" max="2400" step="1" />
      </Form.Group>
    </Form>
</CardBody>
</Card>

</div>
);
}
export default crearUnidad;
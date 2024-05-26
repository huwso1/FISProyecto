import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import CardGroup from 'react-bootstrap/CardGroup';
import Card  from 'react-bootstrap/Card';
import '../css/Unidad.css';
import axios from 'axios';
import Empleadomap from './Mapeo/Empleadomap';

function ListaEmpleados({idunidad}){
const [Empleados,setEmpleados]=useState(["Jhon","Alex","Esteban"]);

var peticionEmpleados = () => {
    return new Promise((resolve, reject) => {
        
        axios.post("http://localhost:8080/Administracion/Empleados", {"idunidad":idunidad})
            .then((response) => {
                // Resolvemos la promesa con los datos recibidos
                resolve(response.data);
            })
            .catch((error) => {
                // Rechazamos la promesa con el mensaje de error
                
            });
    });
  };

useEffect(() => {
    const fetchData = async () => {
    
        try {
            //Aqui se realizara la peticion al back
          const data=await peticionEmpleados();
          
          parseUnidad(data);
          console.log(Empleados);
            
            
            // Aquí puedes ver los datos en la consola
        } catch (error) {
            // Manejamos cualquier error que pueda ocurrir
            //Se setea la lista con una lista ejemplo, la idea es que el back envie una lista json con objetos analista general
            // que tendran como atributos, nombre y id
            console.error('Error al obtener los datos:', error);
        }
    };
    fetchData();
  }, []);

  function parseUnidad(data){
    
    var listaud=[];
      data.map((unidad)=>{
        
        var li;
        var lf;
        var mi;
        var mf;
        var mii;
        var mif;
        var ji;
        var jf;
        var vi;
        var vf;
        var si;
        var sf;

         unidad.idHorarioDisponible.horarios.map((horario,index,elements)=>{
            if(horario.diaSemana==="LUNES"){
                if(horario.horaInicial.length<2){
                li="0"+horario.horaInicial+":"+"00";
            }else{
                li=horario.horaInicial+":"+"00";
            }
            if(horario.horaFinal.length<2){
                lf="0"+horario.horaFinal+":"+"00";
            }else{
                lf=horario.horaFinal+":"+"00";
            }
                
            }
            if(horario.diaSemana==="MARTES"){
                if(horario.horaInicial.length<2){
                mi="0"+horario.horaInicial+":"+"00";
            }else{
                mi=horario.horaInicial+":"+"00";
            }
            if(horario.horaFinal.length<2){
                mf="0"+horario.horaFinal+":"+"00";
            }else{
                mf=horario.horaFinal+":"+"00";
            }
                
            }
            if(horario.diaSemana==="MIERCOLES"){
                console.log(mii);
                if(horario.horaInicial.length<2){
                mii="0"+horario.horaInicial+":"+"00";
            }else{
                mii=horario.horaInicial+":"+"00";
            }
            if(horario.horaFinal.length<2){
                mif="0"+horario.horaFinal+":"+"00";
            }else{
                mif=horario.horaFinal+":"+"00";
            }
                
            }
            if(horario.diaSemana==="JUEVES"){
                if(horario.horaInicial.length<2){
                ji="0"+horario.horaInicial+":"+"00";
            }else{
                ji=horario.horaInicial+":"+"00";
            }
            if(horario.horaFinal.length<2){
                jf="0"+horario.horaFinal+":"+"00";
            }else{
                jf=horario.horaFinal+":"+"00";
            }
                
            }
            if(horario.diaSemana==="VIERNES"){
                if(horario.horaInicial.length<2){
                vi="0"+horario.horaInicial+":"+"00";
            }else{
                vi=horario.horaInicial+":"+"00";
            }
            if(horario.horaFinal.length<2){
                vf="0"+horario.horaFinal+":"+"00";
            }else{
                vf=horario.horaFinal+":"+"00";
            }
                
            }
            if(horario.diaSemana==="SABADO"){
                if(horario.horaInicial.length<2){
                si="0"+horario.horaInicial+":"+"00";
            }else{
                si=horario.horaInicial+":"+"00";
            }
            if(horario.horaFinal.length<2){
                sf="0"+horario.horaFinal+":"+"00";
            }else{
                sf=horario.horaFinal+":"+"00";
            }
                
            }
            
         })
         
         listaud.push(new Empleadomap(unidad.idUsuario.numIdentificacion,unidad.idUsuario.nombres,unidad.idUsuario.apellidos,unidad.correoCorporativo,unidad.idUnidad.idUnidad,li,lf,mi,mf,mii,mif,ji,jf,vi,vf,si,sf));
       }) 
       console.log(listaud);
       setEmpleados(listaud);
    }
return(
    <div style={{width:"30rem" , marginTop:"7rem" ,paddingRight:"4rem"}}>
<Card >
    <CardGroup> 
        <Card>Nombre Empleado</Card>
        <Card>Horarios</Card>
    </CardGroup>
    
   
        {Empleados.map((empleado)=>{
            return (<CardGroup>
                <Card>
                {empleado.nombre+' '+empleado.apellido}
                </Card>
                <Card>
                    {'Lunes'+empleado.horariolunesi+'-'+empleado.horariolunesf +'\n'}<br/>
                    {'Martes'+empleado.horariomartesi+'-'+empleado.horariomartesf +'\n'}<br/>
                    {'Miercoles'+empleado.horariomiercolesi+'-'+empleado.horariomiercolesf +'\n'}<br/>
                    {'Jueves'+empleado.horariojuevesi+'-'+empleado.horariojuevesf +'\n'}<br/>
                    {'Viernes'+empleado.horarioviernesi+'-'+empleado.horarioviernesf +'\n'}<br/>
                    {'Sabados'+empleado.horariosabadoi+'-'+empleado.horariosabadof +'\n'}<br/>
                </Card>
                </CardGroup>);
        })}
    
    
</Card>
</div>
);


}
export default ListaEmpleados;
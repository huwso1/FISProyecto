import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import '../css/Unidad.css';
import Unidadmap from './Mapeo/Unidadmap';
import Listaunidades from './Listaunidades';
import CrearUnidad from '../crearunidad';
import ListaEmpleados from './ListaEmpleados';
import axios from 'axios';


function AdministrarU(){
const [idUnidad,SetidUnidad]=useState();
const [ordenarPor,setOrdenar]=useState("");
const ordenar=["Nombre","Cantidad de reservas"];
const [unidades,setUnidades]=useState([new Unidadmap(1,"Tinderud",32),new Unidadmap(2,"Laboratorios",92),new Unidadmap(3,"Homicidios",300)]);
const [isModifying,setModifying]=useState(true);
const [nombreM,setNombrem]=useState('');

var peticionUnidades = () => {
  return new Promise((resolve, reject) => {
      
      axios.post("http://localhost:8080/Administracion/Unidades", { })
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
          // Esperamos la resolución de la promesa usando await
          const data = await peticionUnidades();
          // Una vez que la promesa se resuelve, actualizamos el estado con los datos recibidos
          
          
          parseUnidad(data);

          
          
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
       if(li==null && horario.diaSemana==="LUNES"){
           if((horario.horaInicial+"").length<2){
        li= "0"+horario.horaInicial+":00"
       }else{
         li= horario.horaInicial+":00"
       }

       }
       if(lf==null && elements.at(index+1).diaSemana==="MARTES"){
         if((horario.horaFinal+"").length<2){
           lf= "0"+horario.horaFinal+":00"
          }else{
            lf= horario.horaFinal+":00"
          }
       }
       if(mi==null && horario.diaSemana==="MARTES"){
         if((horario.horaInicial+"").length<2){
      mi= "0"+horario.horaInicial+":00"
     }else{
       mi= horario.horaInicial+":00"
     }

     }
     if(mf==null && elements.at(index+1).diaSemana==="MIERCOLES"){
       if((horario.horaFinal+"").length<2){
         mf= "0"+horario.horaFinal+":00"
        }else{
          mf= horario.horaFinal+":00"
        }
     }
     if(mii==null && horario.diaSemana==="MIERCOLES"){
       if((horario.horaInicial+"").length<2){
    mii= "0"+horario.horaInicial+":00"
   }else{
     mii= horario.horaInicial+":00"
   }

   }
   if(mif==null && elements.at(index+1).diaSemana==="JUEVES"){
     if((horario.horaFinal+"").length<2){
       mif= "0"+horario.horaFinal+":00"
      }else{
        mif= horario.horaFinal+":00"
      }
   }
   if(ji==null && horario.diaSemana==="JUEVES"){
     if((horario.horaInicial+"").length<2){
  ji= "0"+horario.horaInicial+":00"
 }else{
   ji= horario.horaInicial+":00"
 }

 }
 if(jf==null && elements.at(index+1).diaSemana==="VIERNES"){
   if((horario.horaFinal+"").length<2){
     jf= "0"+horario.horaFinal+":00"
    }else{
      jf= horario.horaFinal+":00"
    }
 }
 if(vi==null && horario.diaSemana==="VIERNES"){
   if((horario.horaInicial+"").length<2){
vi= "0"+horario.horaInicial+":00"
}else{
 vi= horario.horaInicial+":00"
}

}
if(vf==null && elements.at(index+1).diaSemana==="SABADO"){
 if((horario.horaFinal+"").length<2){
   vf= "0"+horario.horaFinal+":00"
  }else{
    vf= horario.horaFinal+":00"
  }
}
if(si==null && horario.diaSemana==="SABADO"){
 if((horario.horaInicial+"").length<2){
si= "0"+horario.horaInicial+":00"
}else{
si= horario.horaInicial+":00"
}

}
if(sf==null && elements.length-1==index){
if((horario.horaFinal+"").length<2){
 sf= "0"+horario.horaFinal+":00"
}else{
  sf= horario.horaFinal+":00"
}
}
     })
     
     listaud.push(new Unidadmap(unidad.idUnidad,unidad.nombre,unidad.cantidaddereservas,li,lf,mi,mf,mii,mif,ji,jf,vi,vf,si,sf,unidad.intervaloMinimoPrestamo));
   }) 
   setUnidades(listaud);
}


const handlermod=(nombreunidad,idunidad)=>{
    SetidUnidad(idunidad);
    setNombrem(nombreunidad);
    setModifying(false);
}
function ordenarr(ordenar){
  setOrdenar(ordenar);
  if(ordenar==='Nombre'){
    var aux=unidades.slice();
    console.log(ordenar);
    aux.sort((a, b) => {
        const nameA = a.nombre.toUpperCase(); // ignore upper and lowercase
        const nameB = b.nombre.toUpperCase(); // ignore upper and lowercase
        if (nameA < nameB) {
          return -1;
        }
        if (nameA > nameB) {
          return 1;
        }
      
        // names must be equal
        return 0;
      });
      setUnidades(aux);
}
if(ordenar==='Cantidad de reservas'){
    var aux=unidades.slice();
    unidades.sort((a, b) => {
        return a.cantidaddereservas-b.cantidaddereservas;
        
      });
      setUnidades(aux);
}
}
if(isModifying){
return(

<div style={{display:'flex',height:'100em'}} >
    
   <Card style={{ minHeight:'100%', backgroundColor:'#D6F2F5', width:'20%', paddingTop:'4rem',height:'100%',alignItems:'center' }}>
    <Form.Label style={{left:'50%'}}>Ordenar Por</Form.Label>
    <Form.Control as='select' placeholder='Ordenar Por' onChange={(element)=>{ordenarr(element.target.value)}}>
       { ordenar.map((element)=>{
        return <option value={element}>{element}</option>;
        })}
    </Form.Control>
</Card>
<Card style={{width:'80%'}}>
    <Listaunidades unidades={unidades} handlerunidades={handlermod}> </Listaunidades>
</Card>


</div>


)}else{
    return(
    <div>
    <CardGroup>
     <ListaEmpleados idunidad={idUnidad}></ListaEmpleados>
    <CrearUnidad idunidad={idUnidad} nombreunidad={nombreM}></CrearUnidad>
    </CardGroup>
    </div>
  )
}
}
export default AdministrarU;
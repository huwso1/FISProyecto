import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import './css/Unidad.css';
import axios from 'axios';
import Unidadmap from './ComponentesAdmin/Mapeo/Unidadmap';
import {useState,useEffect} from 'react';
function CrearUnidad ({idunidad,nombreunidad}){
var horas=["00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"];
const [Nombre,setNombre]=useState("");
const [Lunesi,Setlunesi]=useState("");
const [Lunesf,Setlunesf]=useState("");
const [Martesi,Setmartesi]=useState("");
const [Martesf,Setmartesf]=useState("");
const [Miercolesi,Setmiercolesi]=useState("");
const [Miercolesf,Setmiercolesf]=useState("");
const [Juevesi,Setjuevesi]=useState("");
const [Juevesf,Setjuevesf]=useState("");
const [Viernesi,Setviernesi]=useState("");
const [Viernesf,Setviernesf]=useState("");
const [Sabadosi,Setsabadosi]=useState("");
const [Sabadosf,SetSabadosf]=useState("");
const [message,SetMessage]=useState("");
const [intervalominimo,SetInterval]=useState("");
const [isModifying,setModifying]=useState(false);
const [descripcion,setDescripcion]=useState("");

var peticionThisUnidad = () => {
  return new Promise((resolve, reject) => {
      
      axios.post("http://localhost:8080/Administracion/ModUnidad", {"idUnidad":idunidad})
          .then((response) => {
              // Resolvemos la promesa con los datos recibidos
              resolve(parseRecurso(response.data));
          })
          .catch((error) => {
              // Rechazamos la promesa con el mensaje de error
              
          });
  });
};

useEffect(() => {
  const fetchData = async () => {
  
      try {
        if(idunidad!=null){
          //Aqui se realizara la peticion al back
        const data=await peticionThisUnidad();
        console.log(data.descripcion);
        updateHorariosModificacion(data);
        setNombre(nombreunidad);
        
        
        }
           
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

async function updateHorariosModificacion(unidad){
  console.log(unidad.descripcion);
  try{
    await Promise.all([
  Setlunesi(unidad.horariolunesi),
  Setlunesf(unidad.horariolunesf),
  Setmartesi(unidad.horariomartesi),
  Setmartesf(unidad.horariomartesf),
  Setmiercolesi(unidad.horariomiercolesi),
  Setmiercolesf(unidad.horariomiercolesf),
  Setjuevesi(unidad.horariojuevesi),
  Setjuevesf(unidad.horariojuevesf),
  Setviernesi(unidad.horarioviernesi),
  Setviernesf(unidad.horarioviernesf),
  Setsabadosi(unidad.horariosabadoi),
  SetSabadosf(unidad.horariosabadof),
  setDescripcion(unidad.descripcion),
  setModifying(true),
  SetInterval(unidad.intervalo)
  
  
  ]);
  }catch(error){
    console.error(error);
  }
}

const crearUnidadP=(element)=>{
  element.preventDefault();
  if(isModifying==false){
  if(intervalominimo!="" && intervalominimo!=null && Nombre!=="" && Nombre!=null && intervalominimo>0){
 axios.post("http://localhost:8080/Administracion/CrearUnidad",{"Nombre":Nombre,"Lunesi":Lunesi,"Lunesf":Lunesf,"Martesi":Martesi,"Martesf":Martesf,
 "Miercolesi":Miercolesi,"Miercolesf":Miercolesf,"Juevesi":Juevesi,"Juevesf":Juevesf,"Viernesi":Viernesi,"Viernesf":Viernesf,"Sabadosi":Sabadosi,"Sabadosf":Sabadosf,"intervalominimo":intervalominimo,
 "descripcion":descripcion
 }).then((response)=>{
  window.location.reload();
  SetMessage(response.data.message);
 }).catch((error)=>{
  SetMessage(error.response.data.message);
 });
}else{
  SetMessage("Campos como el intervalo minimo de prestamo y el nombre de la unidad son obligatorios");
}
  }else{
    if(intervalominimo!="" && intervalominimo!=null && Nombre!=="" && Nombre!=null && intervalominimo>0){
      axios.post("http://localhost:8080/Administracion/ModificarUnidad",{"Nombre":Nombre,"Lunesi":Lunesi,"Lunesf":Lunesf,"Martesi":Martesi,"Martesf":Martesf,
      "Miercolesi":Miercolesi,"Miercolesf":Miercolesf,"Juevesi":Juevesi,"Juevesf":Juevesf,"Viernesi":Viernesi,"Viernesf":Viernesf,"Sabadosi":Sabadosi,"Sabadosf":Sabadosf,"intervalominimo":intervalominimo,
      "descripcion":descripcion,"idUnidad":idunidad
      }).then((response)=>{
      window.location.reload();
       SetMessage(response.data.message);
      }).catch((error)=>{
       SetMessage(error.response.data.message);
      });
     }else{
       SetMessage("Campos como el intervalo minimo de prestamo y el nombre de la unidad son obligatorios");
     }
  }

}

function parseRecurso(data){
  var unidad=data;
  
var listaud=[];
  
    
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
     console.log(unidad.descripcion);
     return new Unidadmap(unidad.idRecurso,unidad.nombre,unidad.cantidaddereservas,li,lf,mi,mf,mii,mif,ji,jf,vi,vf,si,sf,unidad.intervaloMinimoPrestamo,unidad.descripcion);
   

}


function minhour(Horainicial){
  var index=0;
  horas.find((hour)=>{ index++; if(hour==Horainicial){ return true;} return false;})
  
  return horas.slice(index);
  

};

function updateMonday(horai){
  Setlunesi(horai);

  var index=0;
    horas.find((hour)=>{ index++; if(hour==horai){return true;}return false})
    Setlunesf(horas.at(index));

}
function updateTuesday(horai){
  Setmartesi(horai);

  var index=0;
    horas.find((hour)=>{ index++; if(hour==horai){return true;}return false})
    Setmartesf(horas.at(index));
    
}
function updateWednesday(horai){
  Setmiercolesi(horai);

  var index=0;
    horas.find((hour)=>{ index++; if(hour==horai){return true;}return false})
    Setmiercolesf(horas.at(index));
    
}
function updatethursday(horai){
  Setjuevesi(horai);

  var index=0;
    horas.find((hour)=>{ index++; if(hour==horai){return true;}return false})
    Setjuevesf(horas.at(index));
    
}

function updateFriday(horai){
  Setviernesi(horai);

  var index=0;
    horas.find((hour)=>{ index++; if(hour==horai){return true;}return false})
    Setviernesf(horas.at(index));
    
}

function updateSaturday(horai){
  Setsabadosi(horai);

  var index=0;
    horas.find((hour)=>{ index++; if(hour==horai){return true;}return false})
    SetSabadosf(horas.at(index));
    
}
  



function titulounidad(){
  if(nombreunidad!==null){
    return <h2> Ingrese los datos de la unidad {nombreunidad}</h2>;
  }
  return <h2> Ingrese los datos de la nueva unidad </h2>;
}
function Nameset(){
  if(nombreunidad!=null){
    return(<></>);
  }
  return <><Form.Label >Nombre Unidad</Form.Label>
  <Form.Control type="text" placeholder="Distri Sanitas" value={Nombre} onChange={(element)=>{setNombre(element.target.value)}} /> </>;
}



return(
  
<div  className="center-card">

<Card style={{border:'none', marginTop:'3rem',paddingLeft:"10%"}} >

{titulounidad()}

</Card>

<Card style={{  width:'40rem', marginTop:'4rem', backgroundColor:'#D6F2F5' }}>

<CardBody>
<Form>
      <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
      {Nameset()}
        
      </Form.Group>
      <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
        <Form.Label>Intervalo minimo de prestamo(En minutos)</Form.Label>
        <Form.Control as="input" type="number" value={intervalominimo} onChange={(element)=>{
            SetInterval(element.target.value);
        }} />
        <Form.Label>Descripcion</Form.Label>
        <Form.Control as="textarea"   value={descripcion}  onChange={(element)=>{
            setDescripcion(element.target.value);
        }} />
          
        
        <Form.Label >Horarios</Form.Label>
        <div></div>
        <Card>
        <div className="center-div">
        <Form.Label>Lunes</Form.Label>
        </div>
        <div className="table-div">
       
          <div className='table-row'>
        <Form.Label style={{padding:'0em 2em'}}>Hora inicio</Form.Label>
        <Form.Control as="select" value={Lunesi} onChange={(e)=>{updateMonday(e.target.value.trim()) }} >
          
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Lunesf} onChange={(e)=>{Setlunesf(e.target.value.trim()) }} >
        {minhour(Lunesi).map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        
        <div className="center-div">
        <Form.Label>Martes</Form.Label>
        </div>
        <div className="table-div">
       
          <div className='table-row'>
        <Form.Label style={{padding:'0em 2em'}}>Hora inicio</Form.Label>
        <Form.Control as="select" value={Martesi} onChange={(e)=>{updateTuesday(e.target.value.trim()) }} >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Martesf} onChange={(e)=>{Setmartesf(e.target.value.trim())}} >
        {minhour(Martesi).map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        
        <div className="center-div">
        <Form.Label>Miercoles</Form.Label>
        </div>
        <div className="table-div">
       
          <div className='table-row'>
        <Form.Label style={{padding:'0em 2em'}}>Hora inicio</Form.Label>
        <Form.Control as="select" value={Miercolesi} onChange={(e)=>{updateWednesday(e.target.value.trim()) }} >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Miercolesf} onChange={(e)=>{Setmiercolesf(e.target.value.trim())}} >
        {minhour(Miercolesi).map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <div className="center-div">
        <Form.Label>Jueves</Form.Label>
        </div>
        <div className="table-div">
       
          <div className='table-row'>
        <Form.Label style={{padding:'0em 2em'}}>Hora inicio</Form.Label>
        <Form.Control as="select" value={Juevesi} onChange={(e)=>{updatethursday(e.target.value.trim()) } } >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Juevesf} onChange={(e)=>{Setjuevesf(e.target.value.trim())}}  >
        {minhour(Juevesi).map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
    
        <div className="center-div">
        <Form.Label>Viernes</Form.Label>
        </div>
        <div className="table-div">
       
          <div className='table-row'>
        <Form.Label style={{padding:'0em 2em'}}>Hora inicio</Form.Label>
        <Form.Control as="select" value={Viernesi} onChange={(e)=>{updateFriday(e.target.value.trim()) }} >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Viernesf} onChange={(e)=>{Setviernesf(e.target.value.trim())}} >
        {minhour(Viernesi).map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
      
      <div className="center-div">
        <Form.Label>Sabado</Form.Label>
        </div>
        <div className="table-div">
       
          <div className='table-row'>
        <Form.Label style={{padding:'0em 2em'}}>Hora inicio</Form.Label>
        <Form.Control as="select" value={Sabadosi} onChange={(e)=>{updateSaturday(e.target.value.trim()) }}  >
        {horas.map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Sabadosf} onChange={(e)=>{SetSabadosf(e.target.value.trim())}} >
        {minhour(Sabadosi).map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        
        </div>
        </Card>
        </Form.Group>
        <div style={{padding:'1em 2em'}}></div>
        <Form.Control as="button" style={{padding:'2px 2em',backgroundColor:'#92a8d1'}} onClick={crearUnidadP}>Crear unidad</Form.Control>
    </Form>
    
</CardBody>

</Card>
<h1>{message}</h1>
</div>
);
}
export default CrearUnidad;
import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import './css/Unidad.css';
import axios from 'axios';
import Unidadmap from './ComponentesAdmin/Mapeo/Unidadmap';

function CrearEmpleado(){
const [listaUnidades,setlistaUnidades] = useState([new Unidadmap(1,"Homicidios"),new Unidadmap(2,"Laboratorios"),new Unidadmap(3,"Documentales Holman")]);
const [Unidad,setUnidad]=useState('');
const [nombre,setNombre]=useState('');
const [apellido,setApellido]=useState('');
const [documento,setDocumento]=useState('');
const [telefono,setTelefono]=useState('');
var horas=["00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"];
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

const crearempleado=(element)=>{
  element.preventDefault();
  if(  nombre!=="" && apellido!=="" && documento!=="" && telefono!=="" && documento.length<=10 ){
  axios.post("http://localhost:8080/Administracion/CrearEmpleado",{"Nombre":nombre,"Apellido":apellido,"Documento":documento,"Telefono":telefono,"Lunesi":Lunesi,"Lunesf":Lunesf,"Martesi":Martesi,"Martesf":Martesf,
  "Miercolesi":Miercolesi,"Miercolesf":Miercolesf,"Juevesi":Juevesi,"Juevesf":Juevesf,"Viernesi":Viernesi,"Viernesf":Viernesf,"Sabadosi":Sabadosi,"Sabadosf":Sabadosf,"idUnidad":Unidad.id
  }).then((response)=>{
  SetMessage(response.data.message);
  }).catch((error)=>{
  SetMessage(error.response.data.message);
  });
  }else{
  SetMessage("Los datos basicos del empleado son campos obligatorios");
  }
  
  }

function minhour(Horainicial,horaFinal){
  var index=0;
  var indexf=0;
  console.log(Unidad);
  horas.find((hour)=>{ index++; if(hour==Horainicial){ return true;} return false;})
    if(horaFinal!=null){
      horas.find((hour)=>{ indexf++; if(hour==horaFinal){ return true;} return false;})
        console.log(index);
        console.log(indexf);
      return horas.slice(index-1,indexf);
    }
  return horas.slice(index);
  

};


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
   
   listaud.push(new Unidadmap(unidad.idUnidad,unidad.nombre,null,li,lf,mi,mf,mii,mif,ji,jf,vi,vf,si,sf,unidad.intervaloMinimoPrestamo));
 }) 
 setlistaUnidades(listaud);
}


function updateHorarios(id){
setUnidad(listaUnidades.find((unidad)=>{if(unidad.id==id){return true} return false;}))
Setlunesi(Unidad.horariolunesi);
Setlunesf(Unidad.horariolunesf);
Setmartesi(Unidad.horariomartesi);
Setmartesf(Unidad.horariomartesf);
Setmiercolesi(Unidad.horariomiercolesi);
Setmiercolesf(Unidad.horariomiercolesf);
Setjuevesi(Unidad.horariojuevesi);
Setjuevesf(Unidad.horariojuevesf);
Setviernesi(Unidad.horarioviernesi);
Setviernesf(Unidad.horarioviernesf);
Setsabadosi(Unidad.horariosabadoi);
SetSabadosf(Unidad.horariosabadof);
}

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



return(
    <div className="center-card2">

<h2> Ingrese los datos del nuevo empleado</h2>

<Card style={{  width:'40rem', marginTop:'3rem', backgroundColor:'#D6F2F5' }}>
<CardBody>
<Form>
      <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
        <Form.Label >Nombre Empleado</Form.Label>
        <Form.Control type="text" placeholder="Robinson" value={nombre} onChange={(e)=>{setNombre(e.target.value.trim())}} />
        <Form.Label >Apellido Empleado</Form.Label>
        <Form.Control type="text" placeholder="Crussoe" value={apellido} onChange={(e)=>{setApellido(e.target.value.trim())}} />
      </Form.Group>
      <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
        <Form.Label>Documento empleado</Form.Label>
        <Form.Control type="number" placeholder="Documento" value={documento} onChange={(e)=>{setDocumento(e.target.value.trim())}} />
        <Form.Label>Telefono</Form.Label>
        <Form.Control type="number" placeholder="3224147756" value={telefono} onChange={(e)=>{setTelefono(e.target.value.trim())}} />
        <Form.Label>Unidad</Form.Label>
        <Form.Control as="select" placeholder="Unidad" onChange={(element)=>{updateHorarios(element.target.value)}} onClick={(element)=>{updateHorarios(element.target.value)}}>
          {listaUnidades.map((opcionunidad)=>{
            return <option value={opcionunidad.id}>{opcionunidad.nombre}</option>
          })}
        </Form.Control>
        
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
        {minhour(Unidad.horariolunesi,Unidad.horariolunesf).map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Lunesf} onChange={(e)=>{Setlunesf(e.target.value.trim()) }} >
        {minhour(Lunesi,Unidad.horariolunesf).map((e)=>{
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
        {minhour(Unidad.horariomartesi,Unidad.horariomartesf).map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Martesf} onChange={(e)=>{Setmartesf(e.target.value.trim())}} >
        {minhour(Martesi,Unidad.horariomartesf).map((e)=>{
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
        {minhour(Unidad.horariomiercolesi,Unidad.horariomiercolesf).map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Miercolesf} onChange={(e)=>{Setmiercolesf(e.target.value.trim())}} >
        {minhour(Miercolesi,Unidad.horariomiercolesf).map((e)=>{
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
        {minhour(Unidad.horariojuevesi,Unidad.horariojuevesf).map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Juevesf} onChange={(e)=>{Setjuevesf(e.target.value.trim())}}  >
        {minhour(Juevesi,Unidad.horariojuevesf).map((e)=>{
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
        {minhour(Unidad.horarioviernesi,Unidad.horarioviernesf).map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Viernesf} onChange={(e)=>{Setviernesf(e.target.value.trim())}} >
        {minhour(Viernesi,Unidad.horarioviernesf).map((e)=>{
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
        {minhour(Sabadosi,Unidad.horariosabadof).map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        
        </Form.Control>
        </div>
        <Form.Label style={{padding:'0em 2em'}}>Hora termino</Form.Label>
        <Form.Control as="select" value={Sabadosf} onChange={(e)=>{SetSabadosf(e.target.value.trim())}} >
        {minhour(Sabadosi,Unidad.horariosabadof).map((e)=>{
          return <option value={e}>{e}</option>;
        })}
        </Form.Control>
        
        </div>
        </Card>
        </Form.Group>
        <div style={{padding:'1em 2em'}}></div>
        <Form.Control as="button" style={{padding:'2px 2em',backgroundColor:'#92a8d1'}} onClick={crearempleado}>Crear unidad</Form.Control>
    </Form>
    
</CardBody>

</Card>
<h1>{message}</h1>
</div>
)
}
export default CrearEmpleado;
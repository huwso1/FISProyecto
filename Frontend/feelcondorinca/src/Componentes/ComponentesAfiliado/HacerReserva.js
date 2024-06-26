import {useState, useEffect} from 'react';
import React from 'react';
import CardBody from 'react-bootstrap/esm/CardBody';
import Card  from 'react-bootstrap/Card';
import CardGroup from 'react-bootstrap/CardGroup';
import Form from 'react-bootstrap/Form';
import '../css/Unidad.css';
import Recursomap from '../ComponentesAdmin/Mapeo/Recursomap';
import axios from 'axios';
import Swal from 'sweetalert2';



function MenuReserva({Recursoareservar}){
    //Linea de prueba
  
    //Linea de prueba
    const [FechadeReserva,setFechadeReserva]=useState( inicializarfecha());
    const [EHseleccionados,setEH]=useState([]);
    const [diaseleccionado,setDiaSeleccionado]=useState(FechadeReserva.getDay());
    const[Espacioshorarios,setEspacioshorarios]=useState(["12:00","12:15","12:30","12:45","13:00"]);
    const[horarioenfecha,sethorarioenfecha]=useState();
    const[message,setMessage]=useState("");


    var peticionHorarios = (fecha) => {
        return new Promise((resolve, reject) => {
            
               var fechar=formatDate(FechadeReserva);

            axios.post("http://localhost:8080/Afiliado/DisponibilidadRecurso", { "idRecurso":Recursoareservar.id,"fecha":fechar})
                .then((response) => {
                    // Resolvemos la promesa con los datos recibidos
                    var Listahorarios=[];
                    response.data.map((cadenaHorario)=>{
                        Listahorarios.push(cadenaHorario);
                    })
                    setEspacioshorarios(Listahorarios);
                    resolve(response.data);
                })
                .catch((error) => {
                    // Rechazamos la promesa con el mensaje de error
                    
                });
        });
      };

      var peticionReserva = () => {
        return new Promise((resolve, reject) => {
            var Horainicial;
            var HoraFinal;
            var MinutoInicial;
            var MinutoFinal;
            Horainicial=EHseleccionados.at(0).substring(0,2);
            MinutoInicial=EHseleccionados.at(0).substring(3,5);
            console.log(Horainicial+":"+MinutoInicial);
            HoraFinal=EHseleccionados.at(-1).substring(6,8);
            MinutoFinal=EHseleccionados.at(-1).substring(9,12);
            console.log(HoraFinal+":"+MinutoFinal);
        

            axios.post("http://localhost:8080/Afiliado/CrearReserva", {"horaInicial":parseInt(Horainicial),"minutoinicial":parseInt(MinutoInicial),
                "horaFinal":parseInt(HoraFinal),"minutoFinal":parseInt(MinutoFinal),"fecha":FechadeReserva,"idRecurso":Recursoareservar.id,"idUsuario":window.sessionStorage.getItem("idUsuario")
             })
                .then((response) => {
                    // Resolvemos la promesa con los datos recibidos
                    Swal.fire({title:"Reserva Creada con esito",text:"",icon:"success"});
                    window.location.reload();
                    resolve(response.data);
                })
                .catch((error) => {
                    // Rechazamos la promesa con el mensaje de error
                    window.alert("Reserva arruinada con rotundo exito");
                });
        });
      };
    useEffect(() => {
        const fetchData = async () => {
            try {
                // Esperamos la resolución de la promesa usando await
                const data = await peticionHorarios();
                // Una vez que la promesa se resuelve, actualizamos el estado con los datos recibidos
                
                
                
      
                
                
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








useEffect(()=>{
    peticionHorarios();
    setDiaSeleccionado(FechadeReserva.getDay());
    

    },[FechadeReserva]);
useEffect(()=>{

    sethorarioenfecha(getHorariodeldia());
},[diaseleccionado])

function formatDate(date) {
    const day = date.getDate().toString().padStart(2, '0');
    const month = (date.getMonth() + 1).toString().padStart(2, '0'); // Months are zero-indexed
    const year = date.getFullYear();
    return `${day}-${month}-${year}`;
}

function inicializarfecha(){
    var fechaactual=new Date();
     fechaactual.setHours(fechaactual.getHours()-5);
     return fechaactual;
}
function convertirfecha(fecha){
    var dateArray = fecha.split("-");
    var year = dateArray[0];
    var month = parseInt(dateArray[1], 10) - 1;
    var date = dateArray[2];
    return new Date(year, month, date);
}
function checkseleccion(intervalorecurso){
    var interval;
    if(intervalorecurso!=null){
        interval=intervalorecurso;
       
    }
    var anterior;
    var correcto=true;
    
    if(EHseleccionados.length===0){
        setMessage("");
        return "";
    }
    else{
        EHseleccionados.map((espacio)=>{
           var nocolonespace=espacio.replace(":","");

            
            if(anterior==null ){
                
                
            anterior=parseInt(nocolonespace.substring(2,4));
            
            
            anterior=anterior+parseInt(nocolonespace.substring(0,2))*60;
            
            }else{
                if(interval==null){
                    
                    interval=parseInt(nocolonespace.substring(2,4));
                    interval=interval+parseInt(nocolonespace.substring(0,2))*60 - anterior;
                   
                    
                    
                }else{
                    
                    var minutos=parseInt(nocolonespace.substring(2,4));
                    
                    minutos=minutos+parseInt(nocolonespace.substring(0,2))*60; 
                    console.log(minutos-anterior);
                    console.log(interval);
                    
                if((minutos-anterior)!==interval & (minutos-anterior)!==interval*-1){
                    setMessage("Debe elegir espacio en horarios consecutivos"); 
                    
                    correcto=false;
                }
                anterior=minutos;
            }
            }
        })
    }
    if(correcto==true){
        peticionReserva();
        setMessage("");
    }
        
    //Aqui se llamara a la peticion para realizar la reserva.
    
}

function getHorariodeldia(){
    switch(diaseleccionado){
        case 1:
        return " El horario del dia seleccionado va de " + Recursoareservar.horariolunesi + " a " +Recursoareservar.horariolunesf;
        break;
        case 2:
            return " El horario del dia seleccionado va de " + Recursoareservar.horariomartesi + " a " +Recursoareservar.horariomiercolesf;    
        break;
        case 3:
            return " El horario del dia seleccionado va de " + Recursoareservar.horariomiercolesi + " a " +Recursoareservar.horariomiercolesf;
        break;
        case 4:
            return " El horario del dia seleccionado va de " + Recursoareservar.horariojuevesi + " a " +Recursoareservar.horariojuevesf;
        break;
        case 5:
            return " El horario del dia seleccionado va de " + Recursoareservar.horarioviernesi + "  a " +Recursoareservar.horarioviernesf;
        break;
        case 6:
            return " El horario del dia seleccionado va de " + Recursoareservar.horariosabadoi + " a " +Recursoareservar.horariosabadof;
        break;
        default:
            return "los domingos no hay reservas";
        break;
    }
    
}



return(
    <div style={{height:'100rem', backgroundColor:'#D6F2F5'}}>
        
        <div style={{width:'45rem',paddingLeft:'4rem'}}>
        <h3 >{horarioenfecha}</h3>
       
        <Form.Group>
        <Form.Label className='center-div' >Elija la fecha en la que quiere realizar su reserva del recurso {Recursoareservar.nombre}</Form.Label>
        <Form.Control type='date' min={inicializarfecha().toISOString().slice(0,10)} value={FechadeReserva.toISOString().slice(0,10)} onChange={(element)=>{setFechadeReserva(convertirfecha(element.target.value))}}/>
        <Form.Label className='center-div' >Espacios horarios disponibles en esa fecha</Form.Label>
        
        <Card>
        <CardBody>
        <CardGroup>
        { 
            Espacioshorarios.map((espacio)=>{
            return( 
            
            <Form.Check  style={{height:'2rem'}} type="checkbox" value={espacio} label={espacio.substring(0,5)} onChange={(element)=>{
                if(element.target.checked){
                    var seleccionados=EHseleccionados.slice(0);
                    seleccionados.push(element.target.value);
                    seleccionados.sort(function(a,b){
                    a=a.replace(":","");
                    b=b.replace(":","");
                    var c =parseInt(a.substring(2,4))+parseInt(a.substring(0,2))*60;
                    console.log(c);
                    var d=parseInt(b.substring(2,4))+parseInt(b.substring(0,2))*60;
                    console.log(c-d);
                    return c-d;
                });
                console.log(seleccionados);
                
                    setEH(seleccionados);
                    
                }else{
                    
                    var index=EHseleccionados.indexOf(element.target.value);
                    var seleccionados=EHseleccionados.slice(0);
                    seleccionados.splice(index,1);
                    setEH(seleccionados);
                }
                
            }} />);
        }) }
        </CardGroup>
        </CardBody>
        </Card>
       <p>{EHseleccionados}</p>
       <p>{message}</p>
       <Form.Control as="button" style={{padding:'2px 2em',backgroundColor:'#92a8d1',width:'22rem'}} onClick={()=>{checkseleccion(Recursoareservar.intervalo)}}>Realizar reserva</Form.Control>
        </Form.Group> 
        </div>
        


    </div>



);
}
export default MenuReserva;
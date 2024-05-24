package com.feelcondorinc.integraservicios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feelcondorinc.integraservicios.repositories.UnidadRepository;
import com.POJOS.RECURSOPOJO;
import com.POJOS.UNIDADPOJO;
import com.feelcondorinc.integraservicios.entities.*;
import com.feelcondorinc.integraservicios.entities.models.EstadoRecurso;
import com.feelcondorinc.integraservicios.repositories.EmpleadosSistemaRepository;
import com.feelcondorinc.integraservicios.repositories.HorarioDisponibleRepository;
import com.feelcondorinc.integraservicios.repositories.HorarioRepository;
import com.feelcondorinc.integraservicios.repositories.RecursoRepository;
import com.feelcondorinc.integraservicios.repositories.ReservaRepository;
import com.feelcondorinc.integraservicios.repositories.UnidadRepository;
import com.feelcondorinc.integraservicios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


@Service
public class AdminService {
 @Autowired
    private UnidadRepository unidadRepository;
    @Autowired
    private HorarioRepository horarioRepository;
    @Autowired
    private HorarioDisponibleRepository horarioDisponibleRepository;
    @Autowired 
    RecursoRepository recursorepository;

    public AdminService(UnidadRepository unidadRepository, HorarioRepository horarioRepository,
            HorarioDisponibleRepository horarioDisponibleRepository,RecursoRepository recursorepository) {
        this.unidadRepository = unidadRepository;
        this.horarioRepository = horarioRepository;
        this.horarioDisponibleRepository = horarioDisponibleRepository;
        this.recursorepository = recursorepository;
    }

    public String crearUnidad(UNIDADPOJO unidad){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:MM");
        ArrayList<LocalTime> LunesH=new ArrayList();
        ArrayList<LocalTime> MartesH=new ArrayList();
        ArrayList<LocalTime> MiercolesH=new ArrayList();
        ArrayList<LocalTime> JuevesH=new ArrayList();
        ArrayList<LocalTime> ViernesH=new ArrayList();
        ArrayList<LocalTime> SabadoH=new ArrayList();
        Date today=new Date();
        Long interval=Long.valueOf(unidad.getIntervalominimo());
        HorarioDisponible conjuntohorario=new HorarioDisponible();
        conjuntohorario.setFechaInicio(today);
        conjuntohorario.setEstadoRecurso(EstadoRecurso.DISPONIBLE);
        try{
            conjuntohorario=horarioDisponibleRepository.save(conjuntohorario);
            }catch(Exception e){
              return e.getMessage();
            }
        
        if(unidad.getLunesi()!=null){
            Boolean end=false;
            LocalTime Li= LocalTime.parse(unidad.getLunesi(),formatter);
            LocalTime Lf= LocalTime.parse(unidad.getLunesf(),formatter);
            LocalTime mn=LocalTime.parse(Li.toString(),formatter);
            LunesH.add(mn);
            while(!end){
                
                LunesH.add(LunesH.get(LunesH.size()-1).plusMinutes(interval));
                end=LunesH.get(LunesH.size()-1).isAfter(Lf);
            }
            LunesH.remove(LunesH.size()-1);
            for(int i=0;i<LunesH.size()-1;i++){
                Horario horario=new Horario();
                horario.setHoraInicial(LunesH.get(i).getHour());
                horario.setMinutoInicial(LunesH.get(i).getMinute());
                horario.setHoraFinal(LunesH.get(i+1).getHour());
                horario.setMinutoFinal(LunesH.get(i+1).getMinute());
                horario.setDiaSemana("LUNES");
                try{
                    horario.setHorarioDisponible(conjuntohorario);
                    horarioRepository.save(horario);
                    }catch(Exception e){
                        return e.getMessage();
                    }
            }
        }
        if(unidad.getMartesi()!=null){
            Boolean end=false;
            LocalTime Li= LocalTime.parse(unidad.getMartesi(),formatter);
            LocalTime Lf= LocalTime.parse(unidad.getMartesf(),formatter);
            LocalTime mn=LocalTime.parse(Li.toString(),formatter);
            MartesH.add(mn);
            while(!end){
                
                MartesH.add(MartesH.get(MartesH.size()-1).plusMinutes(interval));
                
                end=MartesH.get(MartesH.size()-1).isAfter(Lf);
            }
            MartesH.remove(MartesH.size()-1);
            for(int i=0;i<MartesH.size()-1;i++){
                Horario horario=new Horario();
                horario.setHoraInicial(MartesH.get(i).getHour());
                horario.setMinutoInicial(MartesH.get(i).getMinute());
                horario.setHoraFinal(MartesH.get(i+1).getHour());
                horario.setMinutoFinal(MartesH.get(i+1).getMinute());
                horario.setDiaSemana("MARTES");
                try{
                    horario.setHorarioDisponible(conjuntohorario);
                    horarioRepository.save(horario);
                    }catch(Exception e){
                        return e.getMessage();
                    }
            }

        }

        if(unidad.getMiercolesi()!=null){
            Boolean end=false;
            LocalTime Li= LocalTime.parse(unidad.getMiercolesi(),formatter);
            LocalTime Lf= LocalTime.parse(unidad.getMiercolesf(),formatter);
            LocalTime mn=LocalTime.parse(Li.toString(),formatter);
            MiercolesH.add(mn);
            while(!end){
                
                MiercolesH.add(MiercolesH.get(MiercolesH.size()-1).plusMinutes(interval));
                
                end=MiercolesH.get(MiercolesH.size()-1).isAfter(Lf);
            }
            MiercolesH.remove(MiercolesH.size()-1);
            for(int i=0;i<MiercolesH.size()-1;i++){
                Horario horario=new Horario();
                horario.setHoraInicial(MiercolesH.get(i).getHour());
                horario.setMinutoInicial(MiercolesH.get(i).getMinute());
                horario.setHoraFinal(MiercolesH.get(i+1).getHour());
                horario.setMinutoFinal(MiercolesH.get(i+1).getMinute());
                horario.setDiaSemana("MIERCOLES");
                try{
                    horario.setHorarioDisponible(conjuntohorario);
                    horarioRepository.save(horario);
                    }catch(Exception e){
                        return e.getMessage();
                    }
            }
        }

        if(unidad.getJuevesi()!=null){
            Boolean end=false;
            LocalTime Li= LocalTime.parse(unidad.getJuevesi(),formatter);
            LocalTime Lf= LocalTime.parse(unidad.getJuevesf(),formatter);
            LocalTime mn=LocalTime.parse(Li.toString(),formatter);
            JuevesH.add(mn);
            while(!end){
                
                JuevesH.add(JuevesH.get(JuevesH.size()-1).plusMinutes(interval));
                
                end=JuevesH.get(JuevesH.size()-1).isAfter(Lf);
            }
            JuevesH.remove(JuevesH.size()-1);
            for(int i=0;i<JuevesH.size()-1;i++){
                Horario horario=new Horario();
                horario.setHoraInicial(JuevesH.get(i).getHour());
                horario.setMinutoInicial(JuevesH.get(i).getMinute());
                horario.setHoraFinal(JuevesH.get(i+1).getHour());
                horario.setMinutoFinal(JuevesH.get(i+1).getMinute());
                horario.setDiaSemana("JUEVES");
                try{
                    horario.setHorarioDisponible(conjuntohorario);
                    horarioRepository.save(horario);
                    }catch(Exception e){
                        return e.getMessage();
                    }
            }
        }

        if(unidad.getViernesi()!=null){
            Boolean end=false;
            LocalTime Li= LocalTime.parse(unidad.getViernesi(),formatter);
            LocalTime Lf= LocalTime.parse(unidad.getViernesf(),formatter);
            LocalTime mn=LocalTime.parse(Li.toString(),formatter);
            ViernesH.add(mn);
            while(!end){
                
                ViernesH.add(ViernesH.get(ViernesH.size()-1).plusMinutes(interval));
                
                end=ViernesH.get(ViernesH.size()-1).isAfter(Lf);
            }
            ViernesH.remove(ViernesH.size()-1);
            for(int i=0;i<ViernesH.size()-1;i++){
                Horario horario=new Horario();
                horario.setHoraInicial(ViernesH.get(i).getHour());
                horario.setMinutoInicial(ViernesH.get(i).getMinute());
                horario.setHoraFinal(ViernesH.get(i+1).getHour());
                horario.setMinutoFinal(ViernesH.get(i+1).getMinute());
                horario.setDiaSemana("VIERNES");
                try{
                    horario.setHorarioDisponible(conjuntohorario);
                    horarioRepository.save(horario);
                    }catch(Exception e){
                        return e.getMessage();
                    }
            }
        }

        if(unidad.getSabadoi()!=null){
            Boolean end=false;
            LocalTime Li= LocalTime.parse(unidad.getSabadoi(),formatter);
            LocalTime Lf= LocalTime.parse(unidad.getSabadof(),formatter);
            LocalTime mn=LocalTime.parse(Li.toString(),formatter);
            SabadoH.add(mn);
            while(!end){
                
                SabadoH.add(SabadoH.get(SabadoH.size()-1).plusMinutes(interval));
                
                end=SabadoH.get(SabadoH.size()-1).isAfter(Lf);
            }
            SabadoH.remove(SabadoH.size()-1);
            for(int i=0;i<SabadoH.size()-1;i++){
                Horario horario=new Horario();
                horario.setHoraInicial(SabadoH.get(i).getHour());
                horario.setMinutoInicial(SabadoH.get(i).getMinute());
                horario.setHoraFinal(SabadoH.get(i+1).getHour());
                horario.setMinutoFinal(SabadoH.get(i+1).getMinute());
                horario.setDiaSemana("SABADO");
                try{
                horario.setHorarioDisponible(conjuntohorario);
                horarioRepository.save(horario);
                }catch(Exception e){
                    return e.getMessage();
                }
            }

            Unidad nuevaunidad=new Unidad();
            nuevaunidad.setNombre(unidad.getNombre());
            nuevaunidad.setIdHorarioDisponible(conjuntohorario);
            nuevaunidad.setIntervaloMinimoPrestamo(Integer.valueOf(unidad.getIntervalominimo()));
            unidadRepository.save(nuevaunidad);
        }
        
        return null;
        
    }

    public String crearRecurso(RECURSOPOJO Recurso){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:MM");
        ArrayList<LocalTime> LunesH=new ArrayList();
        ArrayList<LocalTime> MartesH=new ArrayList();
        ArrayList<LocalTime> MiercolesH=new ArrayList();
        ArrayList<LocalTime> JuevesH=new ArrayList();
        ArrayList<LocalTime> ViernesH=new ArrayList();
        ArrayList<LocalTime> SabadoH=new ArrayList();
        Date today=new Date();
        Long interval=Long.valueOf(Recurso.getIntervalominimo());
        HorarioDisponible conjuntohorario=new HorarioDisponible();
        conjuntohorario.setFechaInicio(today);
        conjuntohorario.setEstadoRecurso(EstadoRecurso.DISPONIBLE);
        try{
            conjuntohorario=horarioDisponibleRepository.save(conjuntohorario);
            }catch(Exception e){
              return e.getMessage();
            }
        
        if(Recurso.getLunesi()!=null){
            Boolean end=false;
            LocalTime Li= LocalTime.parse(Recurso.getLunesi(),formatter);
            LocalTime Lf= LocalTime.parse(Recurso.getLunesf(),formatter);
            LocalTime mn=LocalTime.parse(Li.toString(),formatter);
            LunesH.add(mn);
            while(!end){
                
                LunesH.add(LunesH.get(LunesH.size()-1).plusMinutes(interval));
                end=LunesH.get(LunesH.size()-1).isAfter(Lf);
            }
            LunesH.remove(LunesH.size()-1);
            for(int i=0;i<LunesH.size()-1;i++){
                Horario horario=new Horario();
                horario.setHoraInicial(LunesH.get(i).getHour());
                horario.setMinutoInicial(LunesH.get(i).getMinute());
                horario.setHoraFinal(LunesH.get(i+1).getHour());
                horario.setMinutoFinal(LunesH.get(i+1).getMinute());
                horario.setDiaSemana("LUNES");
                try{
                    horario.setHorarioDisponible(conjuntohorario);
                    horarioRepository.save(horario);
                    }catch(Exception e){
                        return e.getMessage();
                    }
            }
        }
        if(Recurso.getMartesi()!=null){
            Boolean end=false;
            LocalTime Li= LocalTime.parse(Recurso.getMartesi(),formatter);
            LocalTime Lf= LocalTime.parse(Recurso.getMartesf(),formatter);
            LocalTime mn=LocalTime.parse(Li.toString(),formatter);
            MartesH.add(mn);
            while(!end){
                
                MartesH.add(MartesH.get(MartesH.size()-1).plusMinutes(interval));
                
                end=MartesH.get(MartesH.size()-1).isAfter(Lf);
            }
            MartesH.remove(MartesH.size()-1);
            for(int i=0;i<MartesH.size()-1;i++){
                Horario horario=new Horario();
                horario.setHoraInicial(MartesH.get(i).getHour());
                horario.setMinutoInicial(MartesH.get(i).getMinute());
                horario.setHoraFinal(MartesH.get(i+1).getHour());
                horario.setMinutoFinal(MartesH.get(i+1).getMinute());
                horario.setDiaSemana("MARTES");
                try{
                    horario.setHorarioDisponible(conjuntohorario);
                    horarioRepository.save(horario);
                    }catch(Exception e){
                        return e.getMessage();
                    }
            }

        }

        if(Recurso.getMiercolesi()!=null){
            Boolean end=false;
            LocalTime Li= LocalTime.parse(Recurso.getMiercolesi(),formatter);
            LocalTime Lf= LocalTime.parse(Recurso.getMiercolesf(),formatter);
            LocalTime mn=LocalTime.parse(Li.toString(),formatter);
            MiercolesH.add(mn);
            while(!end){
                
                MiercolesH.add(MiercolesH.get(MiercolesH.size()-1).plusMinutes(interval));
                
                end=MiercolesH.get(MiercolesH.size()-1).isAfter(Lf);
            }
            MiercolesH.remove(MiercolesH.size()-1);
            for(int i=0;i<MiercolesH.size()-1;i++){
                Horario horario=new Horario();
                horario.setHoraInicial(MiercolesH.get(i).getHour());
                horario.setMinutoInicial(MiercolesH.get(i).getMinute());
                horario.setHoraFinal(MiercolesH.get(i+1).getHour());
                horario.setMinutoFinal(MiercolesH.get(i+1).getMinute());
                horario.setDiaSemana("MIERCOLES");
                try{
                    horario.setHorarioDisponible(conjuntohorario);
                    horarioRepository.save(horario);
                    }catch(Exception e){
                        return e.getMessage();
                    }
            }
        }

        if(Recurso.getJuevesi()!=null){
            Boolean end=false;
            LocalTime Li= LocalTime.parse(Recurso.getJuevesi(),formatter);
            LocalTime Lf= LocalTime.parse(Recurso.getJuevesf(),formatter);
            LocalTime mn=LocalTime.parse(Li.toString(),formatter);
            JuevesH.add(mn);
            while(!end){
                
                JuevesH.add(JuevesH.get(JuevesH.size()-1).plusMinutes(interval));
                
                end=JuevesH.get(JuevesH.size()-1).isAfter(Lf);
            }
            JuevesH.remove(JuevesH.size()-1);
            for(int i=0;i<JuevesH.size()-1;i++){
                Horario horario=new Horario();
                horario.setHoraInicial(JuevesH.get(i).getHour());
                horario.setMinutoInicial(JuevesH.get(i).getMinute());
                horario.setHoraFinal(JuevesH.get(i+1).getHour());
                horario.setMinutoFinal(JuevesH.get(i+1).getMinute());
                horario.setDiaSemana("JUEVES");
                try{
                    horario.setHorarioDisponible(conjuntohorario);
                    horarioRepository.save(horario);
                    }catch(Exception e){
                        return e.getMessage();
                    }
            }
        }

        if(Recurso.getViernesi()!=null){
            Boolean end=false;
            LocalTime Li= LocalTime.parse(Recurso.getViernesi(),formatter);
            LocalTime Lf= LocalTime.parse(Recurso.getViernesf(),formatter);
            LocalTime mn=LocalTime.parse(Li.toString(),formatter);
            ViernesH.add(mn);
            while(!end){
                
                ViernesH.add(ViernesH.get(ViernesH.size()-1).plusMinutes(interval));
                
                end=ViernesH.get(ViernesH.size()-1).isAfter(Lf);
            }
            ViernesH.remove(ViernesH.size()-1);
            for(int i=0;i<ViernesH.size()-1;i++){
                Horario horario=new Horario();
                horario.setHoraInicial(ViernesH.get(i).getHour());
                horario.setMinutoInicial(ViernesH.get(i).getMinute());
                horario.setHoraFinal(ViernesH.get(i+1).getHour());
                horario.setMinutoFinal(ViernesH.get(i+1).getMinute());
                horario.setDiaSemana("VIERNES");
                try{
                    horario.setHorarioDisponible(conjuntohorario);
                    horarioRepository.save(horario);
                    }catch(Exception e){
                        return e.getMessage();
                    }
            }
        }

        if(Recurso.getSabadoi()!=null){
            Boolean end=false;
            LocalTime Li= LocalTime.parse(Recurso.getSabadoi(),formatter);
            LocalTime Lf= LocalTime.parse(Recurso.getSabadof(),formatter);
            LocalTime mn=LocalTime.parse(Li.toString(),formatter);
            SabadoH.add(mn);
            while(!end){
                
                SabadoH.add(SabadoH.get(SabadoH.size()-1).plusMinutes(interval));
                
                end=SabadoH.get(SabadoH.size()-1).isAfter(Lf);
            }
            SabadoH.remove(SabadoH.size()-1);
            for(int i=0;i<SabadoH.size()-1;i++){
                Horario horario=new Horario();
                horario.setHoraInicial(SabadoH.get(i).getHour());
                horario.setMinutoInicial(SabadoH.get(i).getMinute());
                horario.setHoraFinal(SabadoH.get(i+1).getHour());
                horario.setMinutoFinal(SabadoH.get(i+1).getMinute());
                horario.setDiaSemana("SABADO");
                try{
                horario.setHorarioDisponible(conjuntohorario);
                horarioRepository.save(horario);
                }catch(Exception e){
                    return e.getMessage();
                }
            }
            /* 
            Recurso nuevaRecurso=new Recurso();
            nuevaRecurso.setNombre(Recurso.getNombre());
            nuevaRecurso.setIdHorarioDisponible(conjuntohorario);
            nuevaRecurso.setIntervaloMinimoPrestamo(Integer.valueOf(Recurso.getIntervalominimo()));
            RecursoRepository.save(nuevaRecurso);
            */
        }
        
        return null;
        
    }

    public ArrayList<Unidad> consultarUnidades(){
      Iterator<Unidad> unidades=  unidadRepository.findAll().iterator();
      ArrayList<Unidad> listaunidades=new ArrayList<Unidad>();
      while(unidades.hasNext()){
        listaunidades.add(unidades.next());
      }
      return listaunidades;
    }


}

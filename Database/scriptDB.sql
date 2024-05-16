/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     14/05/2024 11:53:28 p. m.                    */
/*==============================================================*/

/*==============================================================*/
/* Table: CALIFICACIONES                                        */
/*==============================================================*/
create table CALIFICACIONES (
   IDCALIFICACION       NUMERIC              not null,
   IDEMPLEADO           NUMERIC              not null,
   IDRESERVA            NUMERIC              not null,
   IDUSUARIO            NUMERIC              not null,
   CUMPLIMIENTOHORARIO  NUMERIC              not null,
   CALIDADRECURSO       NUMERIC              not null,
   TRATOPERSONAL        NUMERIC              not null,
   OBSERVACIONES        VARCHAR(500)         not null,
   constraint PK_CALIFICACIONES primary key (IDCALIFICACION)
);

/*==============================================================*/
/* Index: CALIFICACIONES_PK                                     */
/*==============================================================*/
create unique index CALIFICACIONES_PK on CALIFICACIONES (
IDCALIFICACION
);

/*==============================================================*/
/* Index: CALIFICACION_EMPLEADO_FK                              */
/*==============================================================*/
create  index CALIFICACION_EMPLEADO_FK on CALIFICACIONES (
IDEMPLEADO
);

/*==============================================================*/
/* Index: RESERVA_CALIFICACION2_FK                              */
/*==============================================================*/
create  index RESERVA_CALIFICACION2_FK on CALIFICACIONES (
IDRESERVA
);

/*==============================================================*/
/* Index: USUARIO_CALIFICACION_FK                               */
/*==============================================================*/
create  index USUARIO_CALIFICACION_FK on CALIFICACIONES (
IDUSUARIO
);

/*==============================================================*/
/* Table: EMPLEADOSSISTEMA                                      */
/*==============================================================*/
create table EMPLEADOSSISTEMA (
   IDEMPLEADO           NUMERIC              not null,
   IDHORARIOSDISPONIBLES NUMERIC              not null,
   IDUNIDAD             NUMERIC              not null,
   IDUSUARIO            NUMERIC              not null,
   CORREOCORPORATIVO    VARCHAR(50)          not null,
   constraint PK_EMPLEADOSSISTEMA primary key (IDEMPLEADO)
);

/*==============================================================*/
/* Index: EMPLEADOS_PK                                          */
/*==============================================================*/
create unique index EMPLEADOS_PK on EMPLEADOSSISTEMA (
IDEMPLEADO
);

/*==============================================================*/
/* Index: EMPLEADOS_USUARIO_FK                                  */
/*==============================================================*/
create  index EMPLEADOS_USUARIO_FK on EMPLEADOSSISTEMA (
IDUSUARIO
);

/*==============================================================*/
/* Index: HORARIODISPONIBLE_EMPLEADO_FK                         */
/*==============================================================*/
create  index HORARIODISPONIBLE_EMPLEADO_FK on EMPLEADOSSISTEMA (
IDHORARIOSDISPONIBLES
);

/*==============================================================*/
/* Index: UNIDAD_EMPLEADO_FK                                    */
/*==============================================================*/
create  index UNIDAD_EMPLEADO_FK on EMPLEADOSSISTEMA (
IDUNIDAD
);

/*==============================================================*/
/* Table: HORARIOS                                              */
/*==============================================================*/
create table HORARIOS (
   IDHORARIO            NUMERIC              not null,
   IDHORARIOSDISPONIBLES NUMERIC              not null,
   HORAINICIAL          NUMERIC              not null,
   MINUTOINICIAL        NUMERIC              not null,
   HORAFINAL            NUMERIC              not null,
   MINUTOFINAL          NUMERIC              not null,
   constraint PK_HORARIOS primary key (IDHORARIO)
);

/*==============================================================*/
/* Index: HORARIOS_PK                                           */
/*==============================================================*/
create unique index HORARIOS_PK on HORARIOS (
IDHORARIO
);

/*==============================================================*/
/* Index: HORARIOS_HORARIOSDISPONIBLES_FK                       */
/*==============================================================*/
create  index HORARIOS_HORARIOSDISPONIBLES_FK on HORARIOS (
IDHORARIOSDISPONIBLES
);

/*==============================================================*/
/* Table: HORARIOSDISPONIBLES                                   */
/*==============================================================*/
create table HORARIOSDISPONIBLES (
   IDHORARIOSDISPONIBLES NUMERIC              not null,
   FECHAINICIO          DATE                 not null,
   FECHAFINAL           DATE                 not null,
   ESTADORECURSO      NUMERIC              null,
   constraint PK_HORARIOSDISPONIBLES primary key (IDHORARIOSDISPONIBLES)
);

/*==============================================================*/
/* Index: HORARIOSDISPONIBLES_PK                                */
/*==============================================================*/
create unique index HORARIOSDISPONIBLES_PK on HORARIOSDISPONIBLES (
IDHORARIOSDISPONIBLES
);

/*==============================================================*/
/* Table: RECURSOS                                              */
/*==============================================================*/
create table RECURSOS (
   IDRECURSO            NUMERIC              not null,
   IDHORARIOSDISPONIBLES NUMERIC              not null,
   IDUNIDAD             NUMERIC              not null,
   NOMBRE              VARCHAR(100)         not null,
   DESCRIPCION          VARCHAR(500)         not null,
   CANTIDADVECESPRESTADO NUMERIC              null,
   constraint PK_RECURSOS primary key (IDRECURSO)
);

/*==============================================================*/
/* Index: RECURSOS_PK                                           */
/*==============================================================*/
create unique index RECURSOS_PK on RECURSOS (
IDRECURSO
);

/*==============================================================*/
/* Index: HORARIODISPONIBLE_RECURSO_FK                          */
/*==============================================================*/
create  index HORARIODISPONIBLE_RECURSO_FK on RECURSOS (
IDHORARIOSDISPONIBLES
);

/*==============================================================*/
/* Index: UNIDAD_RECURSO_FK                                     */
/*==============================================================*/
create  index UNIDAD_RECURSO_FK on RECURSOS (
IDUNIDAD
);

/*==============================================================*/
/* Table: RESERVAS                                              */
/*==============================================================*/
create table RESERVAS (
   IDRESERVA            NUMERIC              not null,
   IDRECURSO            NUMERIC              not null,
   IDUSUARIO            NUMERIC              not null,
   FECHAINICIO          DATE                 not null,
   FECHAFINAL           DATE                 not null,
   ESTADO               NUMERIC              not null,
   OBSERVACIONES        VARCHAR(500)         not null,
   constraint PK_RESERVAS primary key (IDRESERVA)
);

/*==============================================================*/
/* Index: RESERVAS_PK                                           */
/*==============================================================*/
create unique index RESERVAS_PK on RESERVAS (
IDRESERVA
);

/*==============================================================*/
/* Index: RESERVA_RECURSO_FK                                    */
/*==============================================================*/
create  index RESERVA_RECURSO_FK on RESERVAS (
IDRECURSO
);

/*==============================================================*/
/* Index: USUARIO_RESERVA_FK                                    */
/*==============================================================*/
create  index USUARIO_RESERVA_FK on RESERVAS (
IDUSUARIO
);

/*==============================================================*/
/* Table: UNIDADES                                              */
/*==============================================================*/
create table UNIDADES (
   IDUNIDAD             NUMERIC              not null,
   IDHORARIOSDISPONIBLES NUMERIC              not null,
   NOMBRE              VARCHAR(100)         not null,
   INTERVALOMINIMO      NUMERIC              not null,
   constraint PK_UNIDADES primary key (IDUNIDAD)
);

/*==============================================================*/
/* Index: UNIDAD_PK                                             */
/*==============================================================*/
create unique index UNIDAD_PK on UNIDADES (
IDUNIDAD
);

/*==============================================================*/
/* Index: HORARIODISPONIBLE_UNIDAD2_FK                          */
/*==============================================================*/
create  index HORARIODISPONIBLE_UNIDAD2_FK on UNIDADES (
IDHORARIOSDISPONIBLES
);

/*==============================================================*/
/* Table: USUARIOS                                              */
/*==============================================================*/
create table USUARIOS (
   IDUSUARIO            NUMERIC              not null,
   CONTRASENIA          VARCHAR(20)          not null,
   ROLUSUARIO           NUMERIC              not null,
   NOMBRES              VARCHAR(100)         not null,
   APELLIDOS            VARCHAR(100)         not null,
   NUMIDENTIFICACION    VARCHAR(20)          not null,
   NUMCONTACTO          VARCHAR(20)          null,
   constraint PK_USUARIOS primary key (IDUSUARIO)
);

/*==============================================================*/
/* Index: USUARIOS_PK                                           */
/*==============================================================*/
create unique index USUARIOS_PK on USUARIOS (
IDUSUARIO
);

alter table CALIFICACIONES
   add constraint FK_CALIFICA_CALIFICAC_EMPLEADO foreign key (IDEMPLEADO)
      references EMPLEADOSSISTEMA (IDEMPLEADO)
      on delete restrict on update restrict;

alter table CALIFICACIONES
   add constraint FK_CALIFICA_RESERVA_C_RESERVAS foreign key (IDRESERVA)
      references RESERVAS (IDRESERVA)
      on delete restrict on update restrict;

alter table CALIFICACIONES
   add constraint FK_CALIFICA_USUARIO_C_USUARIOS foreign key (IDUSUARIO)
      references USUARIOS (IDUSUARIO)
      on delete restrict on update restrict;

alter table EMPLEADOSSISTEMA
   add constraint FK_EMPLEADO_EMPLEADOS_USUARIOS foreign key (IDUSUARIO)
      references USUARIOS (IDUSUARIO)
      on delete restrict on update restrict;

alter table EMPLEADOSSISTEMA
   add constraint FK_EMPLEADO_HORARIODI_HORARIOS foreign key (IDHORARIOSDISPONIBLES)
      references HORARIOSDISPONIBLES (IDHORARIOSDISPONIBLES)
      on delete restrict on update restrict;

alter table EMPLEADOSSISTEMA
   add constraint FK_EMPLEADO_UNIDAD_EM_UNIDADES foreign key (IDUNIDAD)
      references UNIDADES (IDUNIDAD)
      on delete restrict on update restrict;

alter table HORARIOS
   add constraint FK_HORARIOS_HORARIOS__HORARIOS foreign key (IDHORARIOSDISPONIBLES)
      references HORARIOSDISPONIBLES (IDHORARIOSDISPONIBLES)
      on delete restrict on update restrict;

alter table RECURSOS
   add constraint FK_RECURSOS_HORARIODI_HORARIOS foreign key (IDHORARIOSDISPONIBLES)
      references HORARIOSDISPONIBLES (IDHORARIOSDISPONIBLES)
      on delete restrict on update restrict;

alter table RECURSOS
   add constraint FK_RECURSOS_UNIDAD_RE_UNIDADES foreign key (IDUNIDAD)
      references UNIDADES (IDUNIDAD)
      on delete restrict on update restrict;

alter table RESERVAS
   add constraint FK_RESERVAS_RESERVA_R_RECURSOS foreign key (IDRECURSO)
      references RECURSOS (IDRECURSO)
      on delete restrict on update restrict;

alter table RESERVAS
   add constraint FK_RESERVAS_USUARIO_R_USUARIOS foreign key (IDUSUARIO)
      references USUARIOS (IDUSUARIO)
      on delete restrict on update restrict;

alter table UNIDADES
   add constraint FK_UNIDADES_HORARIODI_HORARIOS foreign key (IDHORARIOSDISPONIBLES)
      references HORARIOSDISPONIBLES (IDHORARIOSDISPONIBLES)
      on delete restrict on update restrict;


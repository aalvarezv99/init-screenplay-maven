#language: es

Característica: Flujo completo de nominaciones

  Antecedentes:
    Cuando se asigna el cliente
    Y se crean localmente los usuarios del sistema
    Y se digitan las credenciales del usuario requerido ROSCOGAS

  @consultaNominacion
  Esquema del escenario: El usuario ingresa, consulta y exporta la nominacion
    Cuando el usuario ingresa al menu <menu> submenu <submenu> item <item>
    Y se selecciona <sistema> y <estado> para filtrar <tipoBusqueda>
    Entonces se da click al check para seleccionar todo y se exporta
    Ejemplos:
      | menu                    | submenu    | item                    | sistema | estado | tipoBusqueda                 |
      | Pedidos y planificación | Nominación | Nominación de Refinados | TODOS   | TODOS  | Solicitudes mes actual (n-1) |

  @crearNominacionCliente
  Esquema del escenario: El cliente ingresa y crea la nominacion
    Cuando el usuario ingresa al menu <menu> submenu <submenu> item <item>
    Y carga el documento de nominacion <rutaDoc> con el mensaje esperado <mensaje>
    Ejemplos:
      | rutaDoc                                                    | mensaje        | menu                    | submenu    | item                          |
      | src/test/resources/data/nominaciones/cliente/ROSCOGAS.xlsx | Cargue exitoso | Pedidos y planificación | Nominación | Cargue Masivo de Nominaciones |

  @cargarAsignacionPlaneador
  Esquema del escenario: : El planeador ingresa y carga la asignacion
    Cuando el usuario ingresa al menu <menu> submenu <submenu> item <item>
    Y carga el documento de nominacion <rutaDoc> con el mensaje esperado <mensaje>
    Ejemplos:
      | rutaDoc                                                        | mensaje        | menu                    | submenu    | item                    |
      | src/test/resources/data/nominaciones/planeador/asignacion.xlsx | Cargue exitoso | Pedidos y planificación | Nominación | Nominación de Refinados |
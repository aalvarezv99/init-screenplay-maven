#language: es

Característica: Flujo completo de nominaciones

  Antecedentes:
    Cuando se asigna el cliente
    Y se digitan las credenciales del usuario userPRX-25 y contrasena PrxPruebas132* requeridos

  @consultaNominacion
  Esquema del escenario: El usuario ingresa, consulta y exporta la nominacion
    Cuando el usuario ingresa al menu <menu> submenu <submenu> item <item>
    Y se selecciona <sistema> y <estado> para filtrar <tipoBusqueda>
    Entonces se da click al check para seleccionar todo y se exporta

    Ejemplos:
      | menu                    | submenu    | item                    | sistema | estado | tipoBusqueda                 |
      | Pedidos y planificación | Nominación | Nominación de Refinados | TODOS   | TODOS  | Solicitudes mes actual (n-1) |

  @cargarNominacion
  Esquema del escenario: El cliente ingresa y crea la nominacion
    Cuando el usuario ingresa al menu <menu> submenu <submenu> item <item>
    Y carga el documento de nominacion <rutaDoc> con el mensaje esperado <mensaje>

    Ejemplos:
      | rutaDoc                                                  | mensaje        | menu                    | submenu    | item                          |
      | src/test/resources/data/nominaciones/cliente/PRIMAX.xlsx | Cargue exitoso | Pedidos y planificación | Nominación | Cargue Masivo de Nominaciones |

  @cargarAsignacion
  Esquema del escenario: El planeador ingresa y carga la asignacion
    Cuando el usuario ingresa al menu <menu> submenu <submenu> item <item>
    Y carga el documento de nominacion <rutaDoc> con el mensaje esperado <mensaje>

    Ejemplos:
      | rutaDoc                                                        | mensaje        | menu                    | submenu    | item                    |
      | src/test/resources/data/nominaciones/planeador/asignacion.xlsx | Cargue exitoso | Pedidos y planificación | Nominación | Nominación de Refinados |

  @cambiarEstadoNominacion
  Esquema del escenario: Cambiar estado de nominacion al estado requerido
    Cuando el usuario ingresa al menu <menu> submenu <submenu> item <item>
    Y se selecciona <sistema> y <estado> para filtrar <tipoBusqueda>
    Y selecciona el <numPedido> cambia el estado a <cambiarEstado> y lo guarda

    Ejemplos:
      | menu                    | submenu    | item                    | sistema | estado | tipoBusqueda                 | numPedido            | cambiarEstado |
      | Pedidos y planificación | Nominación | Nominación de Refinados | TODOS   | TODOS  | Solicitudes mes actual (n-1) | 10110093060910280522 | PENDIENTE     |

  @editarNominacion
  Esquema del escenario: Editar cantidad y producto de la nominacion
    Cuando el usuario ingresa al menu <menu> submenu <submenu> item <item>
    Y se selecciona <sistema> y <estado> para filtrar <tipoBusqueda>
    Entonces selecciona el <pedido> para editar el <producto> y las cantidades
      | solicitado |
      | 3009,00    |

    Ejemplos:
      | menu                    | submenu    | item                    | sistema | estado | tipoBusqueda                 | pedido               | producto                       |
      | Pedidos y planificación | Nominación | Nominación de Refinados | TODOS   | TODOS  | Solicitudes mes actual (n-1) | 10110103060910280522 | GLP - GAS LICUADO DEL PETROLEO |
#      | Pedidos y planificación | Nominación | Nominación de Refinados | TODOS   | TODOS  | Solicitudes mes a nominar (n) | 10110103060910280522 | GLP - GAS LICUADO DEL PETROLEO |
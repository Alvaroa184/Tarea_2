# Sistema de reuniones en POO

Alvaro Alonso Anabalon Salgado
Rodrigo Nicolas Dominguez Larenas
Felipe Alexis Sepulveda Vasquez


## Cambios realizados a comparación del UML original:

Para empezar se realizó la agregación de la clase Invitado_Externo para poder permitir invitar personas que sean externas a la empresa ya que en el UML original solo se consideraba a los empleados, esta clase tiene menos información que un empleado y solo basta el nombre y el correo para poder ser invitado, como toda clase que pueda estar invitada se le implementó la interfaz Invitable.

Se añadió la clase Retraso para poder tener una mejor forma de almacenar la información sobre los participantes que llegan tarde, hereda Asistencia porque retraso sigue siendo un tipo de asistencia, así reutilizamos su comportamiento pero con la diferencia que esta tiene el tiempo sobre el atraso.

Gracias al uso de la interfaz Invitable podemos centralizar comportamiento de los elementos que pueden ser invitados a una reunión, haciendo que Departamento, Empleado e Invitado_Externo se comporten de la misma manera en el sistema de reuniones reduciendo código y simplificando la lógica de invitaciones.

Las ausencias se calculan dentro de la reunión comparando la lista de invitados con las asistencias para poder registrar de manera automática quién ha faltado.

Aunque no se presente en el UML se agregaron excepciones para errores que sentimos que podrían ser los más frecuentes para nuestro sistema de reuniones, estos son:

-asistencia duplicada
-datos inválidos
-duración inválida
-invitaciones duplicadas
-invitados que no fueron invitados
-reuniones que no finalizaron
-reuniones que no iniciaron
-reuniones que ya finalizaron
-reuniones que ya empezaron
-reuniones sin invitados

La función de generar informes y gran parte de la lógica se centró en la clase Reunion ya que esta representa casi por completo el principal problema del sistema y contiene toda la información necesaria sobre una reunión como invitaciones, asistencias, retrasos, etc.

Al poder manejar todas las funciones en esta clase podemos mantener todo el control de la reunión en un solo lugar y evitar tener lógica innecesaria entre múltiples clases reduciendo la posibilidad de errores de manejo o datos.

Además como ReunionVirtual y ReunionPresencial heredan Reunion ambas reutilizan esta lógica permitiendo que solo cambien los atributos específicos de estas clases como el enlace o la sala.
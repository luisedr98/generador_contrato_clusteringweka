Para el correcto funcionamiento del “Generador” se debe considerar lo siguiente: 

• Es necesario que las clases que ejecuten sentencias SQL del proyecto, al que se van a generar 
  los casos de prueba, se encuentren en una carpeta llamada funciones en “../src/java”
• Cada clase que contiene sentencias SQL debe empezar con la letra F y luego tener el 
  nombre de la tabla de la base de datos a la que hace referencia. (Ejemplo: FPersona) 
• Se recomienda que cada tabla de la base de datos también posea su correspondiente equivalente 
  como una clase entidad en el proyecto al que se le van a generar los casos de prueba, para evitar 
  cualquier inconveniente, esta puede ubicarse en cualquier parte.


Nota: En caso de que el proyecto al que se le van a generar los casos de prueba se encuentre estructurado 
diferente, es posible modificar el código fuente del generador para cambiar la ruta donde se encuentran los 
casos de prueba, para ello se puede abrir el archivo “PRINCIPAL.java” que se encuentra en la carpeta “../src/generador/” 
del “Generador” y ubicarse en la línea 192 y 193. Se necesita conocimiento básico en JAVA para realizar esta acción.   

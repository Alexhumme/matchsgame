# Reglas del Juego

## Creación de la cuadrícula:
- Generar una cuadrícula de tamaño configurable (por ejemplo, 4x4, 6x6).
- Cada celda de la cuadrícula contiene un "cuadro" que puede ser volteado para revelar su contenido.

## Contenido de las celdas:
- Cada cuadro tiene un contenido oculto (por ejemplo, una imagen o un número).
- Hay pares de cuadros con el mismo contenido en la cuadrícula.

## Volteo de cuadros:
- Al hacer clic en un cuadro, este se voltea y revela su contenido.
- Solo se pueden voltear dos cuadros al mismo tiempo.

## Reglas de los pares:
- Si los dos cuadros volteados tienen el mismo contenido, forman un "match" y quedan descubiertos.
- Si no coinciden, ambos cuadros se voltean nuevamente tras un breve retraso (1-2 segundos).

## Condición de victoria:
- El juego termina cuando todos los pares han sido descubiertos.

## Condición de derrota (límite de tiempo):
- El jugador debe encontrar todos los pares dentro de un tiempo límite configurable (por ejemplo, 2 minutos).
- Si el tiempo se acaba sin que todos los pares hayan sido encontrados, el juego termina en derrota.

## Contador de tiempo:
- Mostrar un temporizador visible para el jugador que muestre el tiempo restante.
- El temporizador debe empezar en cuanto el jugador voltea el primer cuadro.

## Sistema de puntuación (opcional):
- Asignar puntos por cada par encontrado.
- Restar puntos o dar penalizaciones por intentos fallidos.
- Registrar el tiempo tomado para completar el juego.

# Funcionalidades Técnicas

## Interfaz gráfica (Swing):
- Crear la ventana principal del juego usando `JFrame`.
- Utilizar un `JPanel` para la cuadrícula de cuadros.
- Crear cuadros con botones (`JButton`), que al hacer clic cambien de estado (volteado/no volteado).

## Asignación de pares:
- Generar aleatoriamente la posición de los pares en la cuadrícula.
- Asegurar que siempre haya un número par de cuadros para que todos los cuadros puedan formar un par.

## Control de eventos (click en los cuadros):
- Implementar listeners de eventos de clic para cada cuadro.
- Deshabilitar los cuadros ya emparejados para que no se puedan voltear de nuevo.

## Retorno automático:
- Si los cuadros no coinciden, estos deben volver a su estado original (oculto) después de un pequeño retraso.

## Temporizador:
- Usar un `javax.swing.Timer` para controlar el límite de tiempo y la cuenta regresiva visible.
- El temporizador debe parar cuando todos los pares han sido encontrados o cuando el tiempo se agota.

## Reinicio del juego:
- Agregar un botón para reiniciar la partida, barajando nuevamente los cuadros y restableciendo el temporizador.

# Extras

## Pantalla de inicio (opcional):
- Crear una pantalla inicial con un botón para empezar el juego y seleccionar el tamaño de la cuadrícula o el tiempo límite.

## Sonidos y efectos (opcional):
- Agregar sonidos para cuando los cuadros coinciden o no coinciden.

## Persistencia de resultados (opcional):
- Guardar los mejores tiempos o las puntuaciones más altas en un archivo o base de datos.

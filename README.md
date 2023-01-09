# Desafío: Periodos perdidos

Se debe tener el Generador De Datos o GDD
Una versión del GDD se encuentra en este repositorio en GitHub:
https://github.com/lmptechconsult/Generador_Datos_Desafio_Uno


Ejemplo de salida del GDD
```json
{
    "id": 6,
    "fechaCreacion": "1968-08-01",
    "fechaFin": "1971-06-01",
    "fechas": [
      "1969-03-01",
      "1969-05-01",
      "1969-09-01",
      "1971-05-01"]
}
```

# Detalle de los sistemas
Python 3.9

# Ejecutar el proyecto
Para ejecutar el proyecto, se necesita Python instalado. Ingresar al directorio donde se descargo el archivo main.py y ejecutar el siguiente comando *Python*

```bash
python main.py
```

Como resultado, entregara un respuesta en formato JSON con las fechas recibidas y las fechas faltantes, en la consola de comandos.
Ejemplo de la respuesta que entregara:

```json
{
    "id": 6,
    "fechaCreacion": "1969-03-01",
    "fechaFin": "1970-01-01",
    "fechas": [
      "1969-03-01",
      "1969-05-01",
      "1969-09-01",
      "1970-01-01"],
    "fechasFaltantes": [
      "1969-04-01",
      "1969-06-01",
      "1969-07-01",
      "1969-08-01",
      "1969-10-01",
      "1969-11-01",
      "1969-12-01"]

}

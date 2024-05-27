# Conversor de Monedas

Este proyecto es una aplicación de conversión de monedas que utiliza la API de ExchangeRate-API para obtener las tasas de conversión entre diferentes monedas. El proyecto incluye dos maneras distintas de realizar la conversión.

## Descripción

### Dependencias

Este proyecto utiliza las siguientes bibliotecas:

`Gson`: Para parsear JSON.
`HttpClient`: Para realizar solicitudes HTTP.

### Manera 1: `ConversionMoneda`

La clase `ConversionMoneda` realiza solicitudes HTTP a la API de ExchangeRate-API para convertir una cantidad de dinero de una moneda a otra.

#### Uso

##### ExchangerateApi

La clase `ExchangerateApi` representa la respuesta JSON de la API de ExchangeRate-API. Los campos incluyen:

- `result`: El resultado de la solicitud.
- `time_last_update_unix`: El tiempo de la última actualización en formato Unix.
- `time_last_update_utc`: El tiempo de la última actualización en formato UTC.
- `time_next_update_unix`: El tiempo de la próxima actualización en formato Unix.
- `time_next_update_utc`: El tiempo de la próxima actualización en formato UTC.
- `base_code`: El código de la moneda base.
- `target_code`: El código de la moneda objetivo.
- `conversion_rate`: La tasa de conversión entre las dos monedas.
- `conversion_result`: El resultado de la conversión.

##### Método `tasaConversion`

```java
public void tasaConversion(String valorBase, String valorSalida, double cantidad)

public class Main {
    public static void main(String[] args) {
        ConversionMoneda conversor = new ConversionMoneda();
        conversor.tasaConversion("USD", "EUR", 100);
    }
}
```

### Manera 2: `TasaCambio`

La clase `TasaCambio` realiza solicitudes HTTP a la API de ExchangeRate-API para obtener las tasas de cambio de una moneda específica y permite convertir una cantidad de dinero de una moneda a otra utilizando las tasas obtenidas.

#### Uso

##### ExchangeRateResponse

La clase `ExchangeRateResponse` representa la respuesta JSON de la API de ExchangeRate-API. Los campos incluyen:

- `result`: El resultado de la solicitud.
- `documentation`: Enlace a la documentación de la API.
- `termsOfUse`: Los términos de uso de la API.
- `time_last_update_unix`: El tiempo de la última actualización en formato Unix.
- `time_last_update_utc`: El tiempo de la última actualización en formato UTC.
- `time_next_update_unix`: El tiempo de la próxima actualización en formato Unix.
- `time_next_update_utc`: El tiempo de la próxima actualización en formato UTC.
- `base_code`: El código de la moneda base.
- `conversion_rates`: Un mapa de tasas de conversión para diferentes monedas.

##### Método `consultaTasas`

```java
public void consultaTasas(String moneda)
```

Este método obtiene las tasas de cambio actuales para una moneda específica.

`convertir`

```java
  public String convertir(String monedaBase, String monedaSalida, double monto)
```

Este método convierte una cantidad de una moneda a otra utilizando las tasas obtenidas por consultaTasas.

### Ejemplo de uso

```java

public class Main {
    public static void main(String[] args) {
        TasaCambio tasaCambio = new TasaCambio();
        tasaCambio.consultaTasas("USD");
        String resultado = tasaCambio.convertir("USD", "EUR", 100);
        System.out.println(resultado);
    }
}
```

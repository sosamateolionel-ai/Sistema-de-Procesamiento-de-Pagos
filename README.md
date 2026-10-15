# Sistema de Procesamiento de Pagos

## Descripción

Este proyecto consiste en un sistema de procesamiento de pagos desarrollado en Java. Permite realizar compras utilizando distintos medios de pago: tarjeta de crédito, criptomoneda y billetera virtual.

El objetivo principal es aplicar **interfaces, polimorfismo, abstracción y desacoplamiento**, permitiendo cambiar el proveedor de pago sin modificar la lógica del módulo de compras.

## Funcionamiento

El sistema utiliza la interfaz `ProcesadorPago` como contrato común para los distintos medios de pago.

### Interfaz `ProcesadorPago`

Define el método `procesarPago(double monto)`, que devuelve `true` si el pago se aprueba y `false` si se rechaza.

### Clase `PagoTarjetaCredito`

Representa un pago con tarjeta de crédito.

* Almacena el nombre del titular y el límite de crédito disponible.
* Rechaza montos menores o iguales a cero.
* Rechaza pagos que superen el límite disponible.
* Descuenta el monto cuando el pago se aprueba.

### Clase `PagoCriptomoneda`

Representa un pago mediante criptomonedas.

* Almacena la dirección de la billetera y su saldo disponible.
* Aplica una comisión de red del 2 %.
* Verifica que el saldo alcance para cubrir el monto y la comisión.
* Descuenta el total cuando la transacción se confirma.

### Clase `PagoBilleteraVirtual`

Representa un pago mediante una billetera virtual.

* Almacena el nombre de usuario y el saldo disponible.
* Establece un límite de $50.000 por operación.
* Rechaza montos inválidos, operaciones que superen el límite y pagos sin saldo suficiente.
* Descuenta el monto cuando el pago se aprueba.

### Clase `ModuloCompras`

Administra las compras y utiliza una referencia a la interfaz `ProcesadorPago`, en lugar de depender de una implementación concreta.

Sus métodos principales son:

* `realizarCompra(String producto, double monto)`: procesa el pago e informa si la compra fue aprobada o rechazada.
* `setProcesador(ProcesadorPago procesador)`: permite cambiar el medio de pago durante la ejecución.

### Clase `Main`

Contiene el método principal del programa. Crea los distintos medios de pago, realiza compras de prueba y cambia el proveedor de pago dinámicamente.

## Ejemplo de funcionamiento

El programa realiza las siguientes operaciones:

1. **Tarjeta de crédito:** aprueba la compra de una notebook por $80.000 y rechaza un monitor por $30.000 porque el límite restante es de $20.000.
2. **Criptomoneda:** aprueba un teclado por $100, descontando $102 con la comisión. Luego rechaza una silla gamer por $490, porque el total con comisión supera el saldo restante.
3. **Billetera virtual:** aprueba unos auriculares por $15.000 y rechaza una tablet por $60.000, porque supera el límite por operación.

En cada caso, el sistema muestra el resultado del pago y el estado de la compra.

## Conceptos de programación utilizados

* **Interfaces:** definen un contrato común para los medios de pago.
* **Implementación:** las clases concretas implementan `ProcesadorPago`.
* **Abstracción:** el módulo de compras trabaja con la interfaz, sin depender de una clase específica.
* **Polimorfismo:** el mismo método `procesarPago()` tiene diferentes comportamientos según el medio de pago utilizado.
* **Desacoplamiento:** permite incorporar otros proveedores sin modificar la lógica principal de las compras.
* **Encapsulamiento:** los atributos de las clases de pago son privados.
* **Sobrescritura de métodos:** se utiliza `@Override` para implementar el método definido en la interfaz.
* **Constantes:** se utiliza `static final` para establecer la comisión y el límite por operación.
* **Validaciones:** se comprueban montos, límites y saldos antes de aprobar cada pago.

## Tecnologías utilizadas

* Java.
* Programación Orientada a Objetos (POO).
* IntelliJ IDEA como entorno de desarrollo.

## Ejecución

<img width="1080" height="796" alt="image" src="https://github.com/user-attachments/assets/ab927eb3-e033-4804-b973-ba7878dc729e" />

## Conclusión

Este ejercicio demuestra cómo diseñar un sistema flexible mediante interfaces y polimorfismo. Gracias al desacoplamiento, el módulo de compras puede trabajar con distintos medios de pago y cambiar entre ellos durante la ejecución sin modificar su lógica interna.

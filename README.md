# SW-Banco

Servicio Web de un banco (Banco 1) que realiza cobros y reembolsos a sus clientes. Estos clientes tienen un número de tarjeta que consta de 16 dígitos, las cuales van desde **1, 000, 000, 000, 000, 000** hasta **3, 249, 999, 999, 999, 999**. 

#### Dirección del servicio web: http://3.90.21.24:3132/banco.wsdl

## Operaciones del banco :bank:

- Cobrar 

- Reembolso 


### Cobrar :money_with_wings:

|Atributo  | Tipo    |
|:--------:|:-------:|
|tarjeta   |String   |
|monto     |int      |
|pin       |int      |

### Reembolso :credit_card:

|Atributo | Tipo   |
|:-------:|:------:|
|tarjeta  | String |

## Mensajes :envelope:

### Cobrar:

Como entrada, se pide ingresar un número de tarjeta **(tarjeta)** que en este caso, debe ser de 16 dígitos en el rango que se indica al principio de este README. De igual manera se necesita saber el monto **(monto)** por el cuál se realizará el cobro y el código de seguridad **(pin)** para realizar la transacción de manera satisfactoria. Si los campos fueron llenados correctamente, manda el mensaje: **Se ha realizado el cobro a la tarjeta XXXX por la cantidad de: $XXXX.XX**.

### Reembolso

Como entrada se pide que se ingrese un numero de tarjeta **(tarjeta)**, si la tarjeta que se introdujo pertenece al banco mandará el mensaje: **Se ha realizado un reembolso a la tarjeta con terminacion: XXXX-XXXX-XXXX-XXXX**.

# JavaExercise
Para ejecutar el programa se introduce como parametro el path donde se encuentra el csv con la informacion histórica de las acciones.

Se ha tenido  en cuenta que:
- El trabajador cobra siempre el último jueves del mes, sea festivo o laborable.
- Se cogerá como precio de venta el precio de cierre del último día del archivo csv de datos.


Se han realizado los siguientes tests de integración:
1 - Normal pero recortado.

2 - Último jueves del mes es festivo.
	Se tendrá en cuenta que se ha cobrado ese mismo jueves aunque sea festivo y se cogerá el día siguiente que no sea festivo.

3 - Siguiente día despues de cobrar es festivo.
	Se cogerá el siguiente dia que no sea festivo.

4 - Siguiente día despues de cobrar es del mes siguiente.
	Se cogerá ese dia del siguiente mes. Por tanto, ese mes podrá tener 2 dias de compra de acciones.

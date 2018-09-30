# JavaExercise



*Condiciones especiales
- Se cogerá como precio de venta el último día del archivo csv de datos.
- Se tendrá en cuenta que el trabajador cobra siempre el último jueves del mes, sea festivo o laborable.



En carpeta UC_tests, se encuentran diferentes test funcionales:

1 - Normal

2 - Último jueves del mes es festivo.
		Se tendrá en cuenta que se ha cobrado ese mismo jueves aunque sea festivo y se cogerá el día siguiente que no sea festivo.

3 - Siguiente día despues de cobrar es festivo.
		Se cogerá el siguiente dia que no sea festivo.

4 - Siguiente día despues de cobrar es del mes siguiente.
		Se cogerá ese dia del siguiente mes. Por tanto, ese mes podrá tener 2 dias de compra de acciones.
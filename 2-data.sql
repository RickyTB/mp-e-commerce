INSERT INTO category(created, name, description)
	VALUES (CURRENT_TIMESTAMP, 'Cardio', 'Bicicletas, corredoras, etc.'),
	(CURRENT_TIMESTAMP, 'Fuerza', 'Máquinas de pesas'),
	(CURRENT_TIMESTAMP, 'Piso', 'Alfombras, protección, etc.'),
	(CURRENT_TIMESTAMP, 'Accesorios', 'Bandas, pelotas, cadenas.');
INSERT INTO product(
	created, name, description, status, price, quantity, sales_counter, category_id)
	VALUES (CURRENT_TIMESTAMP, 'Máquina de correr', 'Área de la correa para correr: 40 * 102 cm
Ancho de la cinta de correr: cinta de correr ultra ancha de 56 cm
Tamaño 147 * 106 * 72 cm
Tamaño plegable: 68 * 54 * 144 cm
Potencia máxima: 1,5 CV:
Tamaño del embalaje: 141 * 76,5 * 25,4 cm
Carga máxima: 120 kg
Rango de velocidad: 1.0-12.8km / h
Modos múltiples: 12 modos de fitness integrados y altavoces Bluetooth
Material de la tabla de correr: tabla de correr suave de amortiguación de alta densidad EVA
Peso bruto: 45 kg', 'IN_STOCK', 500.00, 10, 0, 1),
(CURRENT_TIMESTAMP, 'Bicicleta Estática Eventop', 'Bicicleta Eventop Multifunsión 5 En 1', 'IN_STOCK', 400.00,14, 0, 1),
(CURRENT_TIMESTAMP, 'Bicicleta de equilibrio GTI', 'Modelo:RIDER X-6
Marca: GTI
Aro: 12"
Color: Plata,Morado
Mangos protectores: Caucho resistente
Llantas: Goma aire
Cuadro: De acero
Tipo de bicicleta: Equilibrio
Modelo: Unisex
Asiento: regulable','SOLD_OUT', 26.99, 0, 1, 1),
(CURRENT_TIMESTAMP, 'Barra Recta','Modelo: Fitness
Medida: 152cm
Color: Cromada
Incluye: 2 tuercas
Diametro: 33mm
Tipo: Barra de acero solido' , 'IN_STOCK',27.99, 20, 10, 4 ),
(CURRENT_TIMESTAMP, 'Pesa de Disco', 'Discos extra para mancuernas de barra de acero con un peso de 10 Kg, ideal para ejercitarse en casa y mantenerse en salud y en forma.
Especificaciones: 
	Pesa: tipo disco
	Peso: 20Kg',
'IN_STOCK', 44.99, 13, 0, 2),
(CURRENT_TIMESTAMP, 'Colchoneta Century Sport', 'Marca: Century Sport
Color: Verde
Diseño: Labrado en la parte superior
Material: Espuma NBR
Contiene: Correa para llevarla a cualquier sitio
Dimensión: 183 x 61 x 1.5 cm
Diseñado para: Pilates, Fitness, Abdominales
Espesor: 1.5 cm
Incluye: Colchoneta y sujetadores', 
'SOLD_OUT', 199.99, 10, 0, 3),
(CURRENT_TIMESTAMP, 'Saco de Boxeo', 'Modelo: SC-87028
Color: Saco de box negro con rojo
Diseño: Compacto
Material: Cuero sintético, Hecho de tela oxford de alta calidad
Arnes: Si
Dimensión del saco: 100 x 30 x 30 cm
Resistente: Si
Funciones: Especialmente diseñado para desarrollar la técnica de mano y pie
	La forma Natural se ajusta a la mano
Incluye: Saco de box
	(No incluye guantes)',
'IN_STOCK', 42.99, 4, 0, 2),
(CURRENT_TIMESTAMP, 'Banco Step para Aerobicos', 'Material:Plástico estable
Capacidad de peso: Hasta 200 Libras
Color: Según disponibilidad
Posiciones: Altura regulable en 2 posiciones
Material Superficie: Revestimiento de goma antideslizante en la superficie de step
Ideal: Hogar, Gimnasios, Academias de baile, etc. 
Otras funciones: Apoyo seguro
		Manejo fácil
		Montaje y desmontaje fácil
		Ahorra espacio y se guarda rápidamente
		Refuerza el sistema de circulación del corazón
		Mejora la condición física, la movilidad, la eliminación de grasas y el desarrollo de la musculatura',
'IN_STOCK', 22.99, 10, 0, 4),
(CURRENT_TIMESTAMP, 'Pesas Mancuernas de Barra 25KG', 'Modelo: SY003-SC-8002325KG
Marca: Proel
Peso Máximo: 25kg / 55lb
Labrado en las mancuernas: Si ( para mejor agarre)
Roscas: 4 Roscas de ajuste cromado
Material: Hierro fundido
Incluye: 4 Discos de 2.5 kilos, 8 Discos de 1.25 kilos, 4 Discos de 0.5 kilos
	2 Mancuernas cromadas
Peso de mancuerna: Cada mancuerna tiene un peso total de 1.5 kilos',
'SOLD_OUT', 69.99, 0, 0, 2),
(CURRENT_TIMESTAMP, 'Pesas para Tobillo', 'Modelo: SC-87192-2
Marca: Proel
Correa: Seguros adhesivos en velcro
Peso Total: 2 kg - 4.4 libras
Tonifica: Ejercita los músculos de brazos y pierna
Uso: Quema calorías mientras haces tus actividades diarias. Entrena desde casa
Material: Funda resistente de nailon
Incluye: 2 piezas - 1kg cada una', 'IN_STOCK', 12.00, 5, 2, 2),
(CURRENT_TIMESTAMP, 'Ligas de Resistencia', 'Modelo: LS006
Cuerdas: Diferentes colores para diferencias la tensión de cada una
Material: Látex
Durabilidad: Durable, fácil de usar, herramienta de fitness
Uso: Usa cuerda elástica para entrenar tus músculos, de modo que los músculos estén siempre en un estado de tensión, la mejor opción para adelgazar y estar en forma
Incluye: 5 x cuerda de resistencia de 10, 20, 30, 40, 50 Libras respectivamente
 	2 x anillo de pie, 2 x mango
	1 x hebilla de puerta
	1 x bolsa de almacenamiento',
'IN_STOCK', 19.99, 3, 0, 4),
(CURRENT_TIMESTAMP, 'Casco de niña/o GTI MV15', 'Modelo: MV15
Marca: GTI:Talla M
Color: Concho de vino gris
Ajustable y cómodo: Sistema de dial de ajuste y correas ajustables
Ventilación: 21 rejillas de ventilación individuales que mantendrán a los niños extremadamente frescos y cómodos para horas de ciclismo, patinaje
Seguridad certificada: Cumple con CE EN 1078:2012+a1:2012, Diseño, Ligero,
Producto seguro: 100% garantía de satisfacción
Material: Utilizando la última tecnología en molde, carcasa y espuma EPS fusionada en una sola pieza
Ideal: Para proteger de cualquier caida a nuestros pequeños', 'IN_STOCK', 15.99, 10, 0, 4);
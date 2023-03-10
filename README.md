# Figuritas Mundial 2022 ( Java - En Español)
Proyecto con Java 8 - jUnit - Metodologia TDD - Practica - Programación Basica II - UNLAM

Es un proyecto simple, con la finalidad de realizar prácticas en Java e implementar la metodología TDD 
¿Que es TDD? Es una metodología de desarrollo cuyo objetivo es crear primero las pruebas y luego escribir el software. Sus siglas en Inglés son: Test Driven Development y en español significa: Desarrollo guiado por pruebas.

Enunciado:
Desarrollo digital del álbum de figuritas del mundial.
Cada figurita está compuesta por su código identificatorio, la letra del grupo al que pertenece, la selección,
el nombre del jugador y el valor del jugador en el mercado.

El sistema puede tener dos tipos de usuarios registrados. Los administradores, quienes son los encargados
de administrar toda la información de las figuritas que se van a comercializar, y los usuarios finales que son
los que en definitiva jugarán.

Según el tipo de usuario es la acción por realizar, por ejemplo, el método agregarFigurita de un usuario
administrador se encarga de dar de alta una nueva figurita con sus características. Ahora bien, el método
agregarFigurita de un usuario final en realidad lo que hace es agregar esa figurita en el stock disponible
para ese usuario.

Tanto la base de datos de figurita generada por los administradores como el stock de figuritas de cada
usuario deben estar ordenados por grupo, selección y número de figurita en la selección.
Las figuritas tienen un identificador único que está compuesto por la selección y el número de figurita
(cada selección tiene alrededor de 22 jugadores). Si un administrado intenta dar de alta un código ya
existente, el sistema debe arrojar la excepción “CodigoExistente”.

A diferencia de lo que ocurre a nivel administrador, cuando un usuario final agregue una nueva figurita a su
stock, estas pueden repetirse.
El usuario final tiene la posibilidad de pegarFigurita en su álbum. Si un usuario final intenta pegar una
figurita que ya había pegado previamente, el sistema debe arrojar la excepción “FiguritaRepetida”.
Por último, el sistema debe permitir el intercambio de figuritas entre distintos usuarios. Si por alguna
razón, un usuario intenta intercambiar una figurita que no posee o que YA HABIA PEGADO, el sistema debe
lanzar la excepción “FiguritaNoDisponible”.

# World Cup Album 2022 ( Java - In English)
Project with Java 8 - jUnit - TDD Methodology - Practice - Basic Programming II - UNLAM

It is a simple project, with the purpose of carrying out practices in Java and implementing the TDD methodology
What is TDD? It is a development methodology whose objective is to first create the tests and then write the software.

Statement:
Digital version of the World Cup Album.
Each figurine is made up of its identification code, the letter of the group to which it belongs, the selection,
the player's name and the player's market value.

The system can have two types of registered users. The administrators, who are in charge
to manage all the information of the figurines that are going to be marketed, and the end users who are
those who will ultimately play.

Depending on the type of user, it is the action to be performed, for example, the method addFigure of a user
The administrator is in charge of registering a new figure with its characteristics. Now the method
add an end user figurine actually what it does is add that figurine in the available stock
for that user.

Both the figurine database generated by the administrators and the stock of figurines of each
user must be sorted by group, selection and number of figure in the selection.
The figurines have a unique identifier that is made up of the selection and the figurine number
(each selection has around 22 players). If an administrator tries to register a code already
existing, the system should throw the exception "Existing Code".

Unlike what happens at the administrator level, when an end user adds a new figurine to their
stock, these can be repeated.
The end user has the possibility to paste Figurine in his album. If an end user tries to paste a
figure that had already pasted previously, the system should throw the exception "Repeated Figure".
Finally, the system must allow the exchange of figurines between different users. if for some
reason, a user tries to exchange a figurine that he does not own or that HAD ALREADY PASTED, the system must
throw the exception "FigureNotAvailable".

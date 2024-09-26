package org.example.EjercicioADA

fun main() {
    val repo = RepositoryCotización()

       val diccionarioDatos= repo.LeerFichero();
        repo.EscribirDatos(diccionarioDatos);

}
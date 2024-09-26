package org.example.EjercicioADA

import java.io.BufferedReader
import java.io.BufferedWriter
import java.nio.file.Files
import java.nio.file.Path

class RepositoryCotización {
    fun LeerFichero(): MutableMap<String, List<String>> {
        val FicheroPrueba = Path.of("src/main/resources/HojaCotizaciones.txt");
        val br: BufferedReader = Files.newBufferedReader(FicheroPrueba);
        val diccionario = mutableMapOf<String, List<String>>();

        br.use { flujo ->
            flujo.forEachLine { linea ->
                val encabezados = linea.split(";")
                diccionario[encabezados[0]] = listOf(encabezados[1], encabezados[2], encabezados[3], encabezados[4])
            }
        }
        return diccionario;
    }

    fun EscribirDatos(diccionario: MutableMap<String, List<String>>) {
            val listaDouble = mutableListOf<Double>()
            diccionario.forEach { nombre, numeros ->
                numeros.forEach { numString ->
                    val formattedNum = numString.replace(".", "").replace(",", ".")
                    listaDouble.add(formattedNum.toDouble())
                }
            }
            val RutaDestino = Path.of("src/main/resources/RutaFinal.txt")
            val bw: BufferedWriter = Files.newBufferedWriter(RutaDestino);

            bw.use { flujo ->
                diccionario.forEach { nombre, numeros ->

                    val maximo = listaDouble[1]
                    val minimo = listaDouble[2]
                    val media = (listaDouble[1] + listaDouble[2]) / 2

                    flujo.write(nombre + " " + maximo + " " + minimo + " " + media + "\n");

                }
            }
        }
    }

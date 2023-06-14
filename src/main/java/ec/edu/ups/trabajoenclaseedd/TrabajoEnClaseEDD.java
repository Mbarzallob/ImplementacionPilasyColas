/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.ups.trabajoenclaseedd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 *
 * @author SOPORTETICS
 */
public class TrabajoEnClaseEDD {

    public static void main(String[] args) {

        System.out.println("Colas y pilas implementacion generica");

        ColaTareas<String> colaTareas = new ColaTareas<>();
        ColaTareas<Integer> colaTareasInt = new ColaTareas<>();
        ColaTareas<int[]> colaTareasArregloEnteros = new ColaTareas<>();
        ColaTareas<String[]> colaTareasArregloString = new ColaTareas<>();

        PilaTareas<Integer> pilaTareas = new PilaTareas<>();
        PilaTareas<ColaTareas> pilaTareasDeColas = new PilaTareas<>();

        colaTareas.agregarTarea(new Tarea(1, "Tarea 1"));
        colaTareas.agregarTarea(new Tarea(2, "Tarea 2"));
        colaTareas.agregarTarea(new Tarea(3, "Tarea 3"));

        colaTareasInt.agregarTarea(new Tarea(1, 1));
        colaTareasInt.agregarTarea(new Tarea(2, 2));
        colaTareasInt.agregarTarea(new Tarea(3, 3));

        colaTareasArregloEnteros.agregarTarea(new Tarea(1, new int[]{1, 2, 3}));
        colaTareasArregloEnteros.agregarTarea(new Tarea(2, new int[]{4, 5, 6}));
        colaTareasArregloEnteros.agregarTarea(new Tarea(3, new int[]{7, 8, 9}));

        colaTareasArregloString.agregarTarea(new Tarea(1, new String[]{"Tarea 1", "Tarea 2", "Tarea 3"}));
        colaTareasArregloString.agregarTarea(new Tarea(2, new String[]{"Tarea 4", "Tarea 5", "Tarea 6"}));
        colaTareasArregloString.agregarTarea(new Tarea(3, new String[]{"Tarea 7", "Tarea 8", "Tarea 9"}));

        pilaTareas.agregarTarea(new Tarea(1, 1));
        pilaTareas.agregarTarea(new Tarea(2, 2));
        pilaTareas.agregarTarea(new Tarea(3, 3));

        pilaTareasDeColas.agregarTarea(new Tarea(1, colaTareas));
        pilaTareasDeColas.agregarTarea(new Tarea(2, colaTareasArregloEnteros));
        pilaTareasDeColas.agregarTarea(new Tarea(3, colaTareasInt));
        pilaTareasDeColas.agregarTarea(new Tarea(4, colaTareasArregloString));

        System.out.println("COLA TAREAS");
        while (!colaTareas.estaVacia()) {
            Tarea<String> tareaProcesada = colaTareas.procesarTarea();

            System.out.println("Procesando tarea de la cola: \n\t Sale--> " + tareaProcesada.getId() + " - " + tareaProcesada.getAtributo());
        }
        System.out.println("COLA TAREAS ENTEROS");
        while (!colaTareasInt.estaVacia()) {
            Tarea<Integer> tareaProcesada = colaTareasInt.procesarTarea();

            System.out.println("Procesando tarea de la cola: \n\t Sale--> " + tareaProcesada.getId() + " - " + tareaProcesada.getAtributo());
        }
        System.out.println("COLA TAREAS ARREGLOS ENTEROS");
        while (!colaTareasArregloEnteros.estaVacia()) {
            Tarea<int[]> tareaProcesada = colaTareasArregloEnteros.procesarTarea();

            System.out.println("Procesando tarea de la cola: \n\t Sale--> " + tareaProcesada.getId() + " - " + Arrays.toString(tareaProcesada.getAtributo()));
        }
        
        System.out.println("COLA TAREAS ARREGLO STRING");

        while (!colaTareasArregloString.estaVacia()) {
            Tarea<String[]> tareaProcesada = colaTareasArregloString.procesarTarea();

            System.out.println("Procesando tarea de la cola: \n\t Sale--> " + tareaProcesada.getId() + " - " + Arrays.toString(tareaProcesada.getAtributo()));
        }

        System.out.println("PILA TAREAS");
        while (!pilaTareas.estaVacia()) {
            Tarea<Integer> tareaProcesada = pilaTareas.procesarTarea();

            System.out.println("Procesando tarea de la pila: \n\t Sale--> " + tareaProcesada.getId() + " - " + tareaProcesada.getAtributo());

        }
        
        System.out.println("PILA TAREAS DE COLAS");
        while(!pilaTareasDeColas.estaVacia()){
            Tarea<ColaTareas> tareaProcesada = pilaTareasDeColas.procesarTarea();
            
            System.out.println("Procesando tarea de la pila: \n\t Sale-->"+tareaProcesada.getId()+ " - " +tareaProcesada.toString());
        }
    }

}

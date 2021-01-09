package de.iotoi

fun main() {
    // Use the normal `class HelloLib`
    println(HelloLib().greeting)

    var helloLib = HelloLib()
    helloLib.greeting = "Hallo Welt!"
    println(helloLib.greeting)


    // Use the special `data class DataHelloLib`
    println(DataHelloLib().greeting)

    var dataHelloLib = DataHelloLib()
    dataHelloLib.greeting = "Hallo"
    println(dataHelloLib.greeting)

    
    // Use different styles
    println(helloLib.greeting2)
    println(helloLib.greeting3)
}

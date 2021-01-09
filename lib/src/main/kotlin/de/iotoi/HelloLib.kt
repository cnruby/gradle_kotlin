package de.iotoi

class HelloLib {
    var greeting: String = "Hello World!"
        get() {
            return field
        }
        set(value) {
            field = value
        }

    var greeting2: String = "Hallo Welt!"
        get() = field
        set(value) {
            field = value
        }

    var greeting3: String = "世界，你好!"
        get(): String = field
        set(value) {
            field = value
        }        
}

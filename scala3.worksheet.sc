def add(x: Int)(using y: Int): Int = x + y

given instance: Int = 10

add(1)
add(1)(5)

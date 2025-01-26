package agh.ics.oop.model

fun <K, V> Map<K, V>.randomPosition(): K? {
    val keys = this.keys.toList()
    val randomIndex = (0 until keys.size).random()
    return keys[randomIndex]
}

fun <V> Map<Vector2d, V>.randomFreePosition(mapSize: Vector2d): Vector2d? {
    val keys = this.keys.toList()
    val possiblePositions = mutableListOf<Vector2d>()
    for (i in 0..<mapSize.x) {
        for (j in 0..<mapSize.y) {
            val position = Vector2d(i, j)
            possiblePositions.add(position)
        }
    }
    val freePositions = possiblePositions.filter { !this.containsKey(it) }
    if (freePositions.isEmpty()) return null
    return freePositions[freePositions.indices.random()]
}
package de.jensklingenberg.composesnake

inline fun <T : Any> List<T>.forEachFast(block: (T) -> Unit) {
    for (i in indices) {
        block(get(i))
    }
}

package vi_generics.generics

import java.util.ArrayList
import java.util.HashSet
import util.TODO

fun task28() = TODO(
        """
        Task28.
        Add function 'partitionTo' that splits collection in two collections according to a predicate.
        Uncomment the commented invocations of 'partitionTo' below and make them compile.

        There is the function 'partition()' in the standard library that always returns two lists (newly created).
        You shall write a function that splits the collection in two given collections as arguments.
        The signature of the function 'toCollection()' from standard library may help you.
    """,
        references = {(l: List<Int>) ->
            l.partition { it > 0 }
            l.toCollection(HashSet<Int>())
        }
)

fun List<String>.partitionWordsAndLines(): Pair<List<String>, List<String>> {
    //    task28()
    return this.partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
}

//public fun <T, C : MutableCollection<in T>> Iterable<T>.toCollection(collection: C) :C {
//    for (item in this) {
//        collection.add(item)
//    }
//    return collection
//}

fun <T, C : MutableCollection<in T>> Iterable<T>.partitionTo(first: C, second: C, predicate: (T) -> Boolean): Pair<C, C> {
    for (item in this) {
        if (predicate(item)) {
            first.add(item)
        } else {
            second.add(item)
        }
    }
    return Pair(first, second)
}

fun Set<Char>.partitionLettersAndOtherSymbols(): Pair<Set<Char>, Set<Char>> {
    //    task28()
    return partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }
}

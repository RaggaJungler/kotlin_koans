package v_collections

fun example8() {
    val numbers = listOf(1, 3, -4, 2, -11)

    //the details (how multi-assignment works) were explained in 'Conventions' task earlier
    val (positive, negative) = numbers.partition { it > 0 }

    positive == listOf(1, 3, 2)
    negative == listOf(-4, -11)
}

fun isSuited(orders : Pair<List<Boolean>, List<Boolean>> ) : Boolean {
    return orders.second.size() > orders.first.size()
}

fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
    // Return customers who have more undelivered orders than delivered
    //    todoCollectionTask()

    println(customers.partition { isSuited(it.orders.map { it.isDelivered }.partition { it }) })
    return customers.partition { isSuited(it.orders.map { it.isDelivered }.partition { it }) }.first.toSet()
}

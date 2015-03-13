package v_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    //    todoCollectionTask()
    return customers.filter { it.orders.flatMap { it.products }.contains(product) }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive among delivered products
    // (use Order.isDelivered flag)
    //    todoCollectionTask()
    return orders.filter { it.isDelivered }.flatMap { it.products }.maxBy { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Returns number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
//    todoCollectionTask()
    return customers.flatMap { it.orders }.flatMap { it.products }.filter { it.equals(product) }.size()
}

package v_collections



fun example() {

    val result = listOf("abc", "12").flatMap { it.toCharList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts: Set<Product> get() {
    // Return all products ordered by customer
//    todoCollectionTask()
//    return this.orderedProducts.flatMap { it }
    return this.orders.flatMap { it.products }.toSet()
}

val Shop.allOrderedProducts: Set<Product> get() {
    // Return all products ordered by all customers
//    todoCollectionTask()
    return customers.flatMap { it.orders}.flatMap { it.products }.toSet()
}

package ii_conventions


data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    override fun compareTo(other: MyDate): Int {
        return (this.year - other.year) * 10000 + (this.month - other.month) * 100 + this.dayOfMonth - other.dayOfMonth
    }



}

fun MyDate.plus(interval :RepeatedTimeInterval) : MyDate {
    return when(interval){
        TimeInterval.DAY -> MyDate(this.year, this.month, this.dayOfMonth + 1)
        TimeInterval.WEEK -> MyDate(this.year, this.month + 1, this.dayOfMonth)
        TimeInterval.YEAR -> MyDate(this.year + 1, this.month, this.dayOfMonth)
    }
}

fun MyDate.rangeTo(date: MyDate) : DateRange {
    return DateRange(this, date)
}

enum class TimeInterval {
    DAY
    WEEK
    YEAR

}

fun TimeInterval.times() : TimeInterval {
    return TimeInterval()
}

class RepeatedTimeInterval(val ti: TimeInterval, val n: Int)

class DateRange(public override val start: MyDate, public override val end: MyDate) : Iterable<MyDate>, Range<MyDate> {

    override fun contains(item: MyDate): Boolean = start <= item && item <= end

    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {

            var current: MyDate = start

            override fun next(): MyDate {
                val result = current
                current = current.nextDay()
                return result
            }

            override fun hasNext(): Boolean = current <= end
        }

    }
}

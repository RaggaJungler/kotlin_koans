package ii_conventions


data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    override fun compareTo(other: MyDate): Int {
        return (this.year - other.year) * 10000 + (this.month - other.month) * 100 + this.dayOfMonth - other.dayOfMonth
    }



}

fun MyDate.plus(interval :TimeInterval) : MyDate {
    return addTimeIntervals(interval, 1)
}

fun MyDate.plus(interval :RepeatedTimeInterval) : MyDate {
    return addTimeIntervals(interval.ti, interval.n)
}

fun MyDate.rangeTo(date: MyDate) : DateRange {
    return DateRange(this, date)
}

enum class TimeInterval {
    DAY
    WEEK
    YEAR
}

fun TimeInterval.times(value : Int) : RepeatedTimeInterval {
    return RepeatedTimeInterval(this, value)
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

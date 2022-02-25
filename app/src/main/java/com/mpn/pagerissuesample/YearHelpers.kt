package com.mpn.pagerissuesample

import java.time.Year

/**
 * We're implementing some operators of Java classes, so we need to do it via extension functions
 * Needed to be able to have year ranges and iterate through them
 */

class YearRange(override val start: Year,
                override val endInclusive: Year
) : ClosedRange<Year>, Iterable<Year>{

    init {
        require(start < endInclusive) {
            "Start must be before endInclusive"
        }
    }

    override fun iterator(): Iterator<Year> {
        return YearIterator(start, endInclusive)
    }
}

class YearIterator(start: Year, private val endInclusive: Year) : Iterator<Year> {

    var initValue = start

    override fun hasNext(): Boolean {
        return initValue <= endInclusive
    }

    override fun next(): Year {
        return initValue++
    }

}
operator fun Year.inc(): Year = this.plusYears(1)